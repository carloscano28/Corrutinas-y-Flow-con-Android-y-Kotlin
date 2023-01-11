package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.basic

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.endMsj
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.startMsj
import kotlinx.coroutines.*
//import kotlin.concurrent.thread

fun main(){

    //coroutinesVsThreads()
    //suspendFun()
    //cRunBlocking()
    //cLaunch()
    //cAsync()
    //funJob()

}

fun funJob() {
    /**
     * Job es el ciclo de vida de una corrutina que puede ser cancelable
     */
    runBlocking {
        newTopic("Job example", false)
        val job = launch {
            startMsj()
            delay(2100)
            println("Job...")
            endMsj()
        }
        println("Job: $job")

        println("- Job isActive: ${job.isActive}")
        println("- Job isCancelled: ${job.isCancelled}")
        println("- Job isCompleted: ${job.isCompleted}")

        delay(someTime())  // max 2 segundos
        println("Tarea cancelada o terminada")
        job.cancel()

        println("Job isActive: ${job.isActive}")
        println("Job isCancelled: ${job.isCancelled}")
        println("Job isCompleted: ${job.isCompleted}")

    }
}

fun cAsync() {
    /**
     * async sirve cuando si se espera un resultado o un valor cuando termina la corrutina
     */
    runBlocking {
        newTopic("Async example", false)
        val result = async {
            startMsj()
            delay(someTime())
            println("Async")
            endMsj()
            1
        }
        println("Result: ${result.await()}")
    }

}

fun cLaunch() {
    /**
     * Launch se utiliza para ejecutar tareas que no necesitan devolver un valor o un resultado
     */
    runBlocking {
        newTopic("Launch example", false)
        launch {
            startMsj()
            delay(someTime())
            println("Launch")
            endMsj()
        }
    }
}

fun cRunBlocking() {
    newTopic("RunBlocking example", false)
    runBlocking {
        startMsj()
        delay(someTime())
        println("RunBlocking")
        endMsj()
    }
}

fun suspendFun() {
    newTopic("Suspend function", false)
    Thread.sleep(someTime())
    //delay(someTime())
    GlobalScope.launch {delay(someTime())}
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