package es.casensio.tutorial.di

import dagger.Module
import dagger.Provides
import es.casensio.tutorial.networking.RepoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL: String = "https://api.github.com/"

@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideService(retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)

}