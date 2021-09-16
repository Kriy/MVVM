package com.win.lib_base.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class AbsListViewModel<T> : ViewModel() {

    private var dataSource: DataSource<Int, T>? = null
    private var pageData: LiveData<PagedList<T>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .build()

        val factory = object : DataSource.Factory<Int, T>() {
            override fun create(): DataSource<Int, T> {
                if (dataSource == null || dataSource?.isInvalid != false) {
                    dataSource = createDataSource()
                }
                return dataSource!!
            }
        }
        pageData = LivePagedListBuilder<Int, T>(factory, config).build()
    }

    fun getPageData(): LiveData<PagedList<T>> {
        return pageData
    }

    fun getDataSource(): DataSource<Int, T>? {
        return dataSource
    }

    abstract fun createDataSource(): DataSource<Int, T>
}