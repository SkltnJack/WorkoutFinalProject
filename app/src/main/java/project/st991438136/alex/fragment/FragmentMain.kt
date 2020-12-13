package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.st991438136.alex.R
import project.st991438136.alex.databinding.FragmentMainBinding

class FragmentMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)

        //adding binding for the buttons onClick Event
        binding.btnFreeWeights.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_openScreenFragment_to_freeWeightFragment)
        }

        binding.btnRunning.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_openScreenFragment_to_runningFragment)
        }




        return binding.root
    }
}