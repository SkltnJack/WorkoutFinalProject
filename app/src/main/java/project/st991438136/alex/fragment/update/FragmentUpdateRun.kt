package project.st991438136.alex.fragment.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import project.st991438136.alex.R
import project.st991438136.alex.database.write.DataClassWeights
import project.st991438136.alex.databinding.FragmentEditWeightsBinding

class FragmentUpdateRun : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        database = Firebase.database.reference.child("weights")

        val binding : FragmentEditWeightsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_weights, container, false)


        binding.modifyWeightDate.setText(arguments?.getString("date"))

        binding.modifyWeightDuration.setText(arguments?.getString("duration"))
        binding.modifyWeight.setText(arguments?.getString("weight"))
        binding.modifyReps.setText(arguments?.getString("reps"))

        val dateBeforeUpdate = binding.modifyWeightDate.text.toString()

        binding.btnUpdateWeights.setOnClickListener {

            // database.child gets the child (the date)
            val date = binding.modifyWeightDate.text.toString()
            val duration = binding.modifyWeightDuration.text.toString()
            val weightLifted = binding.modifyWeight.text.toString()
            val reps = binding.modifyReps.text.toString()

            val updatedActivity = DataClassWeights(duration, reps, weightLifted)

            database.child(dateBeforeUpdate).removeValue()
            database.child(date).setValue(updatedActivity)

            it.findNavController().navigate(R.id.action_fragmentUpdateWeights_to_viewFreeWeightFragment)


        }

        return binding.root
    }
}