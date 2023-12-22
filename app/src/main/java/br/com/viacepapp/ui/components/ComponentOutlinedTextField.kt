package br.com.viacepapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.viacepapp.ui.theme.ViaCepAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (value: String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(start = 10.dp, end = 10.dp))
        ,
        value = value,
        label = { Text(label) },
        onValueChange = { onValueChange(it) }
    )
}

@Preview
@Composable
fun ComponentOutlinedTextFieldPreview() {
    ViaCepAppTheme {
        ComponentOutlinedTextField(label = "CEP", value = "CEP", onValueChange = { })
    }
}