package br.com.viacepapp.network.services

import retrofit2.http.GET

interface ViaCepService {

    companion object{
        const val URL = "viacep.com.br/ws/"
    }

    @GET(URL)
    suspend fun searchCep()


}