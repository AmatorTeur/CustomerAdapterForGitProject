package com.example.myapplication.diagram

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.main.MainActivity

class DiagramPresenter: BasePresenter<DiagramView> (){
    fun backMainActivity(){
        MainActivity.createLauncher().launch()
        exit()
    }

}