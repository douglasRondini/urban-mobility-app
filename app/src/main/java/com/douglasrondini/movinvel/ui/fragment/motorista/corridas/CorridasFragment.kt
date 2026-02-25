package com.douglasrondini.movinvel.ui.fragment.motorista.corridas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglasrondini.movinvel.R
import com.douglasrondini.movinvel.databinding.FragmentCorridasBinding
import com.douglasrondini.movinvel.ui.fragment.motorista.corridas.adapter.CorridasAdapter
import com.douglasrondini.movinvel.ui.fragment.motorista.corridas.model.CorridaItem

class CorridasFragment : Fragment() {
    private lateinit var binding: FragmentCorridasBinding

    private lateinit var corridasAdapter: CorridasAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCorridasBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        val tabs = listOf(
            binding.tabConcluidas, binding.tabAtivas, binding.tabCancelada
        )

        tabs.forEach { tab ->
            tab.setOnClickListener {
                tabs.forEach { it.isSelected = false }
                tab.isSelected = true

                when (tab.id) {
                    binding.tabConcluidas.id -> 0
                    binding.tabAtivas.id -> 1
                    binding.tabCancelada.id -> 2
                }

            }


        }

        val corridas = listOf(
            CorridaItem.Header("Hoje"),
            CorridaItem.Corridas(
                R.drawable.img_login,
                "Ana Silva",
                "UberX",
                "R$ 24,90",
                "14:30",
                "Concluida",
                "+ R$ 0,50 Cashback",
                "Av. Paulista, 1000",
                "R. Augusta, 500"
            ),
            CorridaItem.Corridas(
                R.drawable.img_login,
                "Carlos Mendes",
                "Black",
                "R$ 45,90",
                "13:30",
                "Concluida",
                "+ R$ 1,50 Cashback",
                "Aeroporto de Congonhas",
                "Hotel Unique - Jardins"
            ),
            CorridaItem.Header("Ontem"),
            CorridaItem.Corridas(
                R.drawable.img_login,
                "Maria Silva",
                "UberX",
                "R$ 24,90",
                "14:30",
                "Concluida",
                "+ R$ 0,50 Cashback",
                "Av. Paulista, 1000",
                "R. Augusta, 500"
            ),


        )

        corridasAdapter = CorridasAdapter(corridas)

        binding.recyclewViewHistorico.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = corridasAdapter
            setHasFixedSize(true)
        }
    }


}