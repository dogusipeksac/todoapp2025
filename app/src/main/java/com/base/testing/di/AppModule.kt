package com.base.testing.di

import android.content.Context
import androidx.room.Room
import com.base.testing.data.local.TodoDao
import com.base.testing.data.local.TodoDatabase
import com.base.testing.data.repository.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db").build()

    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao()

    @Provides
    fun provideRepository(dao: TodoDao): TodoRepositoryImpl = TodoRepositoryImpl(dao)
}
