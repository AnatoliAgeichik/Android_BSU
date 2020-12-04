package com.example.lab3.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

open class TranslatingLenghtService :Service() {

companion object
    val inch=0.00254;
    val foot=0.3048
    val yard=0.9144
    val mile=1609

private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
    fun getService(): TranslatingLenghtService = this@TranslatingLenghtService

    }
    fun metreToInch(metres:Double):Double{
        return metres/inch
    }
    fun metreToFoot(metres:Double):Double{
        return metres/foot
    }
    fun metreToYard(metres:Double):Double{
        return metres/yard
    }
    fun metreToMile(metres:Double):Double{
        return metres/mile
    }


    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

}