package deleteInterface

import FoodClass.Food
import FoodClass.Foodarr
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

interface deleteListItem {
    fun delete(textView: TextView?,foodArr:Map<String,Food>)
    {
        for((Number,food) in foodArr)
        {
            if(food.name==textView!!.text)
            {
                food.Del(textView)
            }
        }
    }
    fun find(arr:Array<TextView?>,food: Food):Int
    {
        for(y in arr)
        {
            if(y!!.text==food.name)
            {
                return arr.indexOf(y)
            }
        }
        return -1
    }
}


