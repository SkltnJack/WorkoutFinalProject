package project.st991438136.alex.database.read

import android.util.Log
import com.google.firebase.database.DataSnapshot

class Weights (snapshot: DataSnapshot) {

    lateinit var date : String
    lateinit var duration : String
    lateinit var weightsUsed : String
    lateinit var repsComplete : String

    init {
        try {
            val data : HashMap<String, Any> = snapshot.value as HashMap<String, Any>

            date = snapshot.key ?: ""
            duration = data["duration"] as String
            weightsUsed = data["weightsUsed"] as String
            repsComplete = data["repsComplete"] as String

        } catch (e: Exception) {

            Log.i("WeightsDB", "An error has occurred: \n $e")
        }
    }
}