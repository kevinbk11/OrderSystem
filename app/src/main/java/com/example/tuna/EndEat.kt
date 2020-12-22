package com.example.tuna

import MainSystem.ip
import MainSystem.tran
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_end_eat.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class EndEat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_eat)
        val tableNumber=intent.getStringExtra("tableNumber")
        Thread{
            var ThisClient= Socket(ip,5004)
            val input = ThisClient!!.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val output = ThisClient.getOutputStream()
            var writer = PrintWriter(output, true)
            writer.println(2)
            writer.println(tableNumber)
            reader.readLine()
            val Money=reader.readLine()
            runOnUiThread {
                val money=tran(Money)
                wait.text="感謝您的消費,該次用餐共消費了${money}元"
            }
            var message=reader.readLine()
            if(message!="N")
            {
                runOnUiThread{
                    payoff.text=message
                }
            }
            var back =Socket(ip,5008)
            val i=back.getInputStream()
            val r=BufferedReader(InputStreamReader(i))
            val o=back.getOutputStream()
            val w=PrintWriter(o,true)
            while(r.readLine()!=tableNumber)
            {
                var back =Socket(ip,5008)
                val i=back.getInputStream()
                val r=BufferedReader(InputStreamReader(i))
                val o=back.getOutputStream()
                val w=PrintWriter(o,true)
                w.println(true)
            }
            w.println(false)
            var intent= Intent(this,MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("E",(tableNumber.toInt()).toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }.start()
    }

    override fun onBackPressed() {
        val t= Toast.makeText(applicationContext,"請至櫃台結帳",Toast.LENGTH_LONG).show()
    }
}