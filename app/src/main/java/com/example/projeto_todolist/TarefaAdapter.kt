package com.example.projeto_todolist

import Data.Tarefa
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database


class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    private val tarefas = mutableListOf<Tarefa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tarefa_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.tarefaTextTextView.text = tarefa.text
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TarefaDetailActivity::class.java)
            intent.putExtra("tarefa_id", tarefa.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tarefaTextTextView: TextView = itemView.findViewById(R.id.tarefaTextTextView)
    }
}