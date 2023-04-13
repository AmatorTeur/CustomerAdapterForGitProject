package com.example.myapplication.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomAdapter
import com.example.myapplication.PaginationScrollListener
import com.example.myapplication.R
import com.example.myapplication.Repo
import com.example.myapplication.base.BaseActivity
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : BaseActivity(R.layout.activity_main), MainView, CustomAdapter.OnItemClickListener {
    companion object {
        fun createLauncher() = createActivityLauncher()
    }
    override val presenter: MainPresenter by providePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        private fun addScrollListener() {
            recyclerView.addOnScrollListener(object :
                PaginationScrollListener(recyclerView.layoutManager as LinearLayoutManager) {
                override fun loadMoreItems() {
                    viewModel.fetchEmails()
                }

                override fun isLastPage() = viewModel.isAllEmailLoaded

                override fun isLoading() = isLoadingEmails
            })
        }

        val btnSearch = findViewById<Button>(R.id.btn_search)
        btnSearch!!.setOnClickListener {
            val editTextTextPersonName = findViewById<EditText>(R.id.editTextPersonName)!!
            val repos = service.listRepos(editTextTextPersonName.text.toString())
            repos.enqueue(object : Callback<List<Repo>> {
                override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                    val adapter = CustomAdapter(response.body()!!, this@MainActivity)
                    recyclerView.adapter = adapter
                }

                override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

                }
            })
        }
    }

    override fun onItemClick(view: View, position: Int) {
        presenter.nextDiagramActivity()
    }


}
