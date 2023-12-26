package org.example

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.security.auth.callback.Callback

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

interface Request<T>{
    fun exucute(callback: Callback<T>)

    fun cancel()

    interface Callback<T>{
        fun onSucces(value: T)
        fun onError(e:Exception)

    }
}

fun <T> Request<T>.asFlow():Flow<T>{
    return callbackFlow {
exucute(object : Request.Callback <T>){

})

    }


}


