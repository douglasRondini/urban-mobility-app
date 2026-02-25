package com.douglasrondini.movinvel.ui.fragment.motorista.carteira

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglasrondini.movinvel.R
import com.douglasrondini.movinvel.databinding.FragmentMotoristaCarteiraBinding
import com.douglasrondini.movinvel.ui.fragment.motorista.carteira.adapter.AtividadesCarteiraAdapter
import com.douglasrondini.movinvel.ui.fragment.motorista.carteira.model.AtividadesCarteira

class MotoristaCarteiraFragment : Fragment() {
    private lateinit var binding: FragmentMotoristaCarteiraBinding

    private lateinit var carteiraAdapter: AtividadesCarteiraAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMotoristaCarteiraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabs = listOf(
            binding.tabDiario, binding.tabMensal, binding.tabSemanal
        )

        tabs.forEach { tab ->
            tab.setOnClickListener {
                tabs.forEach { it.isSelected = false }
                tab.isSelected = true

                when (tab.id) {
                    binding.tabDiario.id -> 0
                    binding.tabSemanal.id -> 1
                    binding.tabMensal.id -> 2

                }

            }


        }
        val atividadesCarteira = listOf(
            AtividadesCarteira(
                R.drawable.iccorrida,
                "Corrida #4923",
                "Centro • Aeroporto Internaciona",
                "Hoje, 14:30",
                "+ R$ 45,00",
                "80%"
            ),
            AtividadesCarteira(
                R.drawable.iccorrida,
                "Corrida #4924",
                "Centro • Aeroporto Internaciona",
                "Hoje, 15:30",
                "+ R$ 45,00",
                "80%"
            ),
            AtividadesCarteira(
                R.drawable.icbonus,
                "Bônus de Indicação",
                "Novo motorista: Marcos Silva",
                "Ontem, 09:15",
                "+ R$ 15,00",
                "CashBack"
            )
        )

        carteiraAdapter = AtividadesCarteiraAdapter(atividadesCarteira)
        binding.recyclewViewCarteira.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = carteiraAdapter
            setHasFixedSize(true)
        }

        binding.btnSaque.setOnClickListener {
            findNavController().navigate(R.id.action_MotoristaCarteiraFragment_to_saqueFragment)
        }


    }


}