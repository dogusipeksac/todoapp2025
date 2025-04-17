package com.base.testing.domain.usecase

import com.base.testing.data.repository.TodoRepositoryImpl
import javax.inject.Inject

/*
operator	Sınıfı fonksiyon gibi çağırabilmeni sağlar.
invoke(...)	Sınıf çağrıldığında çalışacak fonksiyon.
suspend	Coroutine içinde çağrılması gerektiğini belirtir.
 */
class UpdateTodoUseCase @Inject constructor(
    private val repositoryImpl: TodoRepositoryImpl
) {}