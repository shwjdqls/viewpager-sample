package com.shwjdqls.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.shwjdqls.test.databinding.FragmentLikeBinding
import com.shwjdqls.test.databinding.FragmentSendBinding

class SendFragment : Fragment() {
    private var _binding: FragmentSendBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { PersonAdapter(arrayListOf(Person(R.drawable.people_8,"a"), Person(R.drawable.people_9,"b"))) }
    private val people1 = arrayListOf(
        Person(R.drawable.people_1, "Jacob" ),
        Person(R.drawable.people_2,"Sindi"),
        Person(R.drawable.people_3,"Kacof"),
        Person(R.drawable.people_4,"Rachel"),
        Person(R.drawable.people_5,"Soonka"),
        Person(R.drawable.people_6,"Ebby"),
        Person(R.drawable.people_7,"Ordin"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerviewFirst.layoutManager = GridLayoutManager(requireActivity(), 3)
        adapter.setItems(people1)
        binding.recyclerviewFirst.adapter = adapter
    }
}
