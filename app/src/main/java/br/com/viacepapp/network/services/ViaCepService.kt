package br.com.viacepapp.network.services

import br.com.viacepapp.model.EnderecoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    companion object{
        const val URL = "ws/{cep}/json"
    }

    @GET(URL)
    suspend fun search(@Path("cep") cep: String): Response<EnderecoResponse>

}