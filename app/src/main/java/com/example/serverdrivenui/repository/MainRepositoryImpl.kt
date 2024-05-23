package com.example.serverdrivenui.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.serverdrivenui.databinding.model.ListItem
import com.example.serverdrivenui.remote.MainPagingSource
import com.example.serverdrivenui.remote.MainService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 첫 호출 시 pageSize 의 세 배 호출
 */
class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : MainRepository {

    override fun loadList(): Flow<PagingData<ListItem>> = Pager(config = PagingConfig(
        pageSize = 20, enablePlaceholders = false
    ), pagingSourceFactory = {
        MainPagingSource(mainService)
    }).flow
}