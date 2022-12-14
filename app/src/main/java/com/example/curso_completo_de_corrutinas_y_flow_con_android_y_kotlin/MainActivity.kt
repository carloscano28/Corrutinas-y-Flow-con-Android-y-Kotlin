package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
* https://ektdigital.udemy.com/course/corrutinas-y-flow-con-android-y-kotlin/learn/lecture/27892700#content
*
*/

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()

        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }

        }

    }

    private suspend fun downloadUserData() {
        withContext(Dispatchers.IO){
            for (i in 1..20) {
                Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            }
        }

    }

}