package org.tensorflow.lite.examples.classification

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.*
import android.widget.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.firebase.database.*

class AlertActiviity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_activiity)

        var imgid = findViewById<ImageView>(R.id.imgid)
        var imgid1 = findViewById<ImageView>(R.id.imgid1)
        var button20 = findViewById<Button>(R.id.button20)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val demoRef: DatabaseReference = rootRef.child("Vibrate").child("V1")


        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        imgid.isVisible=false
        imgid1.isVisible=true


        /*demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                if(value.equals("true"))
                {
                    val pattern = longArrayOf(0, 1000, 1000)
                    v.vibrate(pattern, 0)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@AlertActi, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })*/

        demoRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                if(value.equals("true"))
                {
                    val pattern = longArrayOf(0, 1000, 1000)
                    imgid.isVisible=true
                    imgid1.isVisible=false
                    v.vibrate(pattern, 0)
                }
                else
                {
                    imgid.isVisible=false
                    imgid1.isVisible=true
                }
                if(value.equals("false"))
                {
                    v.cancel();
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@AlertActiviity, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })

// Start without a delay
// Vibrate for 100 milliseconds
// Sleep for 1000 milliseconds

// Start without a delay
// Vibrate for 100 milliseconds
// Sleep for 1000 milliseconds


// The '0' here means to repeat indefinitely
// '0' is actually the index at which the pattern keeps repeating from (the start)
// To repeat the pattern from any other point, you could increase the index, e.g. '1'

// The '0' here means to repeat indefinitely
// '0' is actually the index at which the pattern keeps repeating from (the start)
// To repeat the pattern from any other point, you could increase the index, e.g. '1'


        button20.setOnClickListener {
            imgid.isVisible=false
            imgid1.isVisible=true
            v.cancel();

        }
    }
}
