package MainSystem

import FoodClass.Food
import FoodClass.Foodarr
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_noodles_menu.*
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.PrintWriter
import java.net.Socket
import kotlin.concurrent.thread

interface deleteListItem {
    fun delete(textView: TextView?,foodArr:Map<String, Food>)
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
interface send{
    var NowList:Array<TextView?>
    var ThisTableNumber:String?
    fun sendBuyList(view:View)
    {
        Thread{
            Log.v("CLICK","TRUE")
            var ThisClient=Socket("192.168.1.101",5004)
            val input = ThisClient.getInputStream()
            var output=ThisClient.getOutputStream()
            val writer = PrintWriter(output,true)
            writer.println(false)
            writer.println(ThisTableNumber)
            var Cost=0
            for(FoodText in NowList)
            {
                var FoodList = FoodText!!.text.toString().split(":")
                for((number,food) in Foodarr)
                {
                    if(food.name.split(":")[0]==FoodList[0])
                    {
                        Cost=food.price*FoodList[1].toInt()
                        break
                    }
                    Cost=0
                }
                writer.println(FoodText?.text.toString())
                if(Cost==0)
                {
                    writer.println(0)
                }
                else
                {
                    writer.println(Cost)
                }
            }
        }.start()
    }
    fun updata(FoodArray:Array<TextView?>)
    {
        NowList=FoodArray
    }

}
fun CheckNull(A:TextView,B:TextView,C:TextView,D:TextView,a:String?,b:String?,c:String?,d:String?)
{
    if(a==null)
    {
        A.text="None"
    }
    else
    {
        A.text=a
    }
    if(b==null)
    {
        B.text="None"
    }
    else
    {
        B.text=b
    }

    if(c==null)
    {
        C.text="None"
    }
    else
    {
        C.text=c
    }

    if(d==null)
    {
        D.text="None"
    }
    else
    {
        D.text=d
    }
}
fun SendTextToActivity(A: TextView,B: TextView,C: TextView,D: TextView,E:String?,i:Intent)
{
    val bundle = Bundle()
    bundle.putString("A",A.text.toString())
    bundle.putString("B",B.text.toString())
    bundle.putString("C",C.text.toString())
    bundle.putString("D",D.text.toString())
    bundle.putString("E",E)
    i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    i.putExtras(bundle)
}
fun recive(arr:Array<TextView?>,intent:Intent)
{
    arr[0]?.text=intent.getStringExtra("A")
    arr[1]?.text=intent.getStringExtra("B")
    arr[2]?.text=intent.getStringExtra("C")
    arr[3]?.text=intent.getStringExtra("D")
}

var toast:Toast? = null
val full="購物車已滿!請刪除其他食物"
