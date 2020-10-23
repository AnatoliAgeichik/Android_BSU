package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

val EXTRA_KEY_RETURN="returnRes"

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text= intent.getIntExtra(EXTRA_KEY,0)
        numb.text=text.toString()

        val enterBtn=findViewById<Button>(R.id.btnOk).setOnClickListener {
            val textNumb=findViewById<EditText>(R.id.enterNumb1)
            val numb=textNumb.text.toString().toInt()
            val intent= Intent().apply {
                putExtra(EXTRA_KEY_RETURN,text+numb)
            }

            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}