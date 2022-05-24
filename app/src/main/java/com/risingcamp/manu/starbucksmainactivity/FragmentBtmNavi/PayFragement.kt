package com.risingcamp.manu.starbucksmainactivity.FragmentBtmNavi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.risingcamp.manu.starbucksmainactivity.R

class PayFragement : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val payView = inflater.inflate(R.layout.fragment_pay, container, false)
        return payView
    }
}