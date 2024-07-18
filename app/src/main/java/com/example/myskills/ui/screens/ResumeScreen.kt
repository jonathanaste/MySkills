package com.example.myskills.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskills.ResumeViewModel
import com.example.myskills.ui.SkillItem
import com.example.myskills.ui.StudyItem
import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.myskills.R

@Composable
fun ResumeScreen(viewModel: ResumeViewModel, modifier: Modifier) {
    val resume by viewModel.resumes.collectAsState()

    when (resume) {
        null -> CircularProgressIndicator()
        is Resume -> ResumeContent(resume as Resume, modifier)
    }

}

@Composable
fun ResumeContent(resume: Resume, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            val painter = rememberAsyncImagePainter(
                model = resume.name,
                placeholder = painterResource(id = R.mipmap.ic_launcher_round2),
                error = painterResource(id = R.mipmap.ic_launcher_round2)
            )

            Box {
                Image(
                    painter = painter,
                    contentDescription = "Profile Picture",
                    modifier = modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                // Loading indicator
                if (painter.state is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        item {
            Text(
                text = resume.name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = resume.phone,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        item {
            Text(
                text = resume.email,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        // ... (Other sections like Personal Info, Experience, Education)

        //Studies Section
        item {
            Text(
                text = "Education",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        items(resume.studies) { education ->
            StudyItem(education)
        }

        item {
            Text(
                text = "Skills",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        // Skills Section

        items(resume.skills) { skill ->
            SkillItem(skill)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ResumeScreenPreview() {
    ResumeContent(
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
        modifier = Modifier
            .wrapContentHeight()
    )
}