package com.darka11y.android.squareproject.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"

/** Build [Moshi] object for [Retrofit] **/
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/** Build the [Retrofit] object using [Moshi] converter and object **/
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/** Public interface that exposes the [getEmployees] call **/
interface EmployeeDirectoryApiService {

    /** Returns a EmployeeData which is a [List] of [Employee] fetched in Coroutine scope **/
    @GET("employees.json")
    suspend fun getEmployees(): EmployeeData
}

/** Public [EmployeeDirectoryApi] object that exposes the lazy-initialized [Retrofit] service **/
object EmployeeDirectoryApi {
    val RETROFIT_SERVICE: EmployeeDirectoryApiService by lazy {
        retrofit.create(EmployeeDirectoryApiService::class.java)
    }
}