package com.douglasrondini.movinvel.ui.fragment.motorista.corridas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasrondini.movinvel.R
import com.douglasrondini.movinvel.databinding.ItemHeaderBinding
import com.douglasrondini.movinvel.databinding.ItemRideBinding
import com.douglasrondini.movinvel.ui.fragment.motorista.corridas.model.CorridaItem

class CorridasAdapter(
    private val list: List<CorridaItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_RIDE = 1

    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position]) {
            is CorridaItem.Header -> TYPE_HEADER
            is CorridaItem.Corridas -> TYPE_RIDE
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = ItemHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
            HeaderViewHolder (view)
        } else {
            val view = ItemRideBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
            RideViewHolder (view)
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (val list = list[position]) {
            is CorridaItem.Header -> (holder as HeaderViewHolder).bind(list)
            is CorridaItem.Corridas -> (holder as RideViewHolder). bind(list)
        }
    }

    override fun getItemCount(): Int = list.size



    inner class RideViewHolder(
        val binding: ItemRideBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CorridaItem.Corridas) {
            binding.imgPerfil.setImageResource(item.imgPerfil)
            binding.Name.text = item.name
            binding.type.text = item.type
            binding.value.text = item.value
            binding.time.text = item.time
            binding.from.text = item.from
            binding.to.text = item.to
            binding.status.text = item.status
            binding.cashback.text = item.cashBack
        }
    }

    inner class HeaderViewHolder(
        val binding: ItemHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(header: CorridaItem.Header) {
            binding.header.text = header.title

        }
    }
}