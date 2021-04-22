package org.tensorflow.lite.examples.classification

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class RvAdapter (val context:Context,val VideoList: ArrayList<String>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_item_layout, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return VideoList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {


        p0.name?.text = VideoList[p1]
        p0.btn.setOnClickListener {

            val id=VideoList[p1];
            Log.d(id,"dju")
            val intent = Intent(context, Youtubeact::class.java)
            intent.putExtra("ID",id)
            context.startActivity(intent)
        }

    }





    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.Namefd)

        var btn=itemView.findViewById<Button>(R.id.buttonedit)
    }


}