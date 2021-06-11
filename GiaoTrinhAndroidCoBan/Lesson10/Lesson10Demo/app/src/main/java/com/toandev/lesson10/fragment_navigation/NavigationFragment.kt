package com.toandev.lesson10.fragment_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.toandev.lesson10.R
import com.toandev.lesson10.fragment_normal.BaseFragment

class NavigationFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<Button>(R.id.btnClickOpenFragment).setOnClickListener {
            showToast()
            findNavController().navigate(NavigationFragmentDirections.clickFragmentData("Test1234",true))
        }
    }
}
