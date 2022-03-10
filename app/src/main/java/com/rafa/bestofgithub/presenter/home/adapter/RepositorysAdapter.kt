package com.rafa.bestofgithub.presenter.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafa.bestofgithub.R
import com.rafa.bestofgithub.domain.model.Items

class RepositorysAdapter : PagingDataAdapter<Items, RepositorysAdapter.RepositoryViewHolder>(comparacao) {

    companion object {
        private val comparacao = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
               return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindData(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder{
        return  RepositoryViewHolder(
         LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )
    }

    inner class RepositoryViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bindData(item: Items){
            itemView.findViewById<TextView>(R.id.item_txt_stars_qtd).text = item.qtdEstrelas.toString()
            itemView.findViewById<TextView>(R.id.item_txt_fork_qtd).text = item.qtdFork.toString()
            itemView.findViewById<TextView>(R.id.item_txt_nome_repo).text = item.nomeRepo.toString()
            itemView.findViewById<TextView>(R.id.item_txt_owner_nome_repo).text = item.nomeOwner.toString()
            Glide.with(itemView.context).load(item.avatarOwner).into(itemView.findViewById<ImageView>(R.id.item_img_icon_repo))
            Glide.with(itemView.context).load(item.avatarOwner).into(itemView.findViewById<ImageView>(R.id.item_img_banner_repo))
        }
    }
}