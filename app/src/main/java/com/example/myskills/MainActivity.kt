package com.example.myskills

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill
import com.example.myskills.ui.screens.ResumeScreen
import com.example.myskills.ui.theme.MySkillsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySkillsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ResumeScreen(
                        Resume(
                            name = "Jonathan Roberto Aste",
                            phone = "+5491134166724",
                            email = "Jonathan.aste@gmail.com",
                            studies = listOf(
                                Education(
                                    institution = "Universidad Argentina De la Empresa",
                                    title="Bacherlor of Computer Science",
                                    startDate = "03/2011",
                                    endDate = "06/2016",
                                    description = ""
                                ),
                                Education(
                                    institution = "Android Codelabs",
                                    title="Android Developer",
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
                            )
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
