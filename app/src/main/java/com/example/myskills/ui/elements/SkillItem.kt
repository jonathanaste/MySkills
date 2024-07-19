package com.example.myskills.ui.elements

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myskills.ui.models.Skill
import com.example.myskills.ui.theme.MySkillsTheme

@Composable
fun SkillItem(skill: Skill) {
    Row(modifier = Modifier.padding(4.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = skill.name, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "(${skill.proficiency})", style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun SkillItemPreview() {
    MySkillsTheme { // Apply your app's theme (optional)
        SkillItem(skill = Skill("Android Development", "Advanced"))
    }
}