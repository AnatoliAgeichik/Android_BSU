package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

val EXTRA_KEY:String="KEY"
val REQUEST_CODE:Int=123
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {
            val numb = numb.text.toString().toInt() + enterNumb1.text.toString().toInt()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, numb)
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                numb.text = data?.getIntExtra(EXTRA_KEY_RETURN,0).toString()

            }
        }
    }
}


