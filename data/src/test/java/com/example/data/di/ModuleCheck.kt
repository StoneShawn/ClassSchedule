package com.example.data.di

import com.example.data.external.di.networkServiceModule
import org.junit.Test

class ModuleCheck {

    @Test
    fun checkKoin(){
        networkServiceModule
    }
}