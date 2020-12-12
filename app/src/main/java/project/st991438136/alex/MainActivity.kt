package project.st991438136.alex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import project.st991438136.alex.adapters.RecyclerViewAdapterFW
import project.st991438136.alex.adapters.RecyclerViewAdapterRun
import project.st991438136.alex.database.DBModel
import project.st991438136.alex.database.Running
import project.st991438136.alex.database.Weights
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), Observer {


    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DBModel.addObserver(this)

//        recyclerView1 = findViewById(R.id.fwRecycleView)
//        recyclerView2 = findViewById(R.id.runRecycleView)
//
//        val weightList:ArrayList<Weights> = DBModel.getWeightsData()
//        val runList:ArrayList<Running> = DBModel.getRunningData()
//
//        val recyclerView_weigths = RecyclerViewAdapterFW(weightList)
//        recyclerView1.adapter = recyclerView_weigths
//
//        val recyclerView_runs = RecyclerViewAdapterRun(runList)
//        recyclerView2.adapter = recyclerView_runs




    }

    fun loadFreeWeightList(){

        recyclerView1 = findViewById(R.id.fwRecycleView)


        val weightList:ArrayList<Weights> = DBModel.getWeightsData()


        val recyclerView_weigths = RecyclerViewAdapterFW(weightList)
        recyclerView1.adapter = recyclerView_weigths


    }

    override fun update(p0: Observable?, p1: Any?) {

        recyclerView1 = findViewById(R.id.fwRecycleView)
        recyclerView2 = findViewById(R.id.runRecycleView)

        val weightList:ArrayList<Weights> = DBModel.getWeightsData()
        val runList:ArrayList<Running> = DBModel.getRunningData()

        val recyclerView_weigths = RecyclerViewAdapterFW(weightList)
        recyclerView1.adapter = recyclerView_weigths

        val recyclerView_runs = RecyclerViewAdapterRun(runList)
        recyclerView2.adapter = recyclerView_runs



    }
}