package com.liarstudio.vp2_sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_vp2.*

class VP2Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.layout_vp2, container, false)

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val position = arguments?.getInt("position") ?: 0
        val bgColorRes = if (position % 2 == 0) R.color.colorAccent else android.R.color.holo_green_light
        name_tv.text = "Fragment ${position + 1}"
        name_tv.setBackgroundColor(ContextCompat.getColor(context ?: return, bgColorRes))
    }
}