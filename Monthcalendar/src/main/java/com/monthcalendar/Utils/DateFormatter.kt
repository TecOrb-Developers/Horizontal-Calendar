package com.monthcalendar.Utils

import com.monthcalendar.Model.ModelDate
import com.monthcalendar.databinding.MonthActivityBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

object DateFormatter {


    fun getDayNumber(date: Date): String =
        SimpleDateFormat("dd", Locale.getDefault()).format(date)

    fun getDay3LettersName(date: Date): String =
        SimpleDateFormat("EE", Locale.getDefault()).format(date)


     fun horizontalCalender(numdate: Int) :ArrayList<ModelDate.ResultBean>{
          lateinit var dateA: ModelDate.ResultBean
          var resultBeanList:ArrayList<ModelDate.ResultBean>  = ArrayList()
          var todayDateStatus = true
          val calendar = Calendar.getInstance()

         for (i in 0..numdate) {
             if (todayDateStatus) {
                 calendar.add(Calendar.DAY_OF_YEAR, 0)
                 todayDateStatus = false
             }else{
                 calendar.add(Calendar.DAY_OF_YEAR, 1)
             }
             dateA = ModelDate.ResultBean()
             dateA.date = getDayNumber(calendar.time)
             dateA.day = getDay3LettersName(calendar.time)
             dateA.dateformat = calendar.time.toString()
             dateA._id = i
             if (i == 0) {
                 dateA.isChecked = true
             }
             resultBeanList.add(dateA)
         }
         return resultBeanList
     }
}