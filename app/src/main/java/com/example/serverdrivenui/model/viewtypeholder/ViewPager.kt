package com.example.serverdrivenui.model.viewtypeholder

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType

data class ViewPager(
    val items: List<ListItem>
) : ListItem {
    override val viewType: ViewType
        get() = ViewType.VIEW_PAGER
}