package com.douglasrondini.movinvel.ui.fragment.minhaRede

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.douglasrondini.movinvel.R
import com.douglasrondini.movinvel.databinding.FragmentMinhaRedeBinding
import com.douglasrondini.movinvel.ui.fragment.minhaRede.adapter.AtividadesRecentesAdapter
import com.douglasrondini.movinvel.ui.fragment.minhaRede.model.AtividadeRecente

class MinhaRedeFragment : Fragment() {
    private lateinit var binding: FragmentMinhaRedeBinding

    private lateinit var atividadesRecentesAdapter: AtividadesRecentesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMinhaRedeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnIndicar.setOnClickListener {
            findNavController().navigate(R.id.action_minhaRedeFragment_to_indicationFragment)
        }

        val listAtividades = listOf(
            AtividadeRecente("Nuevo miembro de nivel 2","Recomendación de João S.","+ R$ 2,50",R.drawable.ic_new_menber),
            AtividadeRecente("Reembolso de carrera","Maria L. (Nível 1)","+ R$ 0,75",R.drawable.ic_cashback)
        )

        atividadesRecentesAdapter = AtividadesRecentesAdapter(listAtividades)

        binding.recyclerViewAtividades.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = atividadesRecentesAdapter
            setHasFixedSize(true)
        }

    }


}