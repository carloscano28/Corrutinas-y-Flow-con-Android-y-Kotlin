package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.medio

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import kotlin.random.Random

/**
 * Sequences es un contenedor. Es una coleccion que se enfoca procesar y entregar valores por pasos
 * Tiene la caracteristica de ejecutar el procesamiento por cada elemento y de catalogarse como
 * perezosa (procesara cada elemento hasta que se solicite y no toda la coleccion en una sola accion).
 */


fun main(){
    secuencesFun()
}

fun secuencesFun() {
    newTopic("Secuences",false)
    getDataBySec().forEach { println(" $it") }
}

fun getDataBySec() : Sequence<Float> {
    return sequence {
        (1..5).forEach{
            println("Procesando datos...")
            Thread.sleep(someTime())
            yield(20 + it + Random.nextFloat())
        }
        println(" END ")
    }

}
