package com.douglasrondini.movinvel.ui.fragment.motorista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.douglasrondini.movinvel.R
import com.douglasrondini.movinvel.databinding.FragmentMotoristaHomeBinding

class MotoristaHomeFragment : Fragment() {
    private lateinit var binding: FragmentMotoristaHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMotoristaHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        binding.btnMiRed.setOnClickListener {
            findNavController().navigate(R.id.action_MotoristaHomeFragment_to_minhaRedeFragment)
        }
        binding.btnCarteira.setOnClickListener {
            findNavController().navigate(R.id.MotoristaCarteiraFragment)
        }

    }


}