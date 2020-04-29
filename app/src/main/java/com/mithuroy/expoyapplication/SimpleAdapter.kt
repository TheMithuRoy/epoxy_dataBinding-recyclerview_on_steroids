package com.mithuroy.expoyapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_content.view.*
import kotlinx.android.synthetic.main.adapter_footer.view.*
import kotlinx.android.synthetic.main.adapter_header.view.*

class SimpleAdapter(
        private val simpleList: List<SimpleModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_TYPE_HEADER = 0
        private const val ITEM_TYPE_CONTENT = 1
        private const val ITEM_TYPE_FOOTER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_header, parent, false))
        1 -> ContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_content, parent, false))
        else -> FooterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_footer, parent, false))
    }

    override fun getItemCount() = simpleList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder ->
                "Pos:$position ${simpleList[position].content}".let(holder.itemView.tvHeaderDynamic::setText)

            is ContentViewHolder ->
                "#$position ${simpleList[position].content}".let(holder.itemView.tvContentDynamic::setText)

            is FooterViewHolder ->
                "$position${simpleList[position].content}".let(holder.itemView.tvFooterDynamic::setText)
        }
    }

    override fun getItemViewType(position: Int) = when (simpleList[position].type) {
        "Header" -> ITEM_TYPE_HEADER
        "Content" -> ITEM_TYPE_CONTENT
        else -> ITEM_TYPE_FOOTER
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view)

}