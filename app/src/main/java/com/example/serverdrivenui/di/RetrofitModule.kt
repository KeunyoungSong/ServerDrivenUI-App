package com.example.serverdrivenui.di

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.remote.ListItemDeserializer
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    @Named("BaseUrl")
    fun providesBaseUrl(): String {
        return "https://serverdrivenui-soeaddpmlq-uc.a.run.app"
    }

    @Provides
    @Singleton
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder().registerTypeAdapter(ListItem::class.java, ListItemDeserializer()).create()
        )
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
    }

    /**
     * Server Driven UI 사용을 위해 Mock 데이터를 사용
     */
    @Provides
    @Singleton
    fun providesRetrofit(
        client: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory,
        @Named("BaseUrl") baseUrl:String
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(client.build())
            .build()
    }
}