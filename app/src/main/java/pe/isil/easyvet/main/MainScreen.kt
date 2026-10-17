package pe.isil.easyvet.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import pe.isil.easyvet.R
import pe.isil.easyvet.core.favorite
import pe.isil.easyvet.core.favoriteOutlined
import pe.isil.easyvet.core.home
import pe.isil.easyvet.core.homeOutlined
import pe.isil.easyvet.features.home.presentation.HomeScreen


@Composable
fun MainScreen() {

    var selectedTab by remember {
        mutableStateOf(MainScreenTab.HOME)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                MainScreenTab.entries.forEach { tab ->
                    val selected = tab == selectedTab
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            selectedTab = tab
                        },
                        icon = {
                            Icon(
                                imageVector = if (selected) tab.icon else tab.outlinedIcon,
                                contentDescription = stringResource(id = tab.title)
                            )
                        },
                        label = {
                            Text(text = stringResource(id = tab.title))
                        }
                    )
                }
            }

        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            when(selectedTab) {
                MainScreenTab.HOME -> {
                    HomeScreen()
                }
                MainScreenTab.FAVORITES -> {
                    Text(text = "Favorites Screen")
                }
            }
        }

    }
}

enum class MainScreenTab(
    val icon: ImageVector,
    val outlinedIcon: ImageVector,
    val title: Int
) {
    HOME(
        icon = home,
        outlinedIcon = homeOutlined,
        title = R.string.tab_home
    ),
    FAVORITES(
        icon = favorite,
        outlinedIcon = favoriteOutlined,
        title = R.string.tab_favorites
    )
}
