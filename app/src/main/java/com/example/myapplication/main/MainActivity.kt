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
import retrofit2.Retrofit


class MainActivity : BaseActivity(R.layout.activity_main), MainView {
    override val presenter: MainPresenter by providePresenter()

    companion object{
        fun createLauncher() = createActivityLauncher()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_search = findViewById<Button>(R.id.btn_search)
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view!!.layoutManager = LinearLayoutManager(this)
        btn_search!!.setOnClickListener {
            val editTextTextPersonName = findViewById<EditText>(R.id.editTextPersonName)!!
            val repos = service.listRepos(editTextTextPersonName.text.toString())
            repos.enqueue(object : Callback<List<Repo>> {
                override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                    val adapter = CustomerAdapter(response.body()!!)
                    recycler_view.adapter = adapter
                }

                override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

                }
            })
        }
    }
}
//https://guides.codepath.com/android/using-the-recyclerview
//https://developer.alexanderklimov.ru/android/views/recyclerview-kot.php