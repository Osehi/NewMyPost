package com.polish.newmypost.data.network

import android.util.Log
import com.polish.newmypost.data.api.PostAPI
import com.polish.newmypost.model.POST
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NetworkRepository {

    val postApi = PostAPI()

    val TAG = "NETWORK REPOSITORY"


//    suspend fun getMyPost():List<POST>{
//
//      return withContext(Dispatchers.IO){
//
//            Timber.d("list of posts called")
//            val postList = postApi.viewPosts()
//
//        }
//
//    }

    suspend fun getMyPostNow():List<POST>?{
        var data:List<POST>? = null
        withContext(Dispatchers.IO){
            try {
                data = postApi.viewPosts().await()
            } catch (t:Throwable){
                Log.e(TAG, t.message.toString())
            }
        }
        return data
    }



}