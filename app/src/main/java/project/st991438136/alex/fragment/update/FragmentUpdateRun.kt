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
import project.st991438136.alex.database.write.DataClassRun
import project.st991438136.alex.database.write.DataClassWeights
import project.st991438136.alex.databinding.FragmentEditRunningBinding
import project.st991438136.alex.databinding.FragmentEditWeightsBinding

class FragmentUpdateRun : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        database = Firebase.database.reference.child("running")

        val binding : FragmentEditRunningBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_running, container, false)


        binding.modifyRunDate.setText(arguments?.getString("date"))

        binding.modifyRunDuration.setText(arguments?.getString("duration"))
        binding.modifyDistance.setText(arguments?.getString("distance"))
        binding.modifySpeed.setText(arguments?.getString("speed"))

        val dateBeforeUpdate = binding.modifyRunDate.text.toString()

        binding.btnUpdateRun.setOnClickListener {

            // database.child gets the child (the date)
            val date = binding.modifyRunDate.text.toString()
            val duration = binding.modifyRunDuration.text.toString()
            val distance = binding.modifyDistance.text.toString()
            val speed = binding.modifySpeed.text.toString()

            val updatedActivity = DataClassRun(speed, distance, duration)

            database.child(dateBeforeUpdate).removeValue()
            database.child(date).setValue(updatedActivity)

            it.findNavController().navigate(R.id.action_fragmentUpdateRun_to_viewRunningFragment)


        }

        return binding.root
    }
}