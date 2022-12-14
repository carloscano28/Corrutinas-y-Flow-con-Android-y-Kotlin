package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils

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