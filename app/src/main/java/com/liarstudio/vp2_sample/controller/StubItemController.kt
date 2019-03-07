package com.liarstudio.vp2_sample.controller

import android.view.ViewGroup
import com.liarstudio.vp2_sample.R
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

class StubItemController : NoDataItemController<StubItemController.Holder>() {

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BaseViewHolder(parent, R.layout.layout_stub)
}