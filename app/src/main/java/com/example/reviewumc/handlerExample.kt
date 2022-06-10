package com.example.reviewumc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class HandlerExample : AppCompatActivity() {

    lateinit var mHandlerThread : Handler
    lateinit var mThread : Thread
    lateinit var progressBar : ProgressBar
    lateinit var startBtn : Button
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        startBtn = findViewById<Button>(R.id.start_progress)
        textView = findViewById<TextView>(R.id.textView)
        progressBar.max = 100

        mThread = Thread(Runnable {
            for(i in 0 .. 100){
                Log.d("I", "${i}")
                progressBar.progress = i
                try{
                    Thread.sleep(100)
                } catch (ex : InterruptedException){
                    ex.printStackTrace()
                }

                val message = Message()
                message.what = COUNT //what : 메시지 종류 식별을 위한 사용자 정의 메시지 코드
                message.arg1 = i //arg1 : 메시지를 통해 전달되는 정수 값 저장
                mHandlerThread.sendMessage(message) //Message 객체 전달. 메시지 큐의 가장 마지막에 msg 추가.

            }
        })
        startBtn.setOnClickListener {
            if(!mThread.isAlive){
                val currentProcess = progressBar.progress
                mHandlerThread.sendEmptyMessage(START) //Message 클래스 변수 중 what 멤버만 채워진 Message 객체 전달
            }
        }


    }

    override fun onResume() {
        super.onResume()
        mHandlerThread = @SuppressLint("HandlerLeak")
        object : Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if(msg.what === START){
                    mThread.start()
                } else if(msg.what === COUNT){
                    textView.text = "Count" + msg.arg1
                }
            }
        }
    }

    companion object{
        private const val START = 100
        private const val COUNT = 101
    }
}