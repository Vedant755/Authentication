package com.example.authentication.di

import com.example.authentication.api.ApiInterface
import com.example.authentication.api.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


    @InstallIn(SingletonComponent::class)
    @Module
    class NetworkModule {

        @Singleton
        @Provides
        fun providesRetrofit(): Retrofit.Builder {
            return Retrofit.Builder().baseUrl("10.0.2.2:9090")
                .addConverterFactory(GsonConverterFactory.create())
        }



        @Singleton
        @Provides
        fun providesUserAPI(retrofitBuilder: Retrofit.Builder): ApiInterface {
            return retrofitBuilder.build().create(ApiInterface::class.java)
        }
        @Singleton
        @Provides
        fun provideOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }
    }
