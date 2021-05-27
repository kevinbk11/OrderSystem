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
            var i=back.getInputStream()
            var r=BufferedReader(InputStreamReader(i))
            var o=back.getOutputStream()
            var w=PrintWriter(o,true)

            w.println(tableNumber)
            var success=r.readLine().toBoolean()
            if(success==false)
            {
                Thread.sleep(1000)
                back =Socket(ip,5008)
                i=back.getInputStream()
                r=BufferedReader(InputStreamReader(i))
                o=back.getOutputStream()
                w=PrintWriter(o,true)
                w.println(tableNumber)
                success=r.readLine().toBoolean()
            }
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