package com.taijiahua.sample.di

import com.taijiahua.sample.API_URL
import com.taijiahua.sample.BuildConfig
import com.taijiahua.sample.api.SampleService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
  @Singleton
  @Provides
  fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor(
      object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
          Timber.tag("OkHttp").d(message)
        }
      }
    ).apply {
      level = HttpLoggingInterceptor.Level.BODY
    }

  @Singleton
  @Provides
  fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
//      addInterceptor { chain ->
//        val builder = chain.request().newBuilder()
//          .header("Phone-Platform-Type", "Android")
//        chain.proceed(builder.build())
//      }
      if (BuildConfig.DEBUG) {
        addInterceptor(loggingInterceptor)
      }
    }.build()

  @Singleton
  @Provides
  fun provideSampleService(client: OkHttpClient): SampleService {
    return Retrofit.Builder()
      .client(client)
      .baseUrl(API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(SampleService::class.java)
  }
}