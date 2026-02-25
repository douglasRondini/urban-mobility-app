package com.douglasrondini.movinvel.ui.fragment.motorista.carteira.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasrondini.movinvel.databinding.ItemAtividadeCarteiraBinding
import com.douglasrondini.movinvel.ui.fragment.motorista.carteira.model.AtividadesCarteira

class AtividadesCarteiraAdapter(
    private val list: List<AtividadesCarteira>
): RecyclerView.Adapter<AtividadesCarteiraAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemAtividadeCarteiraBinding.inflate(
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
        private val binding: ItemAtividadeCarteiraBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AtividadesCarteira) {
            binding.icon.setImageResource(item.icon)
            binding.title.text = item.title
            binding.description.text = item.description
            binding.date.text = item.date
            binding.value.text = item.value
            binding.porcent.text = item.porcent
        }
    }
}