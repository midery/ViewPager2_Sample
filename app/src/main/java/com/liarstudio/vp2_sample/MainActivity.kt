package com.liarstudio.vp2_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: VP2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf(0, 1, 2)
        adapter = VP2Adapter(supportFragmentManager) { counter_tv.text = "Fragments count: $it" }
            .apply { this.items = items }

        main_pager.adapter = adapter

        add_btn.setOnClickListener {
            items.addAfter(main_pager.currentItem, items.size)
            adapter.items = items
        }

        delete_btn.setOnClickListener {
            if (items.size > 0) {
                items.removeAt(main_pager.currentItem)
                adapter.items = items
            }
        }
    }

    private fun <T> MutableList<T>.addAfter(position: Int, element: T) {
        if (size == 0 || position == size) add(element) else add(position + 1, element)
    }
}
