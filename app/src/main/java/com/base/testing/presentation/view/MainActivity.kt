package com.base.testing.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.testing.databinding.ActivityMainBinding
import com.base.testing.domain.model.Todo
import com.base.testing.presentation.view.adapter.TodoAdapter
import com.base.testing.presentation.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        setContentView(binding.root)

        val adapter = TodoAdapter(emptyList()) { todo -> viewModel.deleteTodo(todo) }

        binding.recyclerviewTaskList.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewTaskList.adapter = adapter
        viewModel.todoList.observe(this) { adapter.updateList(it) }

        binding.addTaskButton.setOnClickListener {
            val title = binding.usernameEditText.text.toString()
            if (title.isNotEmpty()) {
                viewModel.addTodo(Todo(0, binding.usernameEditText.text.toString(), true))
                binding.usernameEditText.text.clear()
            }
        }
        viewModel.loadTodos()
    }
}