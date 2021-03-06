package com.taijiahua.sample.di

import com.taijiahua.sample.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
}