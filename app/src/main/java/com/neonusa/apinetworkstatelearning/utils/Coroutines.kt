package com.neonusa.apinetworkstatelearning.utils

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Coroutines {

    fun main(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
        Log.i("Coroutines", "main: coroutin main function is running")
    }

    fun IO(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.IO).launch {
        work()
    }
}
