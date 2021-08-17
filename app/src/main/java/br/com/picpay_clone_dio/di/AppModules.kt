package br.com.picpay_clone_dio.di

import org.koin.dsl.module

/**
 * @author RubioAlves
 * Created 17/08/2021 at 11:54
 */
object AppModules {

    val appModules = module {
        single {
            NetworkModule.getRetrofit()
        }
    }
}