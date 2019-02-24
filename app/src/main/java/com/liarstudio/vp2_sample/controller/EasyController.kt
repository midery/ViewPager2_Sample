package com.liarstudio.vp2_sample.controller

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.liarstudio.vp2_sample.R
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class EasyController : BindableItemController<Int, EasyController.Holder>() {
    override fun getItemId(position: Int) = position.toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Int>(parent, R.layout.layout_vp2) {

        override fun bind(position: Int) {
            (itemView as TextView).text = "View $position"
            val color = ContextCompat.getColor(
                itemView.context,
                if (adapterPosition % 2 == 0) R.color.colorAccent else R.color.colorPrimary
            )
            itemView.setBackgroundColor(color)
        }
    }
}