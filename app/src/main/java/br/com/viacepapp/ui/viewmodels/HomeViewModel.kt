package br.com.viacepapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.viacepapp.repositories.ViaCepRepository
import br.com.viacepapp.ui.uistates.HomeViaCepUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ViaCepRepository
) : ViewModel() {

    private var currentUiStateJob: Job? = null

    private val _uiState = MutableStateFlow(HomeViaCepUiState())

    val uiState: StateFlow<HomeViaCepUiState>
        get() = _uiState.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { currentState ->
                currentState.copy(
                    onCepChange = { cep ->
                        _uiState.value = _uiState.value.copy(
                            cep = cep
                        )
                        search(cep)
                    },
                    onComplementoChange = { complemento ->
                        _uiState.value = _uiState.value.copy(
                            complemento = complemento
                        )
                    },
                    onEstadoChange = { estado ->
                        _uiState.value = _uiState.value.copy(
                            estado = estado
                        )
                    },
                    onCidadeChange = { cidade ->
                        _uiState.value = _uiState.value.copy(
                            cidade = cidade
                        )
                    },
                    onBairroChange = { bairro ->
                        _uiState.value = _uiState.value.copy(
                            bairro = bairro
                        )
                    },
                    onLogradouroChange = { logradouro ->
                        _uiState.value = _uiState.value.copy(
                            logradouro = logradouro
                        )
                    },
                    onNumeroChange = { numero ->
                        _uiState.value = _uiState.value.copy(
                            numero = numero
                        )
                    },
                    onButtonClick = {
                        Log.i("HomeViewModel", "onButtonClick")
                        search(_uiState.value.cep)
                    }
                )
            }
        }

    }

    private fun search(cep: String) {
        Log.i("HomeViewModel", "search: ${cep}")
        currentUiStateJob?.cancel()
        currentUiStateJob = viewModelScope.launch {
            delay(4000L)
//            val endereco = repository.search(cep)
//            Log.i("HomeViewModel", "search: $endereco")
//
//            if (endereco.logradouro.isNotEmpty()) {
//                _uiState.value = _uiState.value.copy(
//                    cep = endereco.cep,
//                    bairro = endereco.bairro,
//                    logradouro = endereco.logradouro,
//                    estado = endereco.uf,
//                    cidade = endereco.localidade
//                )
//            }

            repository.search(cep).let { address ->
                _uiState.update {
                    it.copy(
                        logradouro = address.logradouro,
                        bairro = address.bairro,
                        estado = address.uf,
                        cidade = address.localidade
                    )
                }
            }
        }
    }


}