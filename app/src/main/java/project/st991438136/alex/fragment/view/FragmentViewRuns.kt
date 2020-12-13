package project.st991438136.alex.fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.st991438136.alex.R
import project.st991438136.alex.adapters.RecyclerViewRun
import project.st991438136.alex.database.read.DBModel
import java.util.*


class FragmentViewRuns : Fragment(), Observer {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DBModel.addObserver(this)

        val view : View? = inflater.inflate(R.layout.fragment_run_view, container, false)
        if (view != null) {
            recyclerView = view.findViewById(R.id.runRecyclerView)

            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            val runList = DBModel.getRunningData()
            val recyclerViewWeight = RecyclerViewRun(runList)
            recyclerView.adapter = recyclerViewWeight
        }

        return view
    }

    override fun update(p0: Observable?, p1: Any?) {

        val runList = DBModel.getRunningData()
        val recyclerView_run = RecyclerViewRun(runList)
        recyclerView.adapter = recyclerView_run

    }
}