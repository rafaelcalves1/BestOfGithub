package com.rafa.bestofgithub.presenter.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafa.bestofgithub.databinding.ItemRepositoryBinding
import com.rafa.bestofgithub.domain.model.Items

class RepositorysAdapter : PagingDataAdapter<Items, RecyclerView.ViewHolder>(comparacao) {

    lateinit var binding: ItemRepositoryBinding

    companion object {
        private val comparacao = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let{
            (holder as RepositoryViewHolder).bindData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    inner class RepositoryViewHolder(binding: ItemRepositoryBinding): RecyclerView.ViewHolder(binding.root){

        fun bindData(item: Items){
            binding.itemTxtStarsQtd.text = item.qtdEstrelas.toString()
            binding.itemTxtForkQtd.text = item.qtdFork.toString()
            binding.itemTxtNomeRepo.text = item.nomeRepo.toString()
            binding.itemTxtOwnerNomeRepo.text = item.nomeOwner.toString()
            Glide.with(binding.root.context).load(item.avatarOwner).into(binding.itemImgIconRepo)
            Glide.with(binding.root.context).load(item.avatarOwner).into(binding.itemImgBannerRepo)
        }
    }
}