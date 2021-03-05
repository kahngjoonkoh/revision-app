package com.example.gcserevisionapp.ui.english

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gcserevisionapp.databinding.FragmentEnglishBinding


class EnglishFragment : Fragment() {
    private var _binding: FragmentEnglishBinding? = null

    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEnglishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerViewEnglish
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = EnglishAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}