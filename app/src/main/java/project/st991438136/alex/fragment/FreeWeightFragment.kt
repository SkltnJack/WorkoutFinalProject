package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.st991438136.alex.MainActivity
import project.st991438136.alex.R
import project.st991438136.alex.databinding.WeightFragmentBinding

class FreeWeightFragment : Fragment() {


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val binding: WeightFragmentBinding =
//            DataBindingUtil.inflate(inflater, R.layout.weight_fragment, container, false)
//
//
//        binding.btnViewPastWorkoutsFW.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.action_freeWeightFragment_to_viewFreeWeightFragment)
//
//
//
//        }
//
//        return binding.root
//    }

    private lateinit var recycleView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.view_free_weight_workouts, container,false)

        recycleView = view.findViewById(R.id.fwRecycleView)

        recycleView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(activity)

        recycleView.layoutManager = layoutManager

        return view
    }






}