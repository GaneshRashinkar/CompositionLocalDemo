package com.ganeshrashinkar.compositionlocaldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ganeshrashinkar.compositionlocaldemo.ui.theme.CompositionLocalDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompositionLocalDemo(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CompositionLocalDemo(modifier: Modifier = Modifier) {
    var selectedView:ViewType by remember { mutableStateOf(ViewType.Compact) }
    
    val sizes=when(selectedView){
        ViewType.Compact -> {
            LocalSize()
        }
        ViewType.Comfortable  -> {
            LocalCompositions.comfortableSize
        }
        ViewType.Expanded  -> {
            LocalCompositions.expandedSize
        }
    }

    val typography=when(selectedView){
        ViewType.Compact -> {
            LocalTypography()
        }
        ViewType.Comfortable  -> {
            LocalCompositions.comfortableTypography
        }
        ViewType.Expanded  -> {
            LocalCompositions.expandedTypography
        }
    }

    CompositionLocalProvider(LocalTypographys provides typography,LocalSizes provides sizes) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp),

        )
    {
        Spacer(Modifier.height(160.dp))
        Row(Modifier.fillMaxWidth()
            .clip(shape = CircleShape.copy(CornerSize(8.dp)))
            .background(LocalColors.current.SurfaceLower)
            .padding(2.dp)
            ,
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            )
        {
            ViewPagerButton("Compact",selectedView == ViewType.Compact) {
                selectedView= ViewType.Compact
            }
            ViewPagerButton("Comfortable",selectedView == ViewType.Comfortable) {
                selectedView= ViewType.Comfortable
            }
            ViewPagerButton("Expanded",selectedView == ViewType.Expanded) {
                selectedView= ViewType.Expanded
            }
        }
        Spacer(Modifier.height(16.dp))
        Card(modifier= Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = LocalColors.current.Surface),
            elevation = CardDefaults.cardElevation(
                16.dp
            )
            )
        {
            Column(modifier= Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(LocalSizes.current.gapVertical1)
                ) {
                Row (modifier=Modifier.fillMaxWidth()){
                    Image(painter = painterResource(R.drawable.avatar)
                    , contentDescription = "avatar",
                        modifier = Modifier.size(LocalSizes.current.avatar)
                    )
                    Spacer(Modifier.width(LocalSizes.current.gapHorizontal))
                    Column {
                        Text("Alex Morgan",
                           style = LocalTypographys.current.title
                            )
                        Text("Android Developer",
                            style = LocalTypographys.current.body
                            )
                    }
                }

                Row(modifier=Modifier.fillMaxWidth()
                    .height(IntrinsicSize.Min) ,
                    ) {
                    Column(verticalArrangement = Arrangement
                        .spacedBy(LocalSizes.current.gapVertical2),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                        )
                    {
                        Text("FOLLOWERS",
                            style = LocalTypographys.current.label
                            )
                        Text("1.2K",
                            style = LocalTypographys.current.status
                            )
                    }
                    Box(modifier
                        .width(1.dp)
                        .fillMaxHeight()

                        .background(LocalColors.current.SurfaceLower)
                    ){}
                    Column(verticalArrangement = Arrangement
                        .spacedBy(LocalSizes.current.gapVertical2),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Text("POSTS",
                            style = LocalTypographys.current.label
                        )
                        Text("120",
                            style = LocalTypographys.current.status
                        )
                    }
                }

                Button({},
                    modifier = Modifier.fillMaxWidth()
                        .height(LocalSizes.current.btn)
                    ) {
                    Text("Follow",
                        style = LocalTypographys.current.button
                        )
                }
            }
        }
    }
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CompositionLocalDemoTheme {
        CompositionLocalDemo()
    }
}