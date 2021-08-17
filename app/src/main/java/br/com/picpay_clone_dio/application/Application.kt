package br.com.picpay_clone_dio.application

import android.app.Application
import br.com.picpay_clone_dio.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author RubioAlves
 * Created 17/08/2021 at 11:52
 */
class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@Application)
            modules(AppModules.appModules)
        }

    }
}