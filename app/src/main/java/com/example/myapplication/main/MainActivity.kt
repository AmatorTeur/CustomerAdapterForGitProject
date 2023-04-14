package com.example.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomAdapter
import com.example.myapplication.R
import com.example.myapplication.Repo
import com.example.myapplication.base.BaseActivity
import com.omega_r.libs.omegarecyclerview.pagination.OnPageRequestListener
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : BaseActivity(R.layout.activity_main), MainView, CustomAdapter.OnItemClickListener, OnPageRequestListener {
    companion object {
        fun createLauncher() = createActivityLauncher()
    }
    override val presenter: MainPresenter by providePresenter()


    private val recyclerView : RecyclerView by bind(R.id.recycler_view) {
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
    }
    private val editTextTextPersonName:EditText by bind(R.id.editTextPersonName)
    private val btnSearch: Button by bind(R.id.btn_search)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val isLoadingRepos = false
//        fun addScrollListener() {
//            recyclerView.addOnScrollListener(object :
//                PaginationScrollListener(recyclerView.layoutManager as LinearLayoutManager) {
//                override fun loadMoreItems() {
//                    presenter
//                }
//
//                override fun isLastPage() = presenter.isAllEmailLoaded
//
//                override fun isLoading() = isLoadingRepos
//            })
//        }


        btnSearch.setOnClickListener {
            presenter.request(editTextTextPersonName.toString(), this@MainActivity, 1)
        }
    }

    override fun onItemClick(view: View, position: Int) {
        presenter.nextDiagramActivity()
    }

    override fun onPageRequest(page: Int) {
        presenter.request(editTextTextPersonName.toString(), this@MainActivity, page)

    }

    override fun getPagePreventionForEnd(): Int {
        return 5
    }


}
