package com.example.myskills.ui.models

data class Resume(
    val name: String,
    val position: String,
    val phone: String,
    val email: String,
    val studies: List<Education>,
    val experiences: List<Experience>,
    val skills: List<Skill>,
)
