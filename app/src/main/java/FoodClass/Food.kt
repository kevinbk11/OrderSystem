package FoodClass

import android.widget.TextView
import org.w3c.dom.Text

open class Food(Name:String,Count:Int) {
    val originName=Name
    var name=Name
    var count=Count
    private fun add(Text:TextView?)
    {
        count++
        name = "${originName}:${count}"
        Text?.text = name
    }
    fun append(BuyList:Array<TextView?>):Boolean
    {
        for (Place in 0..2)
        {
            if (BuyList[Place]!!.text == "${originName}:${count}")
            {
                this.add(BuyList[Place])
                return true
            }
        }
        for (Place in 0..2)
        {
            if (BuyList[Place]!!.text == "None")
            {
                this.add(BuyList[Place])
                return true
            }
        }
        return false
    }
    fun del(BuyList:Array<TextView?>)
    {
        for(place in 0..2)
        {
            if(BuyList[place]!!.text==this.name && BuyList[place]!!.text!=this.count.toString())
            {
                this.count--
                if(this.count==0)
                {
                    BuyList[place]!!.text="None"
                    this.name="${originName}:${count}"
                    break
                }
                this.name="${originName}:${count}"
                BuyList[place]!!.text=this.name
            }
        }
    }
}


