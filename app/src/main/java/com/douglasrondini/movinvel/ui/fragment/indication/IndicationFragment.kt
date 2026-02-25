package com.douglasrondini.movinvel.ui.fragment.indication

import android.animation.ObjectAnimator
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.douglasrondini.movinvel.databinding.FragmentIndicationBinding

class IndicationFragment : Fragment() {

    private lateinit var binding: FragmentIndicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIndicationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startLogoAnimation()
        setupUI()

    }

    private fun setupUI() {

        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnColar.setOnClickListener {
            val text = binding.txtCodigo.text.toString()
            setupCopyButton(text)
        }
        binding.btnCoiar.setOnClickListener {
            val text = binding.txtLink.text.toString()
            setupCopyButton(text)
        }
        binding.btnIndicar.setOnClickListener {
            setupShareButton()
        }


    }

    private fun startLogoAnimation() {
        val bouneAnim = ObjectAnimator.ofFloat(binding.imgLogo,"translationY", 0f, -50f, 0f )
        bouneAnim.duration = 2000
        bouneAnim.repeatCount = ObjectAnimator.INFINITE
        bouneAnim.interpolator = OvershootInterpolator()
        bouneAnim.start()
    }

    private fun setupCopyButton(text: String) {
            val text = text
            val clipboard = requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("codigo", text)
            clipboard.setPrimaryClip(clip)


            Toast.makeText(context, "Código copiado para a área de transferência", Toast.LENGTH_SHORT).show()


    }

    private fun setupShareButton() {
        val link = binding.txtLink.text.toString()

        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Regístrate en MoviNível y empieza a ganar con tus viajes y referidos. $link"
            )
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                "WhatsApp não está instalado",
                Toast.LENGTH_SHORT
            ).show()

        }
    }


}