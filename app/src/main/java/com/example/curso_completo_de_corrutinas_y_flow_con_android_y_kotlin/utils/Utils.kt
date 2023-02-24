package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils

import java.util.*
import kotlin.random.Random

/*        ***********    UTILS   ***********      */

fun newTopic(topic : String, title: Boolean) {
    val SEPARATOR = "=================="
    val SEPARATOR1 = "******************"
    if (title)
        println("\n $SEPARATOR1 $topic $SEPARATOR1 \n")
    else
        println("\n $SEPARATOR $topic $SEPARATOR \n")

}


/*        ***********    UTILS   ***********      */

fun someTime(): Long = Random.nextLong(500,2000)

fun startMsj() = println("* Start corrutina -- ${Thread.currentThread().name}--")

fun endMsj() = println("* End corrutina -- ${Thread.currentThread().name}--")

fun setFormat(temp: Float, degree: String = "C"): String = String.format(Locale.getDefault(),"%.1f°$degree",temp)

fun covertCelsToFahr(cels: Float): Float = ((cels*9)/5)+32