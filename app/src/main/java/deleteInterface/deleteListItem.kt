package deleteInterface

import FoodClass.Food
import FoodClass.Food1Page.Food1
import FoodClass.Food1Page.Food2
import FoodClass.Food1Page.Food3
import android.widget.TextView

interface deleteListItem {
    fun delete(textView: TextView?)
    {
        var foodArr= arrayOf(Food1, Food2, Food3)
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