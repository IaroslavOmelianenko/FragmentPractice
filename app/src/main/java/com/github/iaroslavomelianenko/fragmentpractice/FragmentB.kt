package com.github.iaroslavomelianenko.fragmentpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.github.iaroslavomelianenko.fragmentpractice.databinding.FragmentBBinding


class FragmentB : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var _binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding.bToC.setOnClickListener{
            //Saving message in viewModel for fragment C
            dataModel.message.value = _binding.etTextForC.text.toString()
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentC.newInstance())
                .commit()
        }

        _binding.bBackToA.setOnClickListener{
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.flMain, FragmentA.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentB()
    }
}