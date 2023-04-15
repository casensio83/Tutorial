package es.casensio.tutorial.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.casensio.tutorial.R
import es.casensio.tutorial.model.Repo
import java.util.Collections.emptyList

class RepoListAdapter: RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>() {

    var data: List<Repo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val repoName: TextView = itemView.findViewById(R.id.repo_name)
        private val repoDescription: TextView = itemView.findViewById(R.id.repo_description)
        private val forks: TextView = itemView.findViewById(R.id.forks)
        private val stars: TextView = itemView.findViewById(R.id.stars)

        fun bind(repo: Repo) {
            repoName.text = repo.name
            repoDescription.text = repo.description
            forks.text = repo.forks.toString()
            stars.text = repo.stars.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_repo_list_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    override fun getItemId(position: Int): Long = data[position].id
}