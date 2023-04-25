package com.example.brahmapassv3.model.service.impl

import com.example.brahmapassv3.model.Exit
import com.example.brahmapassv3.model.service.AccountService
import com.example.brahmapassv3.model.service.StorageService
import com.example.brahmapassv3.model.service.trace
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.tasks.await

class StorageServiceImpl
@Inject
constructor(private val firestore: FirebaseFirestore, private val auth: AccountService) :
    StorageService {

    @OptIn(ExperimentalCoroutinesApi::class)
    override val exits: Flow<List<Exit>>
        get() =
            auth.currentUser.flatMapLatest { user ->
                currentCollection(user.id).orderBy("time", Query.Direction.DESCENDING).snapshots().map { snapshot -> snapshot.toObjects() }
            }

    override suspend fun getExit(exitId: String): Exit? =
        currentCollection(auth.currentUserId).document(exitId).get().await().toObject()

    override suspend fun save(exit: Exit): String =
        trace(SAVE_EXIT_TRACE) { currentCollection(auth.currentUserId).add(exit).await().id }

    override suspend fun update(exit: Exit): Unit =
        trace(UPDATE_EXIT_TRACE) {
            currentCollection(auth.currentUserId).document(exit.id).set(exit).await()
        }

    override suspend fun delete(exitId: String) {
        currentCollection(auth.currentUserId).document(exitId).delete().await()
    }

    // TODO: It's not recommended to delete on the client:
    // https://firebase.google.com/docs/firestore/manage-data/delete-data#kotlin+ktx_2
    override suspend fun deleteAllForUser(userId: String) {
        val matchingExits = currentCollection(userId).get().await()
        matchingExits.map { it.reference.delete().asDeferred() }.awaitAll()
    }

    private fun currentCollection(uid: String): CollectionReference =
        firestore.collection(USER_COLLECTION).document(uid).collection(EXIT_COLLECTION)
    companion object {
        private const val USER_COLLECTION = "users"
        private const val EXIT_COLLECTION = "exits"
        private const val SAVE_EXIT_TRACE = "saveExit"
        private const val UPDATE_EXIT_TRACE = "updateExit"
    }
}
