package com.github.iaroslavomelianenko.fragmentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.iaroslavomelianenko.fragmentpractice.databinding.FragmentCBinding


class FragmentC : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var _binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Receiving message from viewModel
        _binding.tvTextFromB.text = dataModel.message.value

        _binding.bToD.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentD.newInstance())
                .commit()
        }

        _binding.bBackToB.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentB.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentC()
    }
}