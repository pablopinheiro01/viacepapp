package br.com.viacepapp.ui.uistates

data class HomeViaCepUiState(
    val cep: String = "",
    val logradouro: String = "",
    val numero: String = "",
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val complemento: String = "",
    val onCepChange: (value:String) -> Unit = {},
    val onLogradouroChange: (value:String) -> Unit = {},
    val onNumeroChange: (value:String) -> Unit = {},
    val onBairroChange: (value:String) -> Unit = {},
    val onCidadeChange: (value:String) -> Unit = {},
    val onEstadoChange: (value:String) -> Unit = {},
    val onComplementoChange: (value:String) -> Unit = {},
    val onButtonClick: () -> Unit = {}

)