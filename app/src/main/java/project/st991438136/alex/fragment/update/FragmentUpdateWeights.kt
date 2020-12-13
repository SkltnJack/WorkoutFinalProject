package project.st991438136.alex.fragment.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import project.st991438136.alex.R
import project.st991438136.alex.databinding.FragmentEditWeightsBinding

class FragmentUpdateWeights: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentEditWeightsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_weights, container, false)

        //binding.modifyWeightDate

        return binding.root
    }
}