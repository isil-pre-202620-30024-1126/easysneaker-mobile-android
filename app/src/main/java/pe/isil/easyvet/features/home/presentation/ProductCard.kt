package pe.isil.easyvet.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil3.compose.AsyncImage
import pe.isil.easyvet.features.home.domain.Product

@Composable
fun ProductCard(product: Product) {
    Card (modifier = Modifier.fillMaxWidth().padding(8.dp)){
        Column (modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = product.image,
                contentDescription = product.name,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Text(product.name, fontWeight = FontWeight.Bold, maxLines = 1)
            Text(text = "Rating: ${product.rating}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}