package project.st991438136.alex.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.card_runs.view.*
import project.st991438136.alex.R
import project.st991438136.alex.database.read.Running

class RecyclerViewRun(
    private val list: ArrayList<Running>
) : RecyclerView.Adapter<RecyclerViewRun.RecyclerViewHolder>() {

    private lateinit var database: DatabaseReference

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.dateRun
        val duration: TextView = itemView.durationRun
        val distance: TextView = itemView.distance
        val speed: TextView = itemView.avgSpeed
        val edit: Button = itemView.btnEditRun
        val delete: Button = itemView.btnDeleteRun


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_runs, parent,false)

        database = Firebase.database.reference.child("running")

        return RecyclerViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentRun = list[position]
        holder.date.text = "Date: ${currentRun.date}"
        holder.duration.text = "Duration: ${currentRun.duration}"
        holder.distance.text = "Distance: ${currentRun.distance}"
        holder.speed.text = "Avg Speed: ${currentRun.avgSpeed}"

        holder.edit.setOnClickListener { view: View? ->

            var bundle = Bundle()
            bundle.putString("date",currentRun.date)
            bundle.putString("duration",currentRun.duration)
            bundle.putString("distance",currentRun.distance)
            bundle.putString("speed",currentRun.avgSpeed)

            view?.findNavController()?.navigate(R.id.action_viewRunningFragment_to_fragmentUpdateRun,bundle)



        }

        holder.delete.setOnClickListener { view:View? ->
            database.child(currentRun.date).removeValue()
        }

    }

    override fun getItemCount(): Int = list.size

}