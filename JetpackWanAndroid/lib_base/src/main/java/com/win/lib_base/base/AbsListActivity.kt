package com.win.lib_base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lib_base.databinding.AbsListLayoutBinding
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.win.lib_base.utils.StatusBarKt

abstract class AbsListActivity<T, V: AbsListViewModel<T>> :AppCompatActivity(),OnLoadMoreListener,
    OnRefreshListener {

        lateinit var mAdapter: PagedListAdapter<T, RecyclerView.ViewHolder>
        lateinit var mViewModel: V

        private lateinit var mRefreshLayout: SmartRefreshLayout
        private lateinit var mRecycleView:RecyclerView

        lateinit var mBinding: AbsListLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarKt.fitSystemBar(this)
    }

}