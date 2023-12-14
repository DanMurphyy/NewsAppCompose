package com.danmurphyy.newsappcompose.di

import android.app.Application
import com.danmurphyy.newsappcompose.data.managerImp.LocalUserManagerImp
import com.danmurphyy.newsappcompose.domain.manager.LocalUserManager
import com.danmurphyy.newsappcompose.domain.usecases.AppEntryUseCases
import com.danmurphyy.newsappcompose.domain.usecases.ReadAppEntry
import com.danmurphyy.newsappcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}