package com.github.iaroslavomelianenko.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import com.github.iaroslavomelianenko.fragmentpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flMain, FragmentA.newInstance())
            .commit()

        dataModel.message.observe(this) {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}