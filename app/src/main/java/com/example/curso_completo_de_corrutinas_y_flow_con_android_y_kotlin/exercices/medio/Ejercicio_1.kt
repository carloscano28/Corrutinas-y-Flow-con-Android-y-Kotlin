package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.medio

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.endMsj
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.startMsj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 *  Dispatchers IO & Unconfined
 */
fun main(){
    dispatchersFun()
}


/**
 * Tres corrutinas independientes
 */
fun dispatchersFun() {
    runBlocking {

        newTopic("Dispatchers Demo",false)

        launch {
            startMsj()
            println("None")
            endMsj()
        }
        launch (Dispatchers.IO) {
            startMsj()
            println("IO")
            endMsj()
        }
        launch (Dispatchers.Unconfined) {
            startMsj()
            println("Unconfined")
            endMsj()
        }
        launch (Dispatchers.Default) {
            startMsj()
            println("Default")
            endMsj()
        }
        launch (newSingleThreadContext("Curso Android ")) {
            startMsj()
            println(" Corrutina personalizada con dispatcher (Uno) ")
            endMsj()
        }
        newSingleThreadContext("Curso Udemy Android").use { myContext ->
            launch (myContext){
                startMsj()
                println(" Corrutina personalizada con dispatcher (Dos) ")
                endMsj()
            }
        }

    }
}
