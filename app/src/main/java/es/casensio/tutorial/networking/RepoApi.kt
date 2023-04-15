package es.casensio.tutorial.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://api.github.com/"

class RepoApi {

    private var retrofit: Retrofit? = null
    private var reposService: RepoService? = null

    fun getInstance(): RepoService? {
        if(reposService != null) {
            return reposService as RepoService
        }
        if(retrofit == null) {
            initializeRetrofit()
        }
        reposService = retrofit?.create(RepoService::class.java)
        return reposService
    }

    private fun initializeRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}