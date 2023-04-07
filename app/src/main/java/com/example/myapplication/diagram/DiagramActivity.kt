package com.example.myapplication.diagram

import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.github.mikephil.charting.charts.BarChart
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter

class DiagramActivity: BaseActivity (R.layout.diagram_activity), DiagramView{
    override val presenter: DiagramPresenter by providePresenter()

    companion object{
        fun createLauncher()=createActivityLauncher()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diagram_activity)
        val buttonDiagram : Button by bind(R.id.bar_chart_grafik)
        val barChart = findViewById<BarChart>(R.id.bar_chart_grafik)

        buttonDiagram.setOnClickListener {

        }

    }
}