package com.example.serverdrivenui.viewholder.category

import com.example.serverdrivenui.adapter.ListAdapter
import com.example.serverdrivenui.databinding.ItemViewpagerBinding
import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.category.ViewPager
import com.example.serverdrivenui.viewholder.BindingViewHolder

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
) : BindingViewHolder<ItemViewpagerBinding>(binding){

    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}