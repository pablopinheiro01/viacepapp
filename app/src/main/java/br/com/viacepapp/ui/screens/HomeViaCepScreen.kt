package br.com.viacepapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.viacepapp.ui.components.ComponentOutlinedTextField
import br.com.viacepapp.ui.theme.ViaCepAppTheme
import br.com.viacepapp.ui.uistates.HomeViaCepUiState
import br.com.viacepapp.ui.viewmodels.HomeViewModel


@Composable
fun HomeViaCepScreen(
    state: HomeViaCepUiState,
    viewModel: HomeViewModel,
    navController: NavController
) {

    HomeViaCepScreen(
        cep = state.cep,
        logradouro = state.logradouro,
        numero = state.numero,
        bairro = state.bairro,
        cidade = state.cidade,
        estado = state.estado,
        complemento = state.complemento,
        onCepChange = {
            state.onCepChange(it)
        },
        onLogradouroChange = { state.onLogradouroChange(it) },
        onNumeroChange = { state.onNumeroChange(it) },
        onBairroChange = { state.onBairroChange(it) },
        onCidadeChange = { state.onCidadeChange(it) },
        onEstadoChange = { state.onEstadoChange(it) },
        onComplementoChange = { state.onComplementoChange(it) },
        onButtonClick = { state.onButtonClick() }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViaCepScreen(
    modifier: Modifier = Modifier,
    cep: String = "",
    logradouro: String = "",
    numero: String = "",
    bairro: String = "",
    cidade: String = "",
    estado: String = "",
    complemento: String = "",
    onCepChange: (value: String) -> Unit = { },
    onLogradouroChange: (value: String) -> Unit = {},
    onNumeroChange: (value: String) -> Unit = {},
    onBairroChange: (value: String) -> Unit = {},
    onCidadeChange: (value: String) -> Unit = {},
    onEstadoChange: (value: String) -> Unit = {},
    onComplementoChange: (value: String) -> Unit = {},
    onButtonClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ComponentOutlinedTextField(
                modifier = modifier,
                label = "CEP",
                value = cep,
                onValueChange = { value ->
                    onCepChange(value)
                }
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = logradouro,
                onValueChange = { onLogradouroChange(it) },
                label = "Lograduro"
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = numero,
                onValueChange = { onNumeroChange(it) },
                label = "Número"
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = bairro,
                onValueChange = { onBairroChange(it) },
                label = "Bairro"
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = cidade,
                onValueChange = { onCidadeChange(it) },
                label = "Cidade"
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = estado,
                onValueChange = { onEstadoChange(it) },
                label = "Estado"
            )
            ComponentOutlinedTextField(
                modifier = modifier,
                value = complemento,
                onValueChange = { onComplementoChange(it) },
                label = "Complemento"
            )
            Spacer(modifier = modifier.heightIn(16.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(58.dp)
                    .padding(start = 10.dp, end = 10.dp),
                onClick = { onButtonClick() }) {
                Text(text = "Pesquisar")
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeViaCep() {
    ViaCepAppTheme {
        HomeViaCepScreen()
    }
}
