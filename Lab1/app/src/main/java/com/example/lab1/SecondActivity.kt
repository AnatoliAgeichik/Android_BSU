package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text=intent.getIntExtra(EXTRA_KEY,0)
        val textView=findViewById<TextView>(R.id.numb)
        textView.text=text.toString()

        val enterBtn=findViewById<Button>(R.id.btnOk).setOnClickListener {
            val textNumb=findViewById<EditText>(R.id.enterNumb1)
            val numb=textNumb.text.toString().toInt()
            NUMB=text+numb
            val intent= Intent(this, MainActivity::class.java)

            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}