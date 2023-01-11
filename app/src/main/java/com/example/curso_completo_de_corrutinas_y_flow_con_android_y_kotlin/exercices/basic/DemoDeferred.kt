package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.basic

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.endMsj
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.startMsj
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){

    deferredFun()

}

fun deferredFun() {
    newTopic("Deferred Demo",false)
    runBlocking {
        val deferred = async {
            startMsj()
            delay(someTime())
            println("deferred...")
            endMsj()
            5*3
        }
        println("Deferred: $deferred ")
        println("Deferred await: ${deferred.await()} ")

        val result = async {
            3*3
        }.await()
        println("Result: $result ")

    }

}
