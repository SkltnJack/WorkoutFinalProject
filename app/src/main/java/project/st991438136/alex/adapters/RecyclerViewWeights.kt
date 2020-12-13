package project.st991438136.alex.adapters

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_weights.view.*
import project.st991438136.alex.R
import project.st991438136.alex.database.read.Weights
import project.st991438136.alex.fragment.view.FragmentViewWeights

class RecyclerViewWeights(
    private val list: ArrayList<Weights>
) : RecyclerView.Adapter<RecyclerViewWeights.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.datefw
        val duration: TextView = itemView.durationfw
        val weightUsed: TextView = itemView.weightUsed
        val reps: TextView = itemView.reps
        val edit: Button = itemView.btnEditFW


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

        holder.edit.setOnClickListener { view: View? ->

            var bundle = Bundle()
            bundle.putString("date",currentFreeWeight.date)
            bundle.putString("duration",currentFreeWeight.duration)
            bundle.putString("weight",currentFreeWeight.weightsUsed)
            bundle.putString("reps",currentFreeWeight.repsComplete)

            view?.findNavController()?.navigate(R.id.action_viewFreeWeightFragment_to_fragmentUpdateWeights,bundle)



        }
    }

    override fun getItemCount(): Int = list.size

}