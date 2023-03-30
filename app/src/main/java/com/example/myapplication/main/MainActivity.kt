package com.example.myapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.omegar.mvp.ktx.providePresenter

class MainActivity : BaseActivity(R.layout.activity_main), MainView {
    override val presenter: MainPresenter by providePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}