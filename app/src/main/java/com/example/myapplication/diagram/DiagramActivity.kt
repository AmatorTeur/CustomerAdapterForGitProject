package com.example.myapplication.diagram

import com.example.myapplication.R
import com.example.myapplication.Repo
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.main.MainView
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter

class DiagramActivity: BaseActivity (R.layout.diagram), DiagramView{
    override val presenter: DiagramPresenter by providePresenter()

    companion object{
        fun createLauncher()=createActivityLauncher()
    }

}