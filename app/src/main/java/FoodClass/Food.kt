package FoodClass

import FoodClass.Dessert.*
import FoodClass.Drink.*
import FoodClass.LightFood.*
import FoodClass.Noodles.*
import FoodClass.Rice.*
import FoodClass.Soup.*
import MainSystem.deleteListItem
import MainSystem.send
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
open class Food(Name:String,Price:Int):deleteListItem, send {
    val originName=Name
    val price=Price
    var name=Name
    var count=0
    private fun add(Text:TextView?)
    {
        count++
        name = "${originName}:${count}"
        Text?.text = name
    }
    fun append(BuyList:Array<TextView?>,toast: Toast?):Boolean
    {
        for (Place in 0..3)
        {
            if (BuyList[Place]!!.text == "${originName}:${count}")
            {
                this.add(BuyList[Place])
                updata(BuyList)
                return true
            }
        }
        for (Place in 0..3)
        {
            if (BuyList[Place]!!.text == "None")
            {
                this.add(BuyList[Place])
                return true
            }
        }
        toast?.show()
        return false
    }
    fun Del(textView: TextView?)
    {
        this.count--
        if(this.count==0)
        {
            textView!!.text="None"
            this.name=originName
        }
        else
        {
            this.name="${originName}:${this.count.toString()}"
            textView!!.text=this.name
        }
    }
}

var Foodarr= mapOf<String,Food>(
    "Noodle1" to Noodle_1,
    "Noodle2" to Noodle_2,
    "Noodle3" to Noodle_3,
    "Noodle4" to Noodle_4,
    "Noodle5" to Noodle_5,

    "Rice1" to Rice_1,
    "Rice2" to Rice_2,
    "Rice3" to Rice_3,
    "Rice4" to Rice_4,
    "Rice5" to Rice_5,
    "Rice6" to Rice_6,
    "Rice7" to Rice_7,
    "Rice8" to Rice_8,
    "Rice9" to Rice_9,
    "Rice10" to Rice_10,

    "Soup1" to Soup_1,
    "Soup2" to Soup_2,
    "Soup3" to Soup_3,
    "Soup4" to Soup_4,
    "Soup5" to Soup_5,
    "Soup6" to Soup_6,

    "LightFood1" to LightFood_1,
    "LightFood2" to LightFood_2,
    "LightFood3" to LightFood_3,
    "LightFood4" to LightFood_4,
    "LightFood5" to LightFood_5,
    "LightFood6" to LightFood_6,
    "LightFood7" to LightFood_7,
    "LightFood8" to LightFood_8,

    "Dessert1" to Dessert_1,
    "Dessert2" to Dessert_2,
    "Dessert3" to Dessert_3,
    "Dessert4" to Dessert_4,
    "Dessert5" to Dessert_5,
    "Dessert6" to Dessert_6,
    "Dessert7" to Dessert_7,
    "Dessert8" to Dessert_8,

    "Drink1" to Drink_1,
    "Drink2" to Drink_2,
    "Drink3" to Drink_3,
    "Drink4" to Drink_4,
    "Drink5" to Drink_5,
    "Drink6" to Drink_6,
    "Drink7" to Drink_7,
    "Drink8" to Drink_8,
)

