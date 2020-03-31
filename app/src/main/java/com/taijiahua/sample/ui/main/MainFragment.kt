package com.taijiahua.sample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.taijiahua.sample.R
import com.taijiahua.sample.di.Injectable
import timber.log.Timber
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {
  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  companion object {
    fun newInstance() = MainFragment()
  }

  private val viewModel: MainViewModel by viewModels{
    viewModelFactory
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.main_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    Timber.d("onActivityCreated")
    viewModel.labels.observe(viewLifecycleOwner, Observer {
      Timber.d(it.toString())
    })
    viewModel.load()
  }

}
