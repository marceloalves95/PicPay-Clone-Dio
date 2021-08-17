package br.com.picpay_clone_dio.network.api

import br.com.picpay_clone_dio.network.domain.PageTransacao
import br.com.picpay_clone_dio.network.domain.Transacao
import br.com.picpay_clone_dio.network.domain.Usuario
import retrofit2.http.*

/**
 * @author RubioAlves
 * Created 17/08/2021 at 11:51
 */
interface ApiService {

    @GET("/usuarios/contatos")
    suspend fun getTodosUsuarios(@Query("login") login: String): List<Usuario>

    @GET("/usuarios/{login}")
    suspend fun getUsuario(@Path("login") login: String): Usuario

    @GET("/usuarios/{login}/saldo")
    suspend fun getSaldo(@Path("login") login: String): Usuario

    @POST("/transacoes")
    suspend fun realizarTransacao(@Body transacao: Transacao): Transacao

    @GET("/transacoes")
    suspend fun getTransacoes(@Query("login") login: String): PageTransacao

}