package com.base.testing.utils

import com.base.testing.data.local.TodoEntity
import com.base.testing.domain.model.Todo

fun TodoEntity.toDomain(): Todo {
    return Todo(
        id = id,
        title = title,
        isDone = isDone
    )
}

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        isDone = isDone
    )
}