package com.example.myapplication.main

import android.annotation.SuppressLint
import com.example.myapplication.CustomAdapter
import com.example.myapplication.Repo
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.base.BasePresenter
import com.example.myapplication.diagram.DiagramActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter : BasePresenter<MainView>(){

    fun nextDiagramActivity(){
        DiagramActivity.createLauncher().launch()
        exit()
    }
    fun request(reposName: String, click: CustomAdapter.OnItemClickListener, pageNumber: Int) {
        val repos = BaseActivity.service.listRepos(reposName, 1, 100)
        repos.enqueue(object : Callback<List<Repo>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                val adapter = CustomAdapter(response.body()!!, click)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}