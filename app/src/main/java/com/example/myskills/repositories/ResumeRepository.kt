package com.example.myskills.repositories

import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Experience
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ResumeRepository {
    fun getResumes(): Flow<Resume> {
        return flowOf(
            Resume(
                name = "Jonathan Roberto Aste",
                position = "Android Engineer",
                phone = "+5491134166724",
                email = "Jonathan.aste@gmail.com",
                studies = listOf(
                    Education(
                        institution = "Universidad Argentina De la Empresa",
                        title = "Bacherlor of Computer Science",
                        startDate = "03/2011",
                        _endDate = "06/2016",
                        description = ""
                    ),
                    Education(
                        institution = "Android Codelabs",
                        title = "Android Developer",
                        startDate = "03/2020",
                        _endDate = "",
                        description = ""
                    )
                ),
                experiences =  listOf(
                    Experience(
                        position = "Android Engineer",
                        company = "La Nacion",
                        years= "May 2021 - April 2024 (3 years)",
                        responsibilities = listOf() // Add responsibilities if needed
                    ),
                    Experience(
                        position = "Android Developer Ssr",
                        company = "Globant",
                        years = "May 2019 - February 2020 (10 months)",
                        responsibilities = listOf() // Add responsibilities if needed
                    ),
                    Experience(
                        position = "Android Developer Ssr",
                        company = "PlayTown S.A.",
                        years = "November 2016 - September 2017 (11 months)",
                        responsibilities = listOf() // Add responsibilities if needed
                    ),
                    Experience(
                        position = "Android Developer Jr",
                        company = "Batanga Media",
                        years = "January 2016 - September 2016 (9 months)",
                        responsibilities = listOf("Desarrollo de apps en plataforma Android.")
                    ),
                    Experience(
                        position = "BI Consultant",
                        company = "Taligent",
                        years = "July 2015 - July 2015 (1 month)",
                        responsibilities = listOf() // Add responsibilities if needed
                    ),
                    Experience(
                        position = "BI Consultant",
                        company = "DataIQ",
                        years = "July 2013 -  May 2015 (1 year 11 months)",
                        responsibilities = listOf() // Add responsibilities if needed
                    )
                ),
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