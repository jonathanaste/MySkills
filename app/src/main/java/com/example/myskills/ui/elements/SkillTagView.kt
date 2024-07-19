package com.example.myskills.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myskills.ui.models.Skill

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillTagView(skills: List<Skill>) {
    FlowRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        skills.forEach { skill ->
            Surface(
                modifier = Modifier.clip(CircleShape).padding(vertical = 4.dp)
            ) {
                Row(modifier = Modifier.background(Color.LightGray).padding(vertical=4.dp, horizontal = 6.dp)) {
                    Text(text = skill.name, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "(${skill.proficiency})",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

        }
    }
}