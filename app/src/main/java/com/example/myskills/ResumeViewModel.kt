package com.example.myskills

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myskills.ui.models.Resume
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ResumeViewModel(private val repository: ResumeRepository) : ViewModel() {
    val resumes: StateFlow<Resume?> = repository.getResumes().stateIn(
        scope= viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )
}