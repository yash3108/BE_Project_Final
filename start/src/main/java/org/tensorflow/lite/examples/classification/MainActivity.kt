/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.classification

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.classification.viewmodel.Recognition
import com.synnapps.carouselview.CarouselView

// Constants
const val MAX_RESULT_DISPLAY = 1 // Maximum number of results displayed
private const val TAG = "TFL Classify" // Name for logging
const val REQUEST_CODE_PERMISSIONS = 999 // Return code after asking for permission
val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA) // permission needed

// Listener for the result of the ImageAnalyzer
typealias RecognitionListener = (recognition: List<Recognition>) -> Unit

/**
 * Main entry point into TensorFlow Lite Classifier
 */
class MainActivity : AppCompatActivity() {
    var sampleImages = intArrayOf(
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var carouselView = findViewById<CarouselView>(R.id.carouselView)
        var button11 = findViewById<Button>(R.id.button11)
        var button12 = findViewById<Button>(R.id.button12)
        var button13 = findViewById<Button>(R.id.button13)
        var button14 = findViewById<Button>(R.id.button14)

        carouselView.pageCount=sampleImages.size

        carouselView.setImageListener{position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }

        button11.setOnClickListener(){
            val intent = Intent(this, Speechttext::class.java)
            startActivity(intent)
        }

        button12.setOnClickListener {
            val intent = Intent(this, PhotoCapture::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this, FetchData::class.java)
            startActivity(intent)
        }

        button14.setOnClickListener {
            val intent = Intent(this, AlertActiviity::class.java)
            startActivity(intent)
        }
    }

//    var sampleImages = intArrayOf(
//        R.drawable.pic1,
//        R.drawable.pic2,
//        R.drawable.pic3
//    )
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        //var carouselView = findViewById<CarouselView>(R.id.carouselView)
//        var button11 = findViewById<Button>(R.id.button11)
//        var button12 = findViewById<Button>(R.id.button12)
//        var button13 = findViewById<Button>(R.id.button13)
//        var button14 = findViewById<Button>(R.id.button14)
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        carouselView.pageCount=sampleImages.size
////
////        carouselView.setImageListener{position, imageView ->
////            imageView.setImageResource(sampleImages[position])
////        }
//
//
//        button11.setOnClickListener {
//            val intent = Intent(this, Speechttext::class.java)
//            startActivity(intent)
//        }
//
//        button12.setOnClickListener {
//            val intent = Intent(this, PhotoCapture::class.java)
//            startActivity(intent)
//        }
//
//        button13.setOnClickListener {
//            val intent = Intent(this, FetchData::class.java)
//            startActivity(intent)
//        }
//
//        button14.setOnClickListener {
//            val intent = Intent(this, AlertActiviity::class.java)
//            startActivity(intent)
//        }
//
//    }
}
