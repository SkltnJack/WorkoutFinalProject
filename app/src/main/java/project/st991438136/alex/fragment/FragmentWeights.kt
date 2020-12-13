package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import project.st991438136.alex.R
import project.st991438136.alex.database.write.DataClassWeights
import project.st991438136.alex.databinding.FragmentWeightsBinding

class FragmentWeights : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        database = Firebase.database.reference.child("weights")
        var binding : FragmentWeightsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weights, container, false)

        binding.btnViewPastWorkoutsFW.setOnClickListener { view : View ->

            view.findNavController().navigate(R.id.action_freeWeightFragment_to_viewFreeWeightFragment)
        }

        binding.btnAddWorkoutFW.setOnClickListener {

            val date = binding.editWeightDate.text.toString()
            val duration = binding.editWeightDuration.text.toString()
            val weightLifted = binding.editWeight.text.toString()
            val reps = binding.editReps.text.toString()
            val newActivity = DataClassWeights(duration, reps, weightLifted)
            database.child(date).setValue(newActivity)

            Toast.makeText(activity, "Activity has been added", Toast.LENGTH_SHORT).show()
        }

        return binding.root

    }

}