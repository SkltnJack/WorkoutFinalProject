package project.st991438136.alex.database

import android.util.Log
import com.google.firebase.database.DataSnapshot
import java.lang.Exception

class Running (snapshot: DataSnapshot) {

    lateinit var date : String
    lateinit var avgSpeed : String
    lateinit var distance : String
    lateinit var duration: String

    init {

        try {

            val data : HashMap<String, Any> = snapshot.value as HashMap<String, Any>

            date = snapshot.key ?: ""
            duration = data["duration"] as String
            avgSpeed = data["avgSpeed"] as String
            distance = data["distance"] as String

        } catch (e : Exception) {

            Log.i("RunningDB", "An error has occurred: \n $e")
        }
    }
}