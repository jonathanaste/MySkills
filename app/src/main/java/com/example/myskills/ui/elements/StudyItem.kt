package com.example.myskills.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskills.ui.models.Education
import com.example.myskills.ui.models.Skill
import com.example.myskills.ui.theme.MySkillsTheme

@Composable
fun StudyItem(study: Education) {
    Column(modifier = Modifier.padding(4.dp).fillMaxWidth()) {
        Text(text = study.title, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W600))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "${study.institution} \n${study.startDate} - ${study.endDate}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun StudyItemItemPreview() {
    MySkillsTheme { // Apply your app's theme (optional)
        SkillItem(skill = Skill("Android Development", "Advanced"))
    }
}