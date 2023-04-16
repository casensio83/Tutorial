package es.casensio.tutorial.di

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.create()
    }

    fun getApplicationComponent(context: Context): ApplicationComponent =
        ((context.applicationContext) as MyApplication).component

}