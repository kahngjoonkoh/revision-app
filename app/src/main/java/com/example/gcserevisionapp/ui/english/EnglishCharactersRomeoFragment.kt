package com.example.gcserevisionapp.ui.english

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gcserevisionapp.R
import com.example.gcserevisionapp.TopicAdapter
import com.example.gcserevisionapp.databinding.FragmentEnglishBinding
import com.example.gcserevisionapp.databinding.FragmentEnglishCharactersRomeoBinding


class EnglishCharactersRomeoFragment : Fragment() {
    private var _binding: FragmentEnglishCharactersRomeoBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEnglishCharactersRomeoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}