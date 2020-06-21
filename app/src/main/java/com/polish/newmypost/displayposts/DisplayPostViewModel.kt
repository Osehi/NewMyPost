package com.polish.newmypost.displayposts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polish.newmypost.data.network.NetworkRepository
import com.polish.newmypost.model.POST
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class POSTApiStatus { LOADING, ERROR, DONE }

class DisplayPostViewModel:ViewModel() {

    private val postRepository = NetworkRepository()
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _myListOfPost = MutableLiveData<List<POST>>()
    val myListOfPOST:LiveData<List<POST>>
    get() = _myListOfPost

    private val _status = MutableLiveData<POSTApiStatus>()
    val status:LiveData<POSTApiStatus>
    get() = _status

//    init {
//        viewMyPostHere()
//    }


    fun viewMyPostHere(){

        coroutineScope.launch {

            try {

                _status.value = POSTApiStatus.LOADING

                val postResult = postRepository.getMyPostNow()
                _myListOfPost.postValue(postResult)

                _status.value = POSTApiStatus.DONE

            } catch (e:Exception){

                _status.value = POSTApiStatus.ERROR

                Log.d("viewModel", "${e.message.toString()}")
            }

        }

    }



}