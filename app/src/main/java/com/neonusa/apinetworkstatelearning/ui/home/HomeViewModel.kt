package com.neonusa.apinetworkstatelearning.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neonusa.apinetworkstatelearning.api.RetrofitInstance
import com.neonusa.apinetworkstatelearning.model.YoutubeData
import com.neonusa.apinetworkstatelearning.utils.Coroutines

class HomeViewModel : ViewModel() {

    var channelVideoList: MutableLiveData<List<YoutubeData>> = MutableLiveData<List<YoutubeData>>()

    fun getChannelVideoList()= Coroutines.main {
        val response = RetrofitInstance.api.getChannelVideos()
        Log.i("HomeViewModel","LOADING...")
        if(response.isSuccessful){
            Log.i("HomeViewModel","getChannelVideList : response success")
            channelVideoList.postValue(response.body()?.items)
        }else{
            Log.e("error","${response.code().toString()} ${response.message()}")
        }
    }
}