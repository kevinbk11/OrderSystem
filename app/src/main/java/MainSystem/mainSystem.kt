package MainSystem

import FoodClass.Food
import FoodClass.Foodarr
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.text.DecimalFormat

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
interface WaitReturn
{

    fun waitReturn(e:String?,app: Context?,toast: Toast?)
    {
        Thread {
            var ThisClient = Socket(ip, 5006)
            Log.v("connect", "success")
            val input = ThisClient!!.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val output = ThisClient.getOutputStream()
            var writer = PrintWriter(output, true)
            while (e == null) {
                Log.v("WHY I AM HERE","XD")
                Thread.sleep(1000)
            }
            Log.v("before","writer")
            writer.println(e)
            Log.v("after","writer")
            while (true)
            {
                Log.v("HI",reader.readLine())
                Runnable { toast!!.show() }.run()
            }
        }.start()
    }

}

interface send{
    var NowList:Array<TextView?>
    var ThisTableNumber:String?
    var app: Context?
    fun sendBuyList(view:View)
    {
        val a = app as Context
        Toast.makeText(a,"已送餐",Toast.LENGTH_SHORT).show()
        Thread{

            Log.v("CLICK","TRUE")
            var ThisClient=Socket(ip,5004)
            val input = ThisClient.getInputStream()
            var output=ThisClient.getOutputStream()
            val writer = PrintWriter(output,true)
            writer.println(1)
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
                        food.name=food.originName
                        food.count=0
                        break
                    }
                    Cost=0
                }
                Log.v(FoodText?.text.toString(),"??")
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

            view.post{
                NowList[0]!!.text="None"
                NowList[1]!!.text="None"
                NowList[2]!!.text="None"
                NowList[3]!!.text="None"
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
fun <T> SendTextToActivity(A: T,B: T,C: T,D: T,E:String?,i:Intent)
{
    val bundle = Bundle()
    when(A)
    {
        is TextView->
        {
            val b = B as TextView
            val c = C as TextView
            val d = D as TextView
            bundle.putString("A",A.text.toString())
            bundle.putString("B",b.text.toString())
            bundle.putString("C",C.text.toString())
            bundle.putString("D",D.text.toString())
            bundle.putString("E",E)
        }
        is String->
        {
            val b = B as String
            val c = C as String
            val d = D as String
            bundle.putString("A",A)
            bundle.putString("B",b)
            bundle.putString("C",C)
            bundle.putString("D",D)
            bundle.putString("E",E)
        }
    }
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
fun tran(Number:String):String
{
    val number=Number.toInt()
    var turn = DecimalFormat(",###")
    return turn.format(number).toString()
}
var toast:Toast? = null
var sendToast:Toast? = null
val full="購物車已滿!請刪除其他食物"

val sended="已送達"
val ip="192.168.43.114"


