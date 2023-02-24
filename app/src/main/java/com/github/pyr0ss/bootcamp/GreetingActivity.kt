package com.github.pyr0ss.bootcamp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val textView: TextView = findViewById(R.id.greetingMessage)
        textView.text = getString(R.string.greeting_message, intent.getCharSequenceExtra("mainName"))
    }
}