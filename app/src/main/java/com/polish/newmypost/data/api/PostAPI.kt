package com.polish.newmypost.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.polish.newmypost.constants.URLConstants
import com.polish.newmypost.constants.URLEndpoints
import com.polish.newmypost.model.POST
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostAPI {

    @GET(URLEndpoints.POST_ENDPOINT)
   suspend fun viewPosts():Deferred<List<POST>>

    companion object {

        operator fun invoke():PostAPI {

            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(URLConstants.BASE_URL)
                .client(client)
                .build()
                .create(PostAPI::class.java)

        }

    }

}