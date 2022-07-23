package com.neonusa.apinetworkstatelearning.utils

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Coroutines {

    // parameternya adalah sebuah suspend function
    // akan terus memanggil function work
    fun main(work: suspend (() -> Unit) ) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }

    fun IO(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.IO).launch {
        work()
    }
}
