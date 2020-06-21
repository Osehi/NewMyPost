package com.polish.newmypost.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.newmypost.databinding.ListItemPostBinding
import com.polish.newmypost.model.POST

class POSTAdapter(val clickListener:OnClickListener): ListAdapter<POST, POSTAdapter.POSTViewHolder>(DiffCallback){

    class POSTViewHolder(var binding: ListItemPostBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(post:POST, clickListener: OnClickListener){

            binding.post = post

            binding.clickListener = clickListener

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<POST>(){
        override fun areItemsTheSame(oldItem: POST, newItem: POST): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: POST, newItem: POST): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POSTViewHolder {
        return POSTViewHolder(ListItemPostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: POSTViewHolder, position: Int) {
        val post = getItem(position)

        holder.bind(post, clickListener)

    }

    class OnClickListener(val clickListener:(post:POST) -> Unit){

        fun onClick(post: POST) = clickListener(post)

    }


}