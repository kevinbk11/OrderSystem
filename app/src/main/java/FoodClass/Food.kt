package FoodClass

import FoodClass.Noodles.*
import FoodClass.Rice.*
import FoodClass.Soup.*
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
open class Food(Name:String):deleteInterface.deleteListItem {
    val originName=Name
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
)

