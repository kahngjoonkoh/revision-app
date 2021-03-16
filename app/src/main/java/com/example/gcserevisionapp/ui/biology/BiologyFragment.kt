package com.example.gcserevisionapp.ui.biology

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gcserevisionapp.R
import com.example.gcserevisionapp.UnitAdapter
import com.example.gcserevisionapp.UnitAdapter2
import com.example.gcserevisionapp.databinding.FragmentEnglishBinding


class BiologyFragment : Fragment() {
    private var _binding: FragmentEnglishBinding? = null

    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!

    /* Since data structure is Map<String, Map<String, Int>>
     * It should use the UnitAdapter
     */
    private val data: Map<String, Map<String, Int>> = mapOf(
        "B1 " to mapOf()
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
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = UnitAdapter(data, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}