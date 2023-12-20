package br.com.viacepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.viacepapp.ui.theme.ViaCepAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViaCepAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeViaCep()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViaCep(
    modifier: Modifier = Modifier
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
            ComponentOutlinedTextField(modifier = modifier, label = "CEP")
            ComponentOutlinedTextField(modifier = modifier, label = "Lograduro")
            ComponentOutlinedTextField(modifier = modifier, label = "Número")
            ComponentOutlinedTextField(modifier = modifier, label = "Bairro")
            ComponentOutlinedTextField(modifier = modifier, label = "Cidade")
            ComponentOutlinedTextField(modifier = modifier, label = "Estado")
            ComponentOutlinedTextField(modifier = modifier, label = "Complemento")
            Spacer(modifier = modifier.heightIn(16.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(58.dp)
                    .padding(start = 10.dp, end = 10.dp)
                ,
                onClick = { /*TODO*/ }) {
                
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeViaCep() {
    ViaCepAppTheme {
        HomeViaCep()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: () -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(start = 10.dp, end = 10.dp))
        ,
        value = "",
        label = { Text(label) },
        onValueChange = {onValueChange()}
    )
}

@Preview
@Composable
fun ComponentOutlinedTextFieldPreview() {
    ViaCepAppTheme {
        ComponentOutlinedTextField(label = "CEP", onValueChange = { })
    }
}