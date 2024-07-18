package com.example.myskills.di

import com.example.myskills.repositories.ResumeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {@Provides
    fun provideResumeRepository(): ResumeRepository {
       return ResumeRepository()
    }
}