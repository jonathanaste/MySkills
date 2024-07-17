package com.example.myskills.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskills.ui.SkillItem
import com.example.myskills.ui.StudyItem
import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill

@Composable
fun ResumeScreen(resume: Resume, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // ... (Other sections like Personal Info, Experience, Education)
        Text(
            text = resume.name,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
        )
        //Studies Section
        Text(
            text = "Education",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        LazyColumn {
            items(resume.studies) { education ->
                StudyItem(education)
            }
        }

        // Skills Section
        Text(
            text = "Skills",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        LazyColumn {
            items(resume.skills) { skill ->
                SkillItem(skill)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResumeScreenPreview() {
    ResumeScreen(
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
        ),
    )
}