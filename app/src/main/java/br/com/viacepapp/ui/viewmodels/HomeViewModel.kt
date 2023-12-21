package br.com.viacepapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.viacepapp.ui.uistates.HomeViaCepUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel(){

    private val _uiState = MutableStateFlow(HomeViaCepUiState())

    val uiState: StateFlow<HomeViaCepUiState>
        get() = _uiState.asStateFlow()

    init {

    }

}