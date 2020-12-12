package project.st991438136.alex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view_run.view.*
import project.st991438136.alex.R
import project.st991438136.alex.database.Running

class RecyclerViewAdapterRun(
    private val list: ArrayList<Running>
) : RecyclerView.Adapter<RecyclerViewAdapterRun.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.daterun
        val duration: TextView = itemView.durationrun
        val distance: TextView = itemView.distance
        val speed: TextView = itemView.speed


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_run, parent,false)

        return RecyclerViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentRun = list[position]
        holder.date.text = "Date: ${currentRun.date}"
        holder.duration.text = "Duration: ${currentRun.duration}"
        holder.distance.text = "Distance: ${currentRun.distance}"
        holder.speed.text = "Avg Speed: ${currentRun.avgSpeed}"
    }

    override fun getItemCount(): Int = list.size

}