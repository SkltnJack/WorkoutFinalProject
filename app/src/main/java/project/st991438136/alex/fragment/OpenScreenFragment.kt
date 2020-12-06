package project.st991438136.alex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import project.st991438136.alex.R
import project.st991438136.alex.databinding.FragmentOpenScreenBinding

class OpenScreenFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentOpenScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_open_screen, container, false)

        return binding.root//super.onCreateView(inflater, container, savedInstanceState)
    }
}