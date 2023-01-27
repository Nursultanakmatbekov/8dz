package com.example.a8dz.ui.fragments

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import com.example.a8dz.databinding.FragmentFirstBinding
import com.example.a8dz.ui.utils.MyNotificationService
import com.example.a8dz.ui.utils.edtextExtra
import com.example.a8dz.ui.utils.notificationID
import java.util.Calendar
import kotlin.concurrent.timer

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
        val edtext = binding?.edText?.text.toString()
        binding?.btnSend?.setOnClickListener {
            edtextExtra = edtext
            service.showNotification()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}