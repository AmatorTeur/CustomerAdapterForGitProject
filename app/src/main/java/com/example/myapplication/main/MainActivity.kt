package com.example.myapplication.main

import android.os.Bundle
import android.view.View
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

    companion object {
        fun createLauncher() = createActivityLauncher()
    }
    var listRepo: List<Repo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTextPersonName = findViewById<EditText>(R.id.editTextPersonName)!!
        val repos = service.listRepos(editTextTextPersonName.text.toString())
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        val btnSearch = findViewById<Button>(R.id.btn_search)
        btnSearch!!.setOnClickListener {
            repos.enqueue(object : Callback<List<Repo>> {
                override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
//                    val adapter = CustomerAdapter(response.body()!!, this@MainActivity)
                    listRepo = response?.body()!!
                    recyclerView.adapter = CustomerAdapter(response?.body()!!,this@MainActivity)
                }

                override fun onFailure(call: Call<List<Repo>>?, t: Throwable) {

                }
            })
        }
    }

    override fun onItemClick(view: View, position: Int) {
        presenter.nextDiagramActivity()
    }
}



////https://guides.codepath.com/android/using-the-recyclerview
////https://developer.alexanderklimov.ru/android/views/recyclerview-kot.php
