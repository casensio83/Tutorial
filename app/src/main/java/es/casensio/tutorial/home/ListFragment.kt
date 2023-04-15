package es.casensio.tutorial.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import es.casensio.tutorial.R

class ListFragment: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var errorMessage: TextView
    private lateinit var progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        errorMessage = view.findViewById(R.id.error_message)
        progressBar = view.findViewById(R.id.progressbar)
    }
}