package project.st991438136.alex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_weights.view.*
import project.st991438136.alex.R
import project.st991438136.alex.database.read.Weights

class RecyclerViewWeights(
    private val list: ArrayList<Weights>
) : RecyclerView.Adapter<RecyclerViewWeights.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.datefw
        val duration: TextView = itemView.durationfw
        val weightUsed: TextView = itemView.weightUsed
        val reps: TextView = itemView.reps


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_weights, parent,false)

        return RecyclerViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentFreeWeight = list[position]
        holder.date.text = "Date: ${currentFreeWeight.date}"
        holder.duration.text = "Duration: ${currentFreeWeight.duration}"
        holder.weightUsed.text = "Weight Used: ${currentFreeWeight.weightsUsed}"
        holder.reps.text = "Reps: ${currentFreeWeight.repsComplete}"
    }

    override fun getItemCount(): Int = list.size

}