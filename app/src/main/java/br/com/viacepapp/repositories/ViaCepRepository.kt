package br.com.viacepapp.repositories

import android.util.Log
import br.com.viacepapp.model.Endereco
import br.com.viacepapp.model.toEndereco
import br.com.viacepapp.network.services.ViaCepService
import java.lang.Exception
import javax.inject.Inject

class ViaCepRepository @Inject constructor(
    private val service: ViaCepService
) {
    suspend fun search(cep: String): Endereco {
        return try{
            service.search(cep).let {
                Log.i("ViaCepRepository", "search: ${it.body()}")
                it.body()?.toEndereco() ?: Endereco()
            }
        }catch(e: Exception) {
            Log.e("ViaCepRepository", "search: $e", )
            Endereco()
        }


    }

}