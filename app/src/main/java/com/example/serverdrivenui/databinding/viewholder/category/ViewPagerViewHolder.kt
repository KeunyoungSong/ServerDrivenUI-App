package com.example.serverdrivenui.databinding.viewholder.category

import com.example.serverdrivenui.adapter.ListAdapter
import com.example.serverdrivenui.databinding.ItemViewpagerBinding
import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.category.ViewPager
import com.example.serverdrivenui.databinding.viewholder.BindingViewHolder

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