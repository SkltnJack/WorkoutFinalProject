package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import project.st991438136.alex.R
import project.st991438136.alex.databinding.WeightFragmentBinding

class ViewFreeWeightFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: WeightFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.view_free_weight_workouts, container, false)


        return binding.root
    }
}