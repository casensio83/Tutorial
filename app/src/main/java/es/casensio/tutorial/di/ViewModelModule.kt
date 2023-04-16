package es.casensio.tutorial.di

import dagger.Module
import dagger.Provides
import es.casensio.tutorial.home.ListViewModel
import es.casensio.tutorial.networking.RepoService

@Module
object ViewModelModule {

    @Provides
    fun provideListViewModel(repoService: RepoService): ListViewModel  =
        ListViewModel(repoService)

}

