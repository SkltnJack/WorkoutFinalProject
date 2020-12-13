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
import project.st991438136.alex.database.write.DataClassRun
import project.st991438136.alex.databinding.FragmentRunBinding

class FragmentRun : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        database = Firebase.database.reference.child("running")
        val binding: FragmentRunBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_run, container, false)

        binding.btnAddWorkout.setOnClickListener {

            val date = binding.editRunDate.text.toString()
            val duration = binding.editRunDuration.text.toString()
            val speed = binding.editSpeed.text.toString()
            val distance = binding.editDistance.text.toString()

            val newActivity = DataClassRun(speed,distance,duration)
            database.child(date).setValue(newActivity)

            Toast.makeText(activity, "Activity has been added", Toast.LENGTH_SHORT).show()

        }

        binding.btnViewPastWorkouts.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_runningFragment_to_viewRunningFragment)
        }

        return binding.root
    }
}