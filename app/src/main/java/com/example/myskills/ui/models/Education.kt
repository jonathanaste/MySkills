package com.example.myskills.ui.models

data class Education(
    val institution: String,
    val title: String,
    val startDate: String,
    private val _endDate: String,
    val description: String
){
    val endDate
    get() = if (_endDate.isEmpty()) "Present" else _endDate
}
