package com.example.myskills

import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ResumeRepository {
    fun getResumes(): Flow<Resume> {
        return flowOf(
            Resume(
                name = "Jonathan Roberto Aste",
                phone = "+5491134166724",
                email = "Jonathan.aste@gmail.com",
                studies = listOf(
                    Education(
                        institution = "Universidad Argentina De la Empresa",
                        title = "Bacherlor of Computer Science",
                        startDate = "03/2011",
                        endDate = "06/2016",
                        description = ""
                    ),
                    Education(
                        institution = "Android Codelabs",
                        title = "Android Developer",
                        startDate = "03/2020",
                        endDate = "-",
                        description = ""
                    )
                ),
                experiences = emptyList(),
                skills = listOf(
                    Skill("Kotlin", "4 years"),
                    Skill("Android", "9 years"),
                    Skill("Retrofit", "5 years"),
                    Skill("RXJava", "5 years"),
                    Skill("Compose", "1 years"),
                    Skill("Dagger", "2 years"),
                    Skill("Room", "5 years"),
                    Skill("English", "10 years")
                ),
            )

        )
    }

    suspend fun saveResume(resume: Resume) { /* ... */
    }
    // ...
}