package com.douglasrondini.movinvel.ui.fragment.minhaRede.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasrondini.movinvel.databinding.ItemAtividadeRecenteBinding
import com.douglasrondini.movinvel.ui.fragment.minhaRede.model.AtividadeRecente

class AtividadesRecentesAdapter(
    private val list: List<AtividadeRecente>
) : RecyclerView.Adapter<AtividadesRecentesAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemAtividadeRecenteBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        private val binding: ItemAtividadeRecenteBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AtividadeRecente) {
            binding.title.text = item.title
            binding.message.text = item.message
            binding.value.text = item.value
            binding.icon.setImageResource(item.icon)
        }
    }
}