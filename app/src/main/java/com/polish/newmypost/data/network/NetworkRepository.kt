package com.polish.newmypost.data.network

import com.polish.newmypost.data.api.PostAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NetworkRepository {

    val postApi = PostAPI()

    val TAG = "NETWORK REPOSITORY"


    suspend fun getMyPost(){

        withContext(Dispatchers.IO){

            Timber.d("list of posts called")
            val postList = postApi.viewPosts()

        }

    }


}