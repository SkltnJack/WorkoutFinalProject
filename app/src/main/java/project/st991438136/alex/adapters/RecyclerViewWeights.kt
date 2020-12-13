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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.card_weights.view.*
import project.st991438136.alex.R
import project.st991438136.alex.database.read.Weights
import project.st991438136.alex.fragment.view.FragmentViewWeights

class RecyclerViewWeights(
    private val list: ArrayList<Weights>
) : RecyclerView.Adapter<RecyclerViewWeights.RecyclerViewHolder>() {

    private lateinit var database: DatabaseReference

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date: TextView = itemView.datefw
        val duration: TextView = itemView.durationfw
        val weightUsed: TextView = itemView.weightUsed
        val reps: TextView = itemView.reps
        val edit: Button = itemView.btnEditFW
        val delete: Button = itemView.btnDeleteFW


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_weights, parent,false)

        database = Firebase.database.reference.child("weights")

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

        holder.delete.setOnClickListener { view:View? ->
            database.child(currentFreeWeight.date).removeValue()
        }
    }

    override fun getItemCount(): Int = list.size

}