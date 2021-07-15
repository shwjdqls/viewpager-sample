package com.shwjdqls.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.shwjdqls.test.databinding.FragmentSendBinding

class SendFragment : Fragment() {
    private var _binding: FragmentSendBinding? = null
    private val binding get() = _binding!!
    private val adapter1 by lazy { PersonAdapter() }
    private val adapter2 by lazy { PersonAdapter() }
    private val adapter3 by lazy { PersonAdapter() }

    private val people1 = arrayListOf(
        Person(R.drawable.people_1,"Jacob"),
        Person(R.drawable.people_2,"Sindi"),
        Person(R.drawable.people_3,"Kacof"),
        Person(R.drawable.people_4,"Rachel"),
        Person(R.drawable.people_5,"Soonka"),
        Person(R.drawable.people_6,"Ebby"),
        Person(R.drawable.people_7,"Ordin"),
        Person(R.drawable.people_8,"Navy"),
    )

    private val people2 = arrayListOf(
        Person(R.drawable.people_1,"Jacob"),
        Person(R.drawable.people_2,"Sindi"),
        Person(R.drawable.people_3,"Kacof"),
    )

    private val people3 = arrayListOf(
        Person(R.drawable.people_1,"Jacob"),
        Person(R.drawable.people_2,"Sindi"),
        Person(R.drawable.people_3,"Kacof"),
        Person(R.drawable.people_4,"Rachel"),
        Person(R.drawable.people_5,"Soonka"),
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
        adapter1.setItems(people1)
        adapter2.setItems(people2)
        adapter3.setItems(people3)

        if (adapter1.itemCount < 6) {
            binding.textviewList1.visibility = View.GONE
            binding.imageView1.visibility = View.GONE
        }
        if (adapter2.itemCount < 6) {
            binding.textviewList2.visibility = View.GONE
            binding.imageView2.visibility = View.GONE
        }
        if (adapter3.itemCount < 6) {
            binding.textviewList3.visibility = View.GONE
            binding.imageView3.visibility = View.GONE
        }

        binding.recyclerview1.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerview1.adapter = adapter1
        binding.textviewList1.setOnClickListener {
            val isShrunk = adapter1.resize()
            if (isShrunk) {
                binding.textviewList1.text = "목록 더 보기"
            } else {
                binding.textviewList1.text = "목록 닫기"
            }
        }

        binding.recyclerview2.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerview2.adapter = adapter2
        binding.textviewList2.setOnClickListener {
            val isShrunk = adapter2.resize()
            if (isShrunk) {
                binding.textviewList2.text = "목록 더 보기"
            } else {
                binding.textviewList2.text = "목록 닫기"
            }
        }

        binding.recyclerview3.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerview3.adapter = adapter3
        binding.textviewList3.setOnClickListener {
            val isShrunk = adapter3.resize()
            if (isShrunk) {
                binding.textviewList3.text = "목록 더 보기"
            } else {
                binding.textviewList3.text = "목록 닫기"
            }
        }

        binding.imageViewDelete1.setOnClickListener {
            adapter1.setDeleteModeOrDelete()
            if (adapter1.itemCount < 6) {
                binding.textviewList1.visibility = View.GONE
                binding.imageView1.visibility = View.GONE
            }
        }

        binding.imageViewDelete2.setOnClickListener {
            adapter2.setDeleteModeOrDelete()
            if (adapter2.itemCount < 6) {
                binding.textviewList2.visibility = View.GONE
                binding.imageView2.visibility = View.GONE
            }
        }

        binding.imageViewDelete3.setOnClickListener {
            adapter3.setDeleteModeOrDelete()
            if (adapter3.itemCount < 6) {
                binding.textviewList3.visibility = View.GONE
                binding.imageView3.visibility = View.GONE
            }
        }
    }
}
