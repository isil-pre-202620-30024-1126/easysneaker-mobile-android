package pe.isil.easyvet

import android.app.Application

class MyApplication: Application() {

    companion object {
        lateinit var INSTANCE: MyApplication
            private set
    }

    init {
        INSTANCE = this
    }

}