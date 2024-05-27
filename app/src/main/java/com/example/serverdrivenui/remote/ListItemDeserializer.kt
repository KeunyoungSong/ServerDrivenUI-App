package com.example.serverdrivenui.remote

import com.example.serverdrivenui.model.ListItem
import com.example.serverdrivenui.model.ViewType
import com.example.serverdrivenui.model.category.Empty
import com.example.serverdrivenui.model.category.FullAd
import com.example.serverdrivenui.model.category.Horizontal
import com.example.serverdrivenui.model.category.ViewPager
import com.example.serverdrivenui.model.item.Coupon
import com.example.serverdrivenui.model.item.Image
import com.example.serverdrivenui.model.item.Sale
import com.example.serverdrivenui.model.item.SellItem
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.Exception
import java.lang.reflect.Type

class ListItemDeserializer : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement, typeOfT: Type, context: JsonDeserializationContext
    ): ListItem {
        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        return try {
            return when (viewTypeName) {
                ViewType.VIEW_PAGER.name -> context.deserialize(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> context.deserialize(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> context.deserialize(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> context.deserialize(json, SellItem::class.java)
                ViewType.IMAGE.name -> context.deserialize(json, Image::class.java)
                ViewType.SALE.name -> context.deserialize(json, Sale::class.java)
                ViewType.COUPON.name -> context.deserialize(json, Coupon::class.java)

                else -> context.deserialize(json, Empty::class.java)
            }
        } catch (e: Exception) {
            context.deserialize(json, Empty::class.java)
        }
    }
}