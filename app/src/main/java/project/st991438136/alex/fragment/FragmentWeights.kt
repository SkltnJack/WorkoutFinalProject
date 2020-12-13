package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.st991438136.alex.R
import project.st991438136.alex.databinding.FragmentWeightsBinding

class FragmentWeights : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding : FragmentWeightsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weights, container, false)

        binding.btnViewPastWorkoutsFW.setOnClickListener { view : View ->

            view.findNavController().navigate(R.id.action_freeWeightFragment_to_viewFreeWeightFragment)
        }

        return binding.root

    }

}