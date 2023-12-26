package org.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

}
fun <T> Flow<T>.unique():Flow<T>{
    return  flow {
        var lastValue: Any? = NoValue
        collect{value: T ->
            if (lastValue != value){
                lastValue = value
                emit(value)
            }
        }
    }
}

private object NoValue