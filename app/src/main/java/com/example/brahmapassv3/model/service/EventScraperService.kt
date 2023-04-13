package com.example.brahmapassv3.model.service

import com.example.brahmapassv3.EventScraper

fun EventScraperService() {
    val eventScraper = EventScraper()
    eventScraper.HTMLScraper()
}