package com.example.myapplication.main

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.diagram.DiagramActivity

class MainPresenter : BasePresenter<MainView>(){
    fun nextDiagramActivity(){
        messageComingSoon()
        DiagramActivity.createLauncher().launch()
        exit()
    }
}