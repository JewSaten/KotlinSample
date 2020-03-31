package com.taijiahua.sample.api

import com.taijiahua.sample.vo.Label
import retrofit2.Call
import retrofit2.http.GET

interface SampleService {
  @GET("label")
  fun getLabel(): Call<List<Label>>
}