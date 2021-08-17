package br.com.picpay_clone_dio.di

import br.com.picpay_clone_dio.network.api.ApiService
import br.com.picpay_clone_dio.utils.Constants.URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author RubioAlves
 * Created 17/08/2021 at 11:47
 */
object NetworkModule {

    fun criarHttpClient():OkHttpClient{

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(1,TimeUnit.SECONDS)
            .readTimeout(40,TimeUnit.SECONDS)
            .writeTimeout(40,TimeUnit.SECONDS)
            .build()

    }
    fun getRetrofit(): ApiService {

        return Retrofit.Builder()
            .baseUrl(URL)
            .client(criarHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}