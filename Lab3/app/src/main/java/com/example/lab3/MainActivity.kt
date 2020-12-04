package com.example.lab3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.Menu
import android.view.MenuItem
import com.example.lab3.service.TranslatingLenghtService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var lenghtService: TranslatingLenghtService
    private var serviceBound: Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as TranslatingLenghtService.LocalBinder
            lenghtService = binder.getService()
            serviceBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            serviceBound = false
        }
    }

    override fun onStart() {
        super.onStart()

        Intent(this, TranslatingLenghtService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        serviceBound = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val metres=metresInp.text.toString().toDouble();
        return when(item.itemId){
            R.id.toInch->{
                result.text= lenghtService.metreToInch(metres).toString()+R.string.inch
                true
            }
            R.id.toFoot->{
                result.text= lenghtService.metreToFoot(metres).toString()+R.string.foot
                true
            }
            R.id.toYard->{
                result.text= lenghtService.metreToYard(metres).toString()+R.string.yard
                true
            }
            R.id.toMile->{
                result.text= lenghtService.metreToMile(metres).toString()+R.string.mile
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
