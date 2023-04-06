package com.example.myapplication.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomerAdapter
import com.example.myapplication.R
import com.example.myapplication.Repo
import com.example.myapplication.base.BaseActivity
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : BaseActivity(R.layout.activity_main), MainView,
    CustomerAdapter.OnItemClickListener {
    override val presenter: MainPresenter by providePresenter()

    companion object{
        fun createLauncher() = createActivityLauncher()
    }

    val btnSearch = findViewById<Button>(R.id.btn_search)
    val editTextTextPersonName = findViewById<EditText>(R.id.editTextPersonName)!!
    val repos = service.listRepos(editTextTextPersonName.text.toString())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this)


        btnSearch!!.setOnClickListener {
            repos.enqueue(object : Callback<List<Repo>>  {
                    override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                        val adapter = CustomerAdapter(response.body()!!, {CustomerAdapter.OnItemClickListener})
                        recyclerView.adapter = adapter
                    }

                    override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

                    }
            })
        }
    }

    override fun onItemClicked(repo: Repo) {
        presenter.nextDiagramActivity()
    }
}

//        }
//                val repos = service.listRepos(editTextTextPersonName.text.toString())
//        CustomerAdapter(repos, this)
//
//        recyclerView.adapter = CustomerAdapter(repos, this)
//        repos.enqueue(object : Callback<List<Repo>> {
//            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
//                val adapter = CustomerAdapter(repos = repos, this@MainActivity)
//                recyclerView.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
//
//            }
//        })
//    }
//    interface OnItemClickListener {
//        fun onItemClick(repo: Repo) : RecyclerView.OnItemTouchListener
//    }


////https://guides.codepath.com/android/using-the-recyclerview
////https://developer.alexanderklimov.ru/android/views/recyclerview-kot.php

//class MainActivity : BaseActivity(R.layout.activity_main), MainView, OnItemClickListener,
//    OnPageRequestListener {
//
//    override val presenter: MainPresenter by providePresenter()
//
//    companion object {
//        fun createLauncher() = createActivityLauncher()
//    }
//
//    private lateinit var adapter: CustomerAdapter
//    private val editTextTextPersonName: EditText by bind(R.id.editTextPersonName)
//    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//    override var repoList: List<Repo> = mutableListOf()
//        set(value) {
//
//            field = value
//            adapter.repos = value
//
//        }
//
//    override fun onItemClicked(repo: Repo) {
//        presenter.nextDiagramActivity()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setClickListener(R.id.btn_search) {
//            onPageRequest(1)
//            Log.d("onClickSeatch", "search click")
//
//        }
//
//        val repos = service.listRepos(editTextTextPersonName.text.toString())
//        CustomerAdapter(repos, this)
//        repos.enqueue(object : Call<List<Repo>> {
//            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
//                val adapter = CustomerAdapter(repos = repos, this@MainActivity)
//                recyclerView?.adapter = adapter
//            }
//        })
//
////                adapter = CustomerAdapter (repoList, this)
////        recyclerView?.adapter = adapter
//
//    }
//
//    override fun onPageRequest(page: Int) {
//        presenter.request(editTextTextPersonName.toString())
//    }
//
//    override fun getPagePreventionForEnd(): Int {
//        return 5
//    }
//
//}