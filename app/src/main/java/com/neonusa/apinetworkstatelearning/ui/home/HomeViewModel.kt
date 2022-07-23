package com.neonusa.apinetworkstatelearning.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neonusa.apinetworkstatelearning.api.RetrofitInstance
import com.neonusa.apinetworkstatelearning.model.YoutubeData
import com.neonusa.apinetworkstatelearning.utils.Coroutines
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    init {
        getVideolist()
    }
    var channelVideoList: MutableLiveData<List<YoutubeData>> = MutableLiveData<List<YoutubeData>>()

    // test only
//    fun getVideoLlist() = CoroutineScope(Dispatchers.Main).launch {
//        Log.i("HomeViewModel", "getVideoList: dispatchers.main running")
//    }

    fun getVideolist() = CoroutineScope(Dispatchers.Main).launch {
        val response = RetrofitInstance.api.getChannelVideos()
        Log.i("HomeViewModel","LOADING...")
        if(response.isSuccessful){
            Log.i("HomeViewModel","getChannelVideList : response success")
            channelVideoList.postValue(response.body()?.items)
        }else{
            Log.e("error","${response.code().toString()} ${response.message()}")
        }
    }

    fun getChannelVideoList()= Coroutines.main {
        val response = RetrofitInstance.api.getChannelVideos()
        Log.i("HomeViewModel","LOADING...")
        //delay coroutine
        delay(3000)
        if(response.isSuccessful){
            Log.i("HomeViewModel","getChannelVideList : response success")
            channelVideoList.postValue(response.body()?.items)
        }else{
            Log.e("error","${response.code().toString()} ${response.message()}")
        }
    }
}