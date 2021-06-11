package com.toandev.lesson10.fragment_normal

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun showToast() {
        Toast.makeText(requireContext(), "Toan Test hahahaha", Toast.LENGTH_LONG).show()
    }

    fun showString() :String {
        return "Toan";
    }
}