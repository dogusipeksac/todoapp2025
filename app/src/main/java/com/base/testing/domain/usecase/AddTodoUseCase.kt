package com.base.testing.domain.usecase

import com.base.testing.data.repository.TodoRepositoryImpl
import com.base.testing.domain.model.Todo
import javax.inject.Inject

/*
operator	Sınıfı fonksiyon gibi çağırabilmeni sağlar.
invoke(...)	Sınıf çağrıldığında çalışacak fonksiyon.
suspend	Coroutine içinde çağrılması gerektiğini belirtir.
 */
class AddTodoUseCase @Inject constructor(
    private val repositoryImpl: TodoRepositoryImpl
) {
    suspend operator fun invoke(todo: Todo) {
        repositoryImpl.insertTodo(todo)
    }
}