package com.example.studentsapp.model

data class Student(
    val name: String,
    val id: String,
    val phone: String,
    val address: String,
    val avatarUrl: String,
    var isChecked: Boolean
)
