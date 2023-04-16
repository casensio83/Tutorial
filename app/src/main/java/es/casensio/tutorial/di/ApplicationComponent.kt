package es.casensio.tutorial.di

import dagger.Component
import es.casensio.tutorial.home.ListFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(listFragment: ListFragment)

}