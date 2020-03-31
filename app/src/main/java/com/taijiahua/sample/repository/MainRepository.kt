package com.taijiahua.sample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taijiahua.sample.api.SampleService
import com.taijiahua.sample.vo.Label
import com.taijiahua.sample.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
  private val service: SampleService
) {

  fun loadLabel(): LiveData<Resource<List<Label>>> {
    val data = MutableLiveData<Resource<List<Label>>>()
    data.postValue(Resource.loading(null))
    service.getLabel().enqueue(object : Callback<List<Label>> {
      override fun onFailure(call: Call<List<Label>>, t: Throwable) {
        data.postValue(Resource.error("", null))
      }

      override fun onResponse(call: Call<List<Label>>, response: Response<List<Label>>) {
        data.postValue(Resource.success(response.body()))
      }

    })
    return data
  }
}