package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.medio

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.endMsj
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.startMsj
import kotlinx.coroutines.*


/**
 *  Nested
 */
fun main(){
    nestedFun()
}

fun nestedFun() {
    runBlocking {
        newTopic("Anidar Corrutinas",false)

        val job = launch {
            startMsj()
            launch {
                startMsj()
                delay(someTime())
                println("   ~Otra tarea")
                endMsj()
            }
            launch (Dispatchers.IO) {
                startMsj()
                launch (newSingleThreadContext("Ultimo nivel de anidamiento")) {
                    startMsj()
                    println("       ~Otra tarea en el ultimo nivel")
                    endMsj()
                }
                delay(someTime())
                println("   ~Otra tarea en segunda corrutina")
                endMsj()
            }

            var sum = 0
            (1..100).forEach {
                sum += it
                delay(someTime()/100)
            }
            println("   ~Suma = $sum")
            endMsj()
        }

        delay(someTime()/2)
        job.cancel()
        println(" Job cancelado...")
    }
}
