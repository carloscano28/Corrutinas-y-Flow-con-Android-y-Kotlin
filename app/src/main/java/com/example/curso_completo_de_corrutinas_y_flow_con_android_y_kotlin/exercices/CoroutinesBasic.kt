package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(){

    /**
    * GlobalScope ejecuta el codigo mientras la aplicacion siga viva
    */
    globalScopeExample()

    /**
    * Se coloca readLine() para evitar que la aplicacion muera hasta que se teclea un caracter y
    * asi se pueda ejecutar el codigo de Global Scope
    */
    readLine()

}

fun globalScopeExample() {
    newTopic("Global Scope Example", false)

    // launch crea una corrutina de tipo job (objeto cancelable)
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