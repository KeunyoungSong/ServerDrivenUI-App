package com.example.serverdrivenui.viewholder

import com.example.serverdrivenui.adapter.ListAdapter
import com.example.serverdrivenui.databinding.ItemHorizontalBinding
import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.viewtypeholder.Horizontal

class HorizontalViewHolder(
    private val binding:ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }
}