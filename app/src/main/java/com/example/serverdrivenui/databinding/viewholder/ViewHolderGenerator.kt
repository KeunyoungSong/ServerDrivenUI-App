package com.example.serverdrivenui.databinding.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.serverdrivenui.databinding.ItemEmptyBinding
import com.example.serverdrivenui.model.ViewType
import com.example.serverdrivenui.databinding.viewholder.category.FullAdViewHolder
import com.example.serverdrivenui.databinding.viewholder.category.HorizontalViewHolder
import com.example.serverdrivenui.databinding.viewholder.category.ViewPagerViewHolder
import com.example.serverdrivenui.databinding.viewholder.item.CouponViewHolder
import com.example.serverdrivenui.databinding.viewholder.item.ImageViewHolder
import com.example.serverdrivenui.databinding.viewholder.item.SaleViewHolder
import com.example.serverdrivenui.databinding.viewholder.item.SellItemViewHolder

object ViewHolderGenerator {

    /**
     * 뷰 타입에 따라 적절한 뷰 홀더를 반환하는 get 메서드
     * 새로운 뷰타입 사용시 뷰 타입 추가 필요
     */
    fun get(
        parent: ViewGroup, viewType: Int
    ): BindingViewHolder<*> {
        return when (viewType) {
            // 카테고리 뷰타입
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalViewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal -> FullAdViewHolder(parent.toBinding())
            // 아이템 뷰타입
            ViewType.COUPON.ordinal -> CouponViewHolder(parent.toBinding())
            ViewType.IMAGE.ordinal -> ImageViewHolder(parent.toBinding())
            ViewType.SELL_ITEM.ordinal -> SellItemViewHolder(parent.toBinding())
            ViewType.SALE.ordinal -> SaleViewHolder(parent.toBinding())
            // 미지원 타입
            else -> ItemViewHolder(parent.toBinding())
        }
    }

    class ItemViewHolder(binding: ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    /**
     * 이 함수는 제네릭 리플렉션을 사용하여 ViewBinding 객체를 생성합니다.
     * ViewGroup 객체에서 호출되며,LayoutInflater와 함께 사용하여 뷰 바인딩 객체를 동적으로 생성합니다.
     * 이는 다양한 뷰 바인딩 클래스를 유연하게 처리할 수 있도록 합니다.
     */
    private inline fun <reified V : ViewBinding> ViewGroup.toBinding(): V {
        return V::class.java.getMethod(
            "inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java
        ).invoke(null, LayoutInflater.from(context), this, false) as V
    }
}