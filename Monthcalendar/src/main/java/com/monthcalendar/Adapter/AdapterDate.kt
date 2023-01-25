package com.monthcalendar.Adapter
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.monthcalendar.Model.ModelDate
import com.monthcalendar.R
import com.monthcalendar.databinding.ItemDateBinding

class AdapterDate(private val context: Context, resultBeanList: List<ModelDate.ResultBean>,
                   callback: OnItemDateClickCallback) :
    RecyclerView.Adapter<AdapterDate.ViewHolder?>() {
    private var resultBeans: List<ModelDate.ResultBean> = ArrayList()
    private val callback: OnItemDateClickCallback
    init {
        resultBeans = resultBeanList
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val childViewBinding: ItemDateBinding = ItemDateBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(childViewBinding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemChildBinding.tvDate.text =  resultBeans[position].date
        holder.itemChildBinding.tvday.text =  resultBeans[position].day
        if (resultBeans[position].isChecked) {
            callback.clickDate(resultBeans[position].dateformat)
            holder.itemChildBinding.tvDate.setTextColor(context.getColor(R.color.white))
            holder.itemChildBinding.tvday.setTextColor(context.getColor(R.color.white))
            holder.itemChildBinding.llDate.background = context.resources.getDrawable(R.drawable.bg_red)
        }else{
            holder.itemChildBinding.tvDate.setTextColor(context.getColor(R.color.black))
            holder.itemChildBinding.tvday.setTextColor(context.getColor(R.color.black))
            holder.itemChildBinding.llDate.background = context.resources.getDrawable(R.drawable.bg_gray)
        }
        holder.itemChildBinding.root.setOnClickListener { v ->
            if (!resultBeans[position].isChecked) {
                for (i in resultBeans.indices) {
                    resultBeans[i].isChecked = false
                }
                resultBeans[position].isChecked =true
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return if (resultBeans.isNotEmpty()) {
            resultBeans.size
        }else{
            0
        }
    }

    class ViewHolder(itemView: ItemDateBinding) : RecyclerView.ViewHolder(itemView.root) {
        val itemChildBinding: ItemDateBinding
        init {
            itemChildBinding = itemView
        }
    }

    interface OnItemDateClickCallback {
        fun clickDate(date: String?)
    }
}