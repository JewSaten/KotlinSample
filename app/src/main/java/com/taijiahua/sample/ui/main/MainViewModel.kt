package com.taijiahua.sample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.taijiahua.sample.repository.MainRepository
import com.taijiahua.sample.vo.Label
import com.taijiahua.sample.vo.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
  private val _labels: MediatorLiveData<Resource<List<Label>>> = MediatorLiveData()
  val labels: LiveData<Resource<List<Label>>>
    get() = mainRepository.loadLabel()

  fun load() {
    _labels.addSource(mainRepository.loadLabel()) {
      _labels.value = it
    }
  }
}
