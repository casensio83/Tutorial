package es.casensio.tutorial.networking

import es.casensio.tutorial.model.Repo
import retrofit2.Call
import retrofit2.http.GET

interface RepoService {

    @GET("org/Google/repos")
    fun getRepositories(): Call<List<Repo>>
}