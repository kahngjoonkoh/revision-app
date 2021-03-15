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

    /* Since data structure is Map<String, Map<String, Map<String, Int>>>
     * It should use the UnitAdapter2
     */
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
        ),
        "An Inspector Calls" to mapOf(

        ),
        "English Language" to mapOf(
            "Paper 1" to mapOf(
                "Questions 1A - E" to R.id.nav_english_paper1_1ae,
                "Question 1F" to R.id.nav_english_paper1_1f,
                "Questions 2A - C" to R.id.nav_english_paper1_2ac,
                "Question 2D" to R.id.nav_english_paper1_2d,
                "Question 3" to R.id.nav_english_paper1_3
            ),
            "Paper 2" to mapOf(
            )
        ),
        "Poetry" to mapOf(
            "Love and Relationships" to mapOf(),
            "Unseen Poetry" to mapOf()
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