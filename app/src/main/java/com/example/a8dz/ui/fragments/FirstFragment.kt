package com.example.a8dz.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a8dz.databinding.FragmentFirstBinding
import com.example.a8dz.ui.utils.MyNotificationService
import com.example.a8dz.ui.utils.editTextExtra

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private lateinit var service: MyNotificationService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListeners()
    }

    private fun initialize() {
        service = MyNotificationService(requireContext())
    }

    private fun setUpListeners() {
        binding?.btnSend?.setOnClickListener {
            val edtext = binding?.edText?.text.toString().trim()
            editTextExtra = edtext
            service.showNotification()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}