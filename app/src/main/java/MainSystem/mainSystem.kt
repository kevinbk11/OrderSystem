package MainSystem

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*

fun CheckNull(A:TextView,B:TextView,C:TextView,a:String?,b:String?,c:String?)
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
}
fun SendTextToActivity(A: TextView,B: TextView,C: TextView,i:Intent)
{
    val bundle = Bundle()
    bundle.putString("A",A.text.toString())
    bundle.putString("B",B.text.toString())
    bundle.putString("C",C.text.toString())
    i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    i.putExtras(bundle)
}