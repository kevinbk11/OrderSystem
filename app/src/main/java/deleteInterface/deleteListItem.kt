package deleteInterface

import FoodClass.Food
import android.widget.TextView

interface deleteListItem {

    fun delete(textView: TextView?,foodArr:Array<Food>)
    {
        for(food in foodArr)
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