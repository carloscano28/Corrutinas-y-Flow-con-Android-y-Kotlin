package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.basic

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main(){
    produceFun()
}

fun produceFun() = runBlocking {
    newTopic("Produce Demo",false)
    val names =  produceNames()
    names.consumeEach { println(it) }
}

fun CoroutineScope.produceNames(): ReceiveChannel<String> = produce {
    (1..5).forEach {
        send("Name: $it")
    }
}
