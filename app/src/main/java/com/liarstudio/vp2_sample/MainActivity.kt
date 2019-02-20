package com.liarstudio.vp2_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: VP2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = VP2Adapter(supportFragmentManager) { counter_tv.text = "Fragments count: $it" }
            .apply { count = 10 }

        main_pager.adapter = adapter

        add_btn.setOnClickListener {
            adapter.count++
        }

        delete_btn.setOnClickListener {
            adapter.count--
        }
    }
}
