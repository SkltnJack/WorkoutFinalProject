package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.st991438136.alex.R
import project.st991438136.alex.databinding.FragmentRunBinding

class FragmentRun : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRunBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_run, container, false)



        binding.btnViewPastWorkouts.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_runningFragment_to_viewRunningFragment)
        }

        return binding.root
    }
}