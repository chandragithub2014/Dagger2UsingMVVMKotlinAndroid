package com.example.myapplication.network.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.myapplication.R




class NetworkActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.network_layout)
        replaceFragment()


    }



    fun replaceFragment(){
       supportFragmentManager
           .beginTransaction()
           .replace(R.id.container_retro_room,RetroFragment())
           .commit()
    }
}


//Unit Test Scripts
//https://blog.mindorks.com/mockito-cannot-mock-in-kotlin
//https://blog.mindorks.com/using-mockito-in-android-unit-testing-as-a-pro


//https://medium.com/@marco_cattaneo/unit-testing-with-mockito-on-kotlin-android-project-with-architecture-components-2059eb637912
//https://github.com/ibrahimsn98/android-mvvm-dagger-2-rxjava-example/tree/master/app/src/main



//https://stackoverflow.com/questions/50950654/androidviewmodel-and-unit-tests


//https://www.codexpedia.com/android/unit-test-retrofit-2-rxjava-2-and-livedata-in-android/