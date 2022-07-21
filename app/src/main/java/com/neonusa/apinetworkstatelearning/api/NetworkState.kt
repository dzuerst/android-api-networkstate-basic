package com.neonusa.apinetworkstatelearning.api

import java.lang.Error

class NetworkState (val status: Status,
                                    val msg: String? = null) {

    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS,"Success")
            LOADING = NetworkState(Status.LOADING,"Loading")
            ERROR = NetworkState(Status.ERROR,"Error")
        }
    }
}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}