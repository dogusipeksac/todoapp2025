package com.base.testing.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.testing.domain.model.Todo
import com.base.testing.domain.usecase.AddTodoUseCase
import com.base.testing.domain.usecase.DeleteTodoUseCase
import com.base.testing.domain.usecase.GetTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : ViewModel() {
    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> get() = _todoList

    fun loadTodos() {
        viewModelScope.launch {
            _todoList.value = getTodosUseCase()!!
        }
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            addTodoUseCase(todo)
            loadTodos()
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
            loadTodos()
        }
    }
}