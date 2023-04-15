package es.casensio.tutorial.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.casensio.tutorial.model.Repo
import es.casensio.tutorial.networking.RepoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    private val _repos: MutableLiveData<List<Repo>> = MutableLiveData()
    private val _repoLoadError: MutableLiveData<Boolean> = MutableLiveData()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    val repos: LiveData<List<Repo>>
        get() = _repos

    val repoLoadError: LiveData<Boolean>
        get() = _repoLoadError

    val loading: LiveData<Boolean>
        get() = _loading

    private var repoCall: Call<List<Repo>>? = null

    init {
        fetchRepos()
    }

    private fun fetchRepos() {
        _loading.value = true
        repoCall = RepoApi().getInstance()?.getRepositories()
        repoCall?.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                _repos.value = response.body()
                _repoLoadError.value = false
                _loading.value = false
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.e("", t.message.toString())
                _repoLoadError.value = true
                _loading.value = false
            }

        })
    }

    override fun onCleared() {
        if (repoCall != null) {
            repoCall?.cancel()
            repoCall = null
        }
    }

}