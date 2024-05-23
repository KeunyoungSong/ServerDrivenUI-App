package com.example.serverdrivenui.repository

import androidx.paging.PagingData
import com.example.serverdrivenui.databinding.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}