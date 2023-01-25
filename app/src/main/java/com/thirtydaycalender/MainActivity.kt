package com.thirtydaycalender

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monthcalendar.Adapter.AdapterDate
import com.monthcalendar.Model.ModelDate
import com.monthcalendar.Utils.DateFormatter
import com.thirtydaycalender.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() ,AdapterDate.OnItemDateClickCallback{
    private lateinit var resultBeanList: ArrayList<ModelDate.ResultBean>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        resultBeanList = ArrayList()
        resultBeanList = DateFormatter.horizontalCalender(30)

        val manager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapterDate = AdapterDate(this, resultBeanList, this)
        binding.recyclerView.adapter = adapterDate
        binding.recyclerView.layoutManager = manager
    }
    override fun clickDate(date: String?) {
        binding.selectedDate.text = date
    }
}