package dev.aalhdydy550.toolchaintest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.aalhdydy550.toolchaintest.data.AppDatabase
import dev.aalhdydy550.toolchaintest.data.NoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "toolchain-test.db")
            .fallbackToDestructiveMigration(true)
            .build()

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao = database.noteDao()
}
