package com.example.gcserevisionapp.ui.english

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gcserevisionapp.R
import com.example.gcserevisionapp.UnitAdapter
import com.example.gcserevisionapp.UnitAdapter2
import com.example.gcserevisionapp.databinding.FragmentEnglishBinding


class EnglishFragment : Fragment() {
    private var _binding: FragmentEnglishBinding? = null

    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!

    private val data: Map<String, Map<String, Map<String, Int>>> = mapOf(
        "Romeo and Juliet" to mapOf(
            "Analysis of Acts" to mapOf(),
            "Characters" to mapOf(
                "Romeo" to R.id.nav_english_characters_romeo,
                "Juliet" to R.id.nav_english_characters_juliet
            ),
            "Context and Themes" to mapOf(),
            "Shakespeare's Techniques" to mapOf(),
            "Exam Practice" to mapOf()
        )
    )

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
        recyclerView.adapter = UnitAdapter2(data, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}