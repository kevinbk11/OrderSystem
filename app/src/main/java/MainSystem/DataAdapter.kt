package MainSystem

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuna.R

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val nameView: TextView = v.findViewById(R.id.item_text)
    val countView:TextView=v.findViewById(R.id.info_count)
    val priceView:TextView=v.findViewById(R.id.info_money)
    val foodNumberView:TextView=v.findViewById(R.id.info_number)
}

class DataAdapter(private val mData: List<FoodListItem>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.v("TESTTT",mData[position].Name)
        if("Y" in mData[position].Name)
        {
            holder.nameView.paintFlags=(holder.nameView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
            mData[position].Name=mData[position].Name.replace("Y","")
        }
        else
        {
            mData[position].Name=mData[position].Name.replace("N","")
            holder.nameView.paintFlags=(holder.nameView.paintFlags or Paint.START_HYPHEN_EDIT_NO_EDIT)
        }
        holder.nameView.text = mData[position].Name
        holder.countView.text =mData[position].Count.toString()
        holder.priceView.text=mData[position].Price.toString()
        holder.foodNumberView.text=mData[position].Number.toString()
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}