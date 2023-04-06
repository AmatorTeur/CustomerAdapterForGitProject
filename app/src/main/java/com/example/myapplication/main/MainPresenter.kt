package com.example.myapplication.main

import android.util.Log
import com.example.myapplication.base.BaseActivity.Companion.service
import com.example.myapplication.base.BasePresenter
import com.example.myapplication.diagram.DiagramActivity
import kotlinx.coroutines.launch

class MainPresenter : BasePresenter<MainView>(){

//    fun request(name: String) {
//        launch {
//            val repoList = service.listRepos(name)
//            viewState.repoList = repoList
//
//            Log.d("repoList", repoList.toString())
//        }
//
//    }

    fun nextDiagramActivity(){
        showComingSoon()
        DiagramActivity.createLauncher().launch()
        exit()
    }

}