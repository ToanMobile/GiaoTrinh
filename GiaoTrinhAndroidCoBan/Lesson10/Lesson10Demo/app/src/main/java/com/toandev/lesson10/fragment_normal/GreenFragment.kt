package com.toandev.lesson10.fragment_normal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.orhanobut.logger.Logger
import com.toandev.lesson10.MainActivity
import com.toandev.lesson10.R

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GreenFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate (R.layout.fragment_green, container, false)
        view.findViewById<TextView>(R.id.test1).text = arguments?.getString(ARG_PARAM1)
        view.findViewById<TextView>(R.id.test2).text = arguments?.getInt(ARG_PARAM2).toString()
        view.findViewById<Button>(R.id.btnShowText).setOnClickListener {
            (context as? MainActivity)?.showText("Click Demo")
        }
        showToast()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast()
        showString()
    }

    fun updateCount(count: Int) {
        view?.findViewById<TextView>(R.id.test3)?.text = count.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: Int): GreenFragment {
            val greenFragment = GreenFragment()
            greenFragment.arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putInt(ARG_PARAM2, param2)
            }
            return greenFragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.e("onAttach")
        //(context as? MainActivity)?.clickFragment("hahahahaa")
    }

    override fun onStart() {
        super.onStart()
        Logger.e("onStart")
    }

    override fun onResume() {
        super.onResume()
        Logger.e("onPause")
    }

    override fun onStop() {
        super.onStop()
        Logger.e("onStop")
    }

    override fun onPause() {
        super.onPause()
        Logger.e("onPause")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.e("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.e("onDestroy")
    }

}
