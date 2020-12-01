package FoodClass

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
    fun append(BuyList:Array<TextView?>,toast: Toast):Boolean
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
        toast.show()
        return false
    }
    fun del(BuyList:Array<TextView?>):Boolean
    {
        var place = find(BuyList, this)
        if (place != -1)
        {
            this.count--
            if (this.count == 0)
            {
                BuyList[place]!!.text = "None"
                this.name = "${originName}"
                return true
            }
            this.name = "${originName}:${count}"
            BuyList[place]!!.text = this.name
            return true
        }
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


