package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.medio

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.endMsj
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.startMsj
import kotlinx.coroutines.*

/**
 *  withContext
 */
fun main(){
    withContextFun()
}

fun withContextFun() {

    runBlocking {
        newTopic("Demo withContext", false)
        startMsj()

        delay(someTime())

        withContext(newSingleThreadContext("Cambiar contexto")){
            startMsj()
            delay(3000)
            println("Curso Corrutinas Demo")
            endMsj()
        }

        withContext(Dispatchers.IO){
            startMsj()
            println("Peticion al servidor")
            endMsj()
        }

        endMsj()

    }
}
