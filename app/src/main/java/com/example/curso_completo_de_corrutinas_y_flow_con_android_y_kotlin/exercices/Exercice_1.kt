package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

fun main(){

    globalScopeExample()

    readLine()


}

fun globalScopeExample() {

    println("globalScopeExample")
    GlobalScope.launch {

        startMsj()
        delay(someTime())
        println("********************************************")
        endMsj()

    }
}

fun startMsj() {
    println("Start corrutina -${Thread.currentThread().name}--")
}

fun endMsj() {
    println("End corrutina -${Thread.currentThread().name}--")
}


/*        ***********    UTILS   ***********      */

fun someTime(): Long = Random.nextLong(500,2000)