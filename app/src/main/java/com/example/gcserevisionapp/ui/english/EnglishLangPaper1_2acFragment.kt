package com.example.gcserevisionapp.ui.english

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.gcserevisionapp.databinding.FragmentEnglishLangPaper12acBinding


class EnglishLangPaper1_2acFragment : Fragment() {
    private var _binding: FragmentEnglishLangPaper12acBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEnglishLangPaper12acBinding.inflate(inflater, container, false)
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