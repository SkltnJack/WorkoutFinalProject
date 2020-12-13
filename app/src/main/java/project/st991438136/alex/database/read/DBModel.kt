package project.st991438136.alex.database.read

import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

object DBModel: Observable() {

    /* declare a couple constants
     * TAG : log tag
     * WEIGHTS : link to weights table in firebase
     * RUNNING : link to running table in firebase
     */
    private const val TAG = "WorkoutData"
    private const val WEIGHTS = "weights"
    private const val RUNNING = "running"

    // create event listeners
    private var eventListener_weights : ValueEventListener? = null
    private var eventListener_running : ValueEventListener? = null

    // prepare arraylists to store data
    private var listWeights : ArrayList<Weights>? = ArrayList()
    private var listRunning : ArrayList<Running>? = ArrayList()

    // link to each table
    private fun dbRefModelWeights() : DatabaseReference? = Firebase.database.reference.child(WEIGHTS)

    private fun dbRefModelRunning() : DatabaseReference? = Firebase.database.reference.child(RUNNING)

    // set eventlisteners to null
    private fun setAllNulls() {

        eventListener_running = null
        eventListener_weights = null
    }

    // remove existing event listeners
    private fun removeListener(listener : ValueEventListener?) {

        if (listener != null) {
            when (listener) {
                eventListener_weights ->
                    dbRefModelWeights()?.removeEventListener(listener)
                eventListener_running ->
                    dbRefModelRunning()?.removeEventListener(listener)
            }
        }
    }


    // catch method
    private fun catchMethod(e : Exception, type : String) {
        Log.i("$TAG: $type", "Error: \n ${e.message}" )
    }

    // update method
    private fun update(type : String) {
        Log.i("$TAG: $type", "Data updated, there are +" +
                "${listRunning!!.size} entries in the cache" )
        setChanged()
        notifyObservers()
    }

    // getter methods

    fun getRunningData() : ArrayList<Running> = listRunning!!
    fun getWeightsData() : ArrayList<Weights> = listWeights!!

    // init
    init {

        removeListener(eventListener_running)
        removeListener(eventListener_weights)
        setAllNulls()

        // adding event listeners to running
        eventListener_running = object : ValueEventListener {

            // occurs when data is changed in the database
            override fun onDataChange(snapshot : DataSnapshot) {
                try {
                    val data : ArrayList<Running> = ArrayList()
                    for (dataSnapshot : DataSnapshot in  snapshot.children) {

                        try {

                            data.add(Running(dataSnapshot))

                        } catch (e: Exception) {
                            catchMethod(e,"Running")
                        }
                    }

                    listRunning = data
                    update("Running")


                } catch (e: Exception) {
                    catchMethod(e,"Running")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("$TAG: Running", "Error: \n${error.message}")
            }


        }

        eventListener_weights = object : ValueEventListener {

            // occurs when data is changed in the database
            override fun onDataChange(snapshot : DataSnapshot) {
                try {
                    val data : ArrayList<Weights> = ArrayList()
                    for (dataSnapshot: DataSnapshot in  snapshot.children) {

                        try {

                            data.add(Weights(dataSnapshot))

                        } catch (e: Exception) {
                            catchMethod(e,"Weights")
                        }
                    }

                    listWeights = data
                    update("Weights")


                } catch (e: Exception) {
                    catchMethod(e,"Weights")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("$TAG: Weights", "Error: \n${error.message}")
            }



        }


        dbRefModelRunning()?.addValueEventListener(eventListener_running!!)
        dbRefModelWeights()?.addValueEventListener(eventListener_weights!!)
    }

}