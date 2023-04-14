package com.example.myapplication.diagram

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.main.MainActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.google.android.material.appbar.MaterialToolbar
import com.omega_r.libs.extensions.date.getDateDayOfMonth
import com.omega_r.libs.extensions.date.getDateMonth
import com.omega_r.libs.extensions.date.getDateYear
import com.omegar.libs.omegalaunchers.createActivityLauncher
import com.omegar.mvp.ktx.providePresenter
import java.util.*
import kotlin.collections.ArrayList

class DiagramActivity: BaseActivity (R.layout.diagram_activity), DiagramView,
    OnChartValueSelectedListener {
    override val presenter: DiagramPresenter by providePresenter()

    companion object {
        fun createLauncher() = createActivityLauncher()
    }

    private var barEntriesList = mutableListOf<BarEntry>()
    private var dateYear = Date().getDateYear()
    private var dateMonth = Date().getDateMonth()
    private var dateDay = Date().getDateDayOfMonth()

    private val textDate: TextView by bind(R.id.textView)
    private val backDate: ImageButton by bind(R.id.back_date)
    private val nextDate: ImageButton by bind(R.id.next_date)

    private val rangeYear: Button by bind(R.id.btn_year)
    private val rangeMonth: Button by bind(R.id.btn_month)
    private val rangeDay: Button by bind(R.id.btn_day)
//    private val date
    private val toolbar: MaterialToolbar by bind(R.id.material_tool_bar)

    private val barChart: BarChart by bind(R.id.bar_chart_grafik) {
        setOnChartValueSelectedListener(this@DiagramActivity)
        val barDataSet = BarDataSet(barEntriesList, "")
        val barData = BarData(barDataSet)

        barChart.data = barData
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.color = resources.getColor(R.color.purple_200)
        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false



//        xAxis.valueFormatter = xFormatter
//        axisLeft.valueFormatter = yFormatter
        invalidate()
    }

    fun getBarChartData() {
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

    enum class Direction() {
        WEEK, MONTH, YEAR
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.setNavigationOnClickListener {
            presenter.backMainActivity()
        }

        textDate.text = "$dateDay $dateMonth $dateYear"

        backDate.setOnClickListener {
            dateYear -= 1
            dateMonth -= 1
            textDate.text = "$dateDay $dateMonth $dateYear"
        }

        nextDate.setOnClickListener {
            dateYear += 1
            dateMonth += 1
            textDate.text = "$dateDay $dateMonth $dateYear"
        }

        rangeYear.setOnClickListener {

        }

        rangeMonth.setOnClickListener {

        }

        rangeDay.setOnClickListener {

        }

    }


    override fun onValueSelected(e: Entry?, h: Highlight?) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected() {
        TODO("Not yet implemented")
    }

}