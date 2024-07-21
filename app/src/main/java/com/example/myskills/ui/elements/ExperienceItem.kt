package com.example.myskills.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myskills.ui.models.Experience

@Composable
fun ExperienceItem(experience: Experience) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(
            text = "${experience.position} - ${experience.company}",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W600)
        )
        Text(text = experience.years, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(4.dp))
        // You can use FlowRow here to display responsibilities if needed, similar to SkillTagViewResponsibilitiesView(responsibilities = experience.responsibilities)
    }
}