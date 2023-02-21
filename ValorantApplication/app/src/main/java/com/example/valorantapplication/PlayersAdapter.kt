package com.example.valorantapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class PlayersAdapter(private val playerList: ArrayList<ListPlayers>) :
      RecyclerView.Adapter<PlayersAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_quiz,
            parent, false
        )

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = playerList[position]

        holder.quizUsername.text = currentItem.quizUsername
        holder.category.text = currentItem.category
        holder.points.text = currentItem.points
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quizUsername: TextView = itemView.findViewById(R.id.quizUsername)
        val category: TextView = itemView.findViewById(R.id.category)
        val points: TextView = itemView.findViewById(R.id.quizPoints)
    }
}