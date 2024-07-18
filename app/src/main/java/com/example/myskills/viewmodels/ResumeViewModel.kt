package com.example.myskills.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myskills.repositories.ResumeRepository
import com.example.myskills.ui.models.Resume
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class ResumeViewModel @Inject constructor() : ViewModel() {
    val resumes: StateFlow<Resume?> = ResumeRepository().getResumes().stateIn(
        scope= viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )
}