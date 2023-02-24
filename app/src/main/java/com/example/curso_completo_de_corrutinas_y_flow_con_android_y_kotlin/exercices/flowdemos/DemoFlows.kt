package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.flowdemos

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/**
 *
 */


fun main(){
    //flowsFun()
    //coldFlow()
    cancelFlow()
}

fun cancelFlow() {
    newTopic("Cancel Flow", false)
    runBlocking {
        val job = launch {
            getDataByFlow().collect{ println(it) }
        }
        delay(someTime()*2)
        job.cancel()
        if (job.isCancelled){
            println("\n Flow cancelado")
        }
    }
}

fun getDataByFlow() : Flow<Float> {
    return flow {
        (1..5).forEach{
            println("Procesando datos...")
            delay(someTime())
            emit(20 + it + Random.nextFloat())
        }
    }

}

fun coldFlow() {
    runBlocking {
        val dataFlow = getDataByFlow()
        println("Esperando...")
        delay(someTime())
        getDataByFlow().collect{ println(it) }
    }
}

fun flowsFun() {
    newTopic("Demo flows basic", false)
    runBlocking {
        launch {
            getDataByFlow().collect{ println(" $it ") }
        }

        launch {
            (1..50).forEach {
                delay(someTime()/10)
                println("Tarea 2...")
            }
        }
    }
}