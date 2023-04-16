package es.casensio.tutorial.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.casensio.tutorial.R
import es.casensio.tutorial.di.MyApplication

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).getApplicationComponent(this)
        setContentView(R.layout.activity_main)
    }
}