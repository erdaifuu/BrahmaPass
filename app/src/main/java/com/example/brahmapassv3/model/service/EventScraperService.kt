package com.example.brahmapassv3.model.service

import android.util.Log
import com.example.brahmapassv3.EventScraper
import kotlinx.coroutines.delay
import java.time.LocalDate

var MonthEventList = ArrayList<String>()
var FirstEvent = String()
fun eventScraperService() {
    val text = "1/2/2023This is some more content."
    Log.d("EDate", addLineBreak(text))

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
    val newEventList = ArrayList<String>()
    Log.d("EDate", "Process Started")

    val current = LocalDate.now()
    val month = current.monthValue.toString()
    val date = current.dayOfMonth
    var charLength = month.length + 1
    var todayFirstEvent = ""

    val pastEventList = ArrayList<String>()

    for (str in EventList) {
        charLength++
        try {
            val day = str.substring(month.length + 1, charLength).toInt()
            if (date <= day) {
                if (newEventList.size == 0){
                    todayFirstEvent = addLineBreak(str)
                }
                newEventList.add(addLineBreak(str))
            } else {
                pastEventList.add(addLineBreak(str))
            }
        } catch (e: NumberFormatException) {
            charLength--
            val day = str.substring(month.length + 1, charLength).toInt()
            if (date <= day) {
                if (newEventList.size == 0){
                    todayFirstEvent = addLineBreak(str)
                }
                newEventList.add(addLineBreak(str))
            } else {
                pastEventList.add(addLineBreak(str))
            }
        }
        if (newEventList.size >= 5) break
    }

    if (newEventList.size < 5) {
        val remaining = 5 - newEventList.size
        newEventList.addAll(0, pastEventList.takeLast(remaining))
    }

    Log.d("EDate", newEventList.toString())
    Log.d("EDate", "Today's first event: $todayFirstEvent")
    MonthEventList = newEventList
    FirstEvent = todayFirstEvent

    //if ()
}

fun addLineBreak(content: String): String {
    val regex = Regex("""(\d{1,2}/\d{1,2}/\d{4})(.+)""")
    return content.replace(regex) { matchResult ->
        val (date, followingContent) = matchResult.destructured
        "$date\n${followingContent.drop(3)}"
    }
}



