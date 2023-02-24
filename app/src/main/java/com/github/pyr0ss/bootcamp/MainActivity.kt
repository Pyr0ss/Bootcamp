package com.github.pyr0ss.bootcamp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.mainName)
        val button: Button = findViewById(R.id.mainGoButton)
        button.setOnClickListener {
            val i = Intent(this, GreetingActivity::class.java)
            i.putExtra("mainName", textView.text)
            startActivity(i)
        }
    }
}