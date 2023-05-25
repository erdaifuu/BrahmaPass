package com.example.brahmapassv3.model.service

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewModelScope
import com.example.brahmapassv3.EventScraper
import com.example.brahmapassv3.common.snackbar.SnackbarManager
import com.example.brahmapassv3.common.snackbar.SnackbarMessage.Companion.toSnackbarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

var MonthEventList = ArrayList<String>()
fun eventScraperService() {
    val eventScraper = EventScraper()
    eventScraper.HTMLScraper()

}
suspend fun printScrape(){
    delay(1000L)
    Log.d("EventScraper", MonthEventList.toString())
}

fun grabEventList(
    EventList: ArrayList<String>
) {
    MonthEventList = EventList
    var NewEventList = ArrayList<String>()

    val current = LocalDate.now()
    val month = current.monthValue.toString()
    val date = current.dayOfMonth
    val charLength = month.length
    var todayFirstEvent = ""

    for (str in EventList) {
        if (date >= str.substring(month.length, charLength).toInt()) {
            Log.d("EDate", "$month / $date \n" + str.substring(0, charLength))
            todayFirstEvent = str;
            break;
        }
    }
    Log.d("EDate", todayFirstEvent)

    //if ()
}


