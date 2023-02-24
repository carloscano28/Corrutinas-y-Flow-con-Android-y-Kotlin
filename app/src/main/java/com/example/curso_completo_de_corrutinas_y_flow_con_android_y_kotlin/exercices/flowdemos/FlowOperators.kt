package com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.exercices.flowdemos

import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.covertCelsToFahr
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.newTopic
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.setFormat
import com.example.curso_completo_de_corrutinas_y_flow_con_android_y_kotlin.utils.someTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 *
 * Map
 * Filter
 * Transform
 * Take
 * tolist
 * First
 * Last
 * Reduce
 * Buffer
 * Conflate
 *
 */

fun main(){
    conflateFlowDemo()
    //bufferFlowDemo()
    //terminalFlowOperators()
    //operadorTakeFlow()
    //operadorTransformFlow()
    //operadorFilterFlow()
    //operadorMapFlow()
}

fun conflateFlowDemo() {
    runBlocking {
        newTopic("Conflate flow demo", false)
        val time = measureTimeMillis {
            getMatchResultsFlow()
                .conflate()
                //.buffer()
                .collectLatest {
                //.collect{
                    delay(100)
                    println(it)
                }
        }
        println("Time: ${time}ms")

    }

}

fun getMatchResultsFlow() : Flow<String> {
    return flow {
        var homeTeam = 0
        var awayTeam = 0
        (0..45).forEach {
            println("Minuto: $it")
            delay(50)
            homeTeam += Random.nextInt(0,21)/20
            awayTeam += Random.nextInt(0,21)/20
            emit("$homeTeam - $awayTeam")
        }
    }
}

fun bufferFlowDemo() {

    runBlocking {
        newTopic("Buffer flow", false)
        val time = measureTimeMillis {
            getDataByFlowStatic()
                .map {
                    setFormat(it)
                }
                .buffer()
                .collect{
                    delay(300)
                    println(it)
                }
        }
        println("Time: $time")

    }
}

fun terminalFlowOperators() {
    newTopic("Operadores terminales flow", false)   //

    runBlocking {
        /*newTopic("List", false)
        val list = getDataByFlow()
            .toList()
        println("List: $list")

        newTopic("Single", false)
        val single = getDataByFlow()
            .take(1)
            .single()
        println("Single: $single")

        newTopic("First", false)
        val first = getDataByFlow()
            .first()
        println("First: $first")

        newTopic("Last", false)
        val last = getDataByFlow()
            .last()
        println("Last: $last")*/

        newTopic("Reduce", false)
        val saving = getDataByFlow().reduce { accumulator, value ->
            println("Acumulator: $accumulator")
            println("Value: $value")
            println("Current saving: ${accumulator+value}")
            accumulator+value
        }
        println("Saving: $saving")

        newTopic("Fold", false)
        val lastSaving = saving
        val totalSaving = getDataByFlow().fold(lastSaving){ acc, value ->
            println("Acumulator: $acc")
            println("Value: $value")
            println("Current saving: ${acc + value}")
            acc + value
        }
        println("Total saving: $totalSaving")
    }
}

fun getDataByFlowStatic() : Flow<Float> {
    return flow {
        (1..5).forEach{
            println("Procesando datos...")
            delay(300)
            emit(20 + it + Random.nextFloat())
        }
    }

}

fun operadorTakeFlow() {
    newTopic("Operadores FLow Intermediarios", false)
    newTopic("Take", false)   // Tomar una cantidad limitada de valores
    runBlocking {
        getDataByFlow()
            .take(3)
            .map { setFormat(it) }
            .collect{ println(it) }
    }
}

fun operadorTransformFlow() {
    newTopic("Operadores FLow Intermediarios", false)
    newTopic("Transform", false)   // Puede emitir mas de una vez el valor procesado
    runBlocking {
        getDataByFlow()
            .transform {
                emit(setFormat(it))
                emit(setFormat(covertCelsToFahr(it), "F"))
            }
            .collect{
                println(it)
            }
    }
}

fun operadorFilterFlow() {
    newTopic("Operadores FLow Intermediarios", false)
    newTopic("Filter", false)
    runBlocking {
        getDataByFlow()
            .filter {
                it < 23
            }
            .map {
                setFormat(it)
            }
            .collect{
                println(it)
            }
    }
}

fun operadorMapFlow() {
    newTopic("Operadores FLow Intermediarios", false)
    newTopic("Maps", false)
    runBlocking {
        getDataByFlow()
            .map {
                //setFormat(it)
                setFormat(covertCelsToFahr(it), "F")
            }
            .collect{
                println(it)
            }
    }
}





