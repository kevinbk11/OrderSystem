package com.example.tuna

import FoodClass.Food1Page.Food1
import FoodClass.Food1Page.Food2
import FoodClass.Food1Page.Food3
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_test.*
import deleteInterface.deleteListItem
class Test : AppCompatActivity(),deleteListItem{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val bundle = intent.extras
        var S=bundle?.getString("num")
        A.text=S
    }
    var foodArr= arrayOf(Food1, Food2, Food3)
    fun make1(view: View)
    {
        var arr = arrayOf(A,B,C)
        if(!foodArr[0].append(arr))
        {
            Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物", Toast.LENGTH_LONG)
        }

    }
    fun make2(view: View)
    {
        var arr = arrayOf(A,B,C)
        if(!foodArr[1].append(arr))
        {
            Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物", Toast.LENGTH_LONG)
        }
    }
    fun make3(view: View)
    {
        var arr = arrayOf(A,B,C)
        if(!foodArr[2].append(arr))
        {
            Toast.makeText(applicationContext,"購物車已滿!請刪除其他食物", Toast.LENGTH_LONG)
        }
    }
    fun D1(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[0])

    }
    fun D2(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[1])
    }
    fun D3(view: View)
    {
        var arr = arrayOf(A,B,C)
        delete(arr[2])
    }
}
