package com.example.myskills.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskills.viewmodels.ResumeViewModel
import com.example.myskills.ui.elements.SkillItem
import com.example.myskills.ui.elements.StudyItem
import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Resume
import com.example.myskills.ui.models.Skill
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.myskills.R
import com.example.myskills.ui.elements.ExperienceItem
import com.example.myskills.ui.elements.SkillTagView

@Composable
fun ResumeScreen(modifier: Modifier = Modifier) {
    val viewModel: ResumeViewModel = hiltViewModel()
    val resume by viewModel.resumes.collectAsState()

    when (resume) {
        null -> CircularProgressIndicator()
        is Resume -> ResumeContent(resume as Resume, modifier)
    }

}

@Composable
fun ResumeContent(resume: Resume, modifier: Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        //region Header info
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
                    modifier = Modifier
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
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }

        item {
            Text(
                text = resume.position,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        //endregion

        //region Contact Information
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone Icon",
                    Modifier.size(16.dp)
                )
                Text(
                    text = resume.phone,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon",
                    Modifier.size(16.dp)

                )
                Text(
                    text = resume.email,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

        }
        //endregion

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                thickness = 1.dp
            )
        }

        //region Studies Section
        item {
            Text(
                text = "Education",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        items(resume.studies) { education ->
            StudyItem(education)
        }
        //endregion

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                thickness = 1.dp
            )
        }
        //region Skills Section
        item {
            Text(
                text = "Skills",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
        item {
            SkillTagView(resume.skills)
        }
        //endregion

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                thickness = 1.dp
            )
        }

        //region Experience Section
        item {
            Text(
                text = "Laboral Experience",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }

        items(resume.experiences) { experiences ->
            ExperienceItem(experiences)
        }
        //endregion

    }
}

@Preview(showBackground = true)
@Composable
fun ResumeScreenPreview() {
    ResumeContent(
        Resume(
            name = "Jonathan Roberto Aste",
            position = "Android Developer",
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