package com.github.iaroslavomelianenko.fragmentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.iaroslavomelianenko.fragmentpractice.databinding.FragmentABinding
import com.github.iaroslavomelianenko.fragmentpractice.databinding.FragmentBBinding


class FragmentA : Fragment() {

    lateinit var _binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding.bToB.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentB.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}