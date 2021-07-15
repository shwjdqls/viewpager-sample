package com.shwjdqls.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.shwjdqls.test.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {
    private var _binding: FragmentLikeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { PersonAdapter(people1)}
    private val people1 = arrayListOf(
        Person("Jacob"),
        Person("Sindi"),
        Person("Kacof"),
        Person("Rachel"),
        Person("Soonka"),
        Person("Ebby"),
        Person("Ordin"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pagerAdapter = PagerAdapter(requireActivity())
        pagerAdapter.addFragment(SendFragment())
        pagerAdapter.addFragment(ReceiveFragment())
        binding.pager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = when (position) {
                0 -> "좋아요"
                1 -> "회원 반응"
                else -> "좋아요"
            }
        }.attach()

        binding.recyclerviewFirst.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerviewFirst.adapter = adapter

        binding.textviewListFirst.setOnClickListener {
            val isShrunk = adapter.resize()
        }
    }
}
