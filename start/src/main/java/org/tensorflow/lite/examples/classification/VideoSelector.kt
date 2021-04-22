package org.tensorflow.lite.examples.classification

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class VideoSelector : AppCompatActivity() {

    public var VidList = ArrayList<String>()


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_selector)
        var vidid:String=""
        vidid= intent.getStringExtra("VDID").toString()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false)


        VidList.clear();

        var yourArray: List<String> = vidid.split("////")

        for (i in 0 until yourArray.size) {
            VidList.add(yourArray.get(i))
            Log.d("ans",yourArray.get(i));
        }

        val rvAdapter = RvAdapter(this, VidList)



        recyclerView.adapter = rvAdapter;

    }
}