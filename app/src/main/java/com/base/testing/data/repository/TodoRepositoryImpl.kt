package com.base.testing.data.repository

import com.base.testing.data.local.TodoDao
import com.base.testing.domain.model.Todo
import com.base.testing.utils.toDomain
import com.base.testing.utils.toEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
) {
    suspend fun getTodos(): List<Todo> = dao.getTodos().map { it.toDomain() }
    suspend fun insertTodo(todo: Todo) = dao.insertTodo(todo.toEntity())
    suspend fun deleteTodo(todo: Todo) = dao.deleteTodo(todo.toEntity())
}