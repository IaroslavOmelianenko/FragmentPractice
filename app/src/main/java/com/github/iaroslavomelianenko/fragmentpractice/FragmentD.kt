package com.github.iaroslavomelianenko.fragmentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.iaroslavomelianenko.fragmentpractice.databinding.FragmentDBinding


class FragmentD : Fragment() {

    lateinit var _binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding.bToA.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentA.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentD()
    }
}