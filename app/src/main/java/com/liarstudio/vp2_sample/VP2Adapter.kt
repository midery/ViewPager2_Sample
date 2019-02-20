package com.liarstudio.vp2_sample

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class VP2Adapter(fm: FragmentManager, private val countChangeAction: (newCount: Int) -> Unit) : FragmentStateAdapter(fm) {

    var count = 0
    set(value) {
        field = value
        notifyDataSetChanged()
        countChangeAction(value)
    }

    override fun getItem(position: Int): Fragment =
        VP2Fragment::class.java.newInstance().apply { arguments = bundleOf("position" to position) }

    override fun getItemCount(): Int = count
}