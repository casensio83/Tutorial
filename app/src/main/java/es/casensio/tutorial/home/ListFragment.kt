package es.casensio.tutorial.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.casensio.tutorial.R

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var errorMessage: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        errorMessage = view.findViewById(R.id.error_message)
        progressBar = view.findViewById(R.id.progressbar)

        adapter = RepoListAdapter()
        setUpRecyclerView()

        viewModel = ViewModelProviders.of(this)[ListViewModel::class.java]
        observeViewModel()
    }

    private fun setUpRecyclerView() {
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        viewModel.repos.observe(viewLifecycleOwner) { repos ->
            if (repos != null) {
                recyclerView.visibility = View.VISIBLE
                adapter.data = repos
            }
        }

        viewModel.repoLoadError.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                recyclerView.visibility = View.GONE
                errorMessage.visibility = View.VISIBLE
                errorMessage.text = resources.getText(R.string.api_error_repos)
            } else {
                errorMessage.visibility = View.GONE
                errorMessage.text = null
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE

            if (isLoading) {
                recyclerView.visibility = View.GONE
                errorMessage.visibility = View.GONE
            }
        }
    }
}