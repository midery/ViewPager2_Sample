package com.liarstudio.vp2_sample

import android.graphics.LinearGradient
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class VP2Adapter(fm: FragmentManager) :
    FragmentStateAdapter(fm) {

    var items = emptyList<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItem(position: Int): Fragment {
        return VP2Fragment::class.java.newInstance().apply { arguments = bundleOf("position" to items[position]) }
    }

    override fun getItemCount(): Int = items.size
}