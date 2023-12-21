package br.com.viacepapp.ui.uistates

data class HomeViaCepUiState(
    val cep: String = "",
    val logradouro: String = "",
    val numero: String = "",
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val complemento: String = "",
    val onCepChange: () -> Unit = { },
    val onLogradouroChange: () -> Unit = {},
    val onNumeroChange: () -> Unit = {},
    val onBairroChange: () -> Unit = {},
    val onCidadeChange: () -> Unit = {},
    val onEstadoChange: () -> Unit = {},
    val onComplementoChange: () -> Unit = {},
    val onButtonClick: () -> Unit = {}

)