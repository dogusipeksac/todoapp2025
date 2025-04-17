package com.base.testing.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.testing.R
import com.base.testing.databinding.TodoItemBinding
import com.base.testing.domain.model.Todo

class TodoAdapter(
    private var todos: List<Todo>,
    private val onItemClick: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.textViewTitle.text = todo.title
            binding.checkBox.isChecked = todo.isDone

            binding.root.setOnClickListener {
                onItemClick(todo)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int =
        todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    fun updateList(newList: List<Todo>) {
        todos = newList
        notifyDataSetChanged()
    }
}