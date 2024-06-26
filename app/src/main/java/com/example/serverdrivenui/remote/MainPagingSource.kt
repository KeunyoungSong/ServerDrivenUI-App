package com.example.serverdrivenui.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.serverdrivenui.model.ListItem
import java.lang.Exception

class MainPagingSource(private val mainService: MainService) : PagingSource<Int, ListItem>() {
    override fun getRefreshKey(state: PagingState<Int, ListItem>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListItem> {
        return try {
            val page = params.key ?: 1
            val size = params.loadSize
            val result = mainService.getList(page, size).data

            LoadResult.Page(
                data = result.list,
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}