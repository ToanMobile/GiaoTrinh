package com.toandev.lesson10.fragment_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.toandev.lesson10.R
import com.toandev.lesson10.fragment_normal.BaseFragment

class NavigationDataFragment : BaseFragment() {
    private val arguments: NavigationDataFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.findViewById<TextView>(R.id.testData).text = arguments.toanTest
        view?.findViewById<TextView>(R.id.testData1).text = arguments.toanDev.toString()
        showToast()
        showString()
    }
}
