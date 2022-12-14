package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
//import kotlin.concurrent.thread

fun main(){

    coroutinesVsThreads()

}

fun coroutinesVsThreads() {
    newTopic("coroutines Vs Threads", false)

    // Para tareas mas exaustivas
    runBlocking {
        (1..1_000_000).forEach {
            launch {
                delay(someTime())
                print("*")
            }
        }
    }

    // Forma ineficiente por desbordamiento de memoria
    /*(1..1_000_000).forEach {
        thread {
            Thread.sleep(someTime())
            println("*")
        }
    }*/

}