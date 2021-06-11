package com.toandev.lesson10.fragment_normal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.toandev.lesson10.MainActivity
import com.toandev.lesson10.R

class RedFragment : BaseFragment() {
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_red, container, false)
        view.findViewById<Button>(R.id.btnCount).setOnClickListener {
            count++
            (context as? MainActivity)?.sumCount(count)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = RedFragment()
    }
}
