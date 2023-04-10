package com.example.myapplication.diagram

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter

class DiagramActivity: BaseActivity (R.layout.diagram_activity), DiagramView,
    OnChartValueSelectedListener {
    override val presenter: DiagramPresenter by providePresenter()

    companion object {
        fun createLauncher() = createActivityLauncher()
    }

    private val barChart: BarChart by bind(R.id.bar_chart_grafik) {
        setOnChartValueSelectedListener(this@DiagramActivity)

        //....//


//        xAxis.valueFormatter = xFormatter
//        axisLeft.valueFormatter = yFormatter
        invalidate()
    }
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diagram_activity)

        val buttonDiagram: Button by bind(R.id.bar_chart_grafik)
        val barChart = findViewById<BarChart>(R.id.bar_chart_grafik)
        getBarChartData()
        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")
        barData = BarData(barDataSet)


        buttonDiagram.setOnClickListener {

        }
        barChart!!.data = barData
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.color = resources.getColor(R.color.purple_200)
        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false
    }

    private fun getBarChartData() {
//        list.forEach { star ->
//            barEntriesList.add(BarEntry(5 , star.date)
//        }
        barEntriesList = ArrayList()
        barEntriesList.add(BarEntry(1f, 1f))
        barEntriesList.add(BarEntry(2f, 2f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 4f))
        barEntriesList.add(BarEntry(5f, 5f))
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }
}