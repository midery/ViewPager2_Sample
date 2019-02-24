package com.liarstudio.vp2_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.liarstudio.vp2_sample.controller.EasyController
import kotlinx.android.synthetic.main.activity_main.*
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

class MainActivity : AppCompatActivity() {

//    private lateinit var adapter: VP2Adapter

    private val easyController = EasyController()
    val items = mutableListOf(0, 1, 2)

    val adapter = EasyAdapter()
        .apply { setFirstInvisibleItemEnabled(false) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*VP2Adapter(supportFragmentManager) { counter_tv.text = "Fragments count: $it" }
           .apply { this.items = items }
*/
        main_pager.adapter = adapter
        main_pager.stateListAnimator

        main_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.d("111111", "page selected: $position")
            }
        })
        adapter.setItems(makeItems())

        add_btn.setOnClickListener {
            addAfterCurrent()
            counter_tv.text = "Items count: ${items.size}"
        }

        delete_btn.setOnClickListener {
            deleteCurrent()
            counter_tv.text = "Items count: ${items.size}"
        }
    }

    private fun addAfterCurrent() {
        val position = main_pager.currentItem
        val size = items.size
        if (size == 0 || position == size) items.add(size) else items.add(position + 1, size)
        adapter.setItems(makeItems())
    }

    private fun deleteCurrent() {
        if (items.size > 0) {
            val position = main_pager.currentItem
            items.removeAt(position)
            adapter.setItems(makeItems())
            if (position > 0) {
                main_pager.setCurrentItem(if (position == items.size) position - 1 else position, false)
            }
        }
    }

    private fun makeItems(): ItemList = ItemList.create()
        .addAll(items, easyController)
}
