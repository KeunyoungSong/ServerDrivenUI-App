package com.example.serverdrivenui.remote

import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.databinding.model.ViewType
import com.example.serverdrivenui.databinding.model.category.Empty
import com.example.serverdrivenui.databinding.model.category.FullAd
import com.example.serverdrivenui.databinding.model.category.Horizontal
import com.example.serverdrivenui.databinding.model.category.ViewPager
import com.example.serverdrivenui.databinding.model.item.Coupon
import com.example.serverdrivenui.databinding.model.item.Image
import com.example.serverdrivenui.databinding.model.item.Sale
import com.example.serverdrivenui.databinding.model.item.SellItem
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.Exception
import java.lang.reflect.Type

class ListItemDeserializer : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {
        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        // 내부 필드 변환을 위한
        val gson = GsonBuilder()
            .registerTypeAdapter(ListItem::class.java, ListItemDeserializer()).create()

        return try {
            return when (viewTypeName) {
                ViewType.VIEW_PAGER.name -> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> gson.fromJson(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> gson.fromJson(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)

                else -> gson.fromJson(json, Empty::class.java)
            }
        } catch (e: Exception) {
            gson.fromJson(json, Empty::class.java)
        }
    }
}