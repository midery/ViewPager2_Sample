package com.liarstudio.vp2_sample.controller

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.liarstudio.vp2_sample.R
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class PositionController : BindableItemController<Int, PositionController.Holder>() {
    override fun getItemId(position: Int) = position.toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Int>(parent, R.layout.layout_position) {

        override fun bind(position: Int) {
            val title = "Element $position"
            (itemView as TextView).text = title
            val bgColorRes = if (adapterPosition % 2 == 0) R.color.colorAccent else R.color.colorPrimary
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, bgColorRes))
        }
    }
}