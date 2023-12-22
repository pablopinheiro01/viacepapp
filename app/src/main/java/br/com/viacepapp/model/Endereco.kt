package br.com.viacepapp.model

data class EnderecoResponse(
    val cep: String = "",
    val logradouro: String = "",
    val complemento: String = "",
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = "",
    val ibge: String = "",
    val gia: String = "",
    val ddd: String = "",
    val siafi: String = ""
)

fun EnderecoResponse.toEndereco(): Endereco {
    return Endereco(
        cep = cep,
        logradouro = logradouro,
        complemento = complemento,
        bairro = bairro,
        localidade = localidade,
        uf = uf,
        ibge = ibge,
        gia = gia,
        ddd = ddd,
        siafi = siafi
    )
}

data class Endereco(
    val cep: String = "",
    val logradouro: String = "",
    val complemento: String = "",
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = "",
    val ibge: String = "",
    val gia: String = "",
    val ddd: String = "",
    val siafi: String = ""
)