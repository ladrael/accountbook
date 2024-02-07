package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Greeting("Android")     // 이 자체로 무결한
//            MessageCard(msg = Message("Android", "JET PACK"))
//
//            // 프리뷰 안에 내용 그대로 쓰기
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
            MyApplicationTheme{    //Theme.kt에 있는 함수 그대로 쓰기
//                Surface {
//                    MessageCard(msg = Message("Colleague", "Hey take a look at jetPack"))
//                }
                Conversation(messages = SampleData.conversationSample)
            }

        }
    }
}

data class Message(val author: String, val body : String)


@Composable
fun MessageCard(msg : Message){
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Contant profile Picture",
            modifier = Modifier
                // Set image size to 40dp
                .size(40.dp)
                // Clip image to be shape as a circle
                .clip(CircleShape)
                //MaterialTheme.colors를 사용해서 테마스타일 색상 지정
                //colors에서 colorScheme로 변경됨 아마도~
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        //Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        //We keep track if the message is expanded or not in this
        //variable
        //remember 및 mutableStateOf와 같은 Compose의 상태 API를 사용하여 상태를 변경하면 UI가 자동으로 업데이트됩니다.

        var isExpanded by remember { mutableStateOf(false)}
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if(isExpanded) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.surface,
            label = "animateColor"
        )

        //We toggle the isExpanded variable when we click on this
        // 클릭하면 확장됨, 기본 1줄 maxLine
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {             // 텍스트 수직으로 정렬하게 하는 함수 ROW는 수평으로 BOX 는 쌓기
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondaryContainer,
                // 서체 typography 속성에서 확인함
                style = MaterialTheme.typography.titleSmall            // 마이그레이션 주의 subtitle 속성이 없어짐
            )
            //Add a vertical space between the author and body text
            Spacer(modifier = Modifier.height(4.dp))

            //Elevation이 shadow : 그림자 지게하기 , tonal : 안으로 들어가기 로 두가지 있음
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                //surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                //animateContentSize will changing the surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    //If the message is expanded, we display all its content
                    //otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall
                )
            }


        }
    }
}
// 같은 함수에서도 프리뷰 여러개 생성할 수 있음
// 프리뷰 name 정해주기
@Preview(name ="Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",

)
@Preview
@Composable
fun PreviewMessageCard(){
    MyApplicationTheme {    //Theme.kt에 있는 함수 그대로 쓰기
        Surface {
            MessageCard(msg = Message("Colleague", "Hey take a look at jetPack"))
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
// 프리뷰를 띄우기 위한 파라미터 없는 함수 생성함
//@Preview(showBackground = true)          //파라미터가 없을때만 실행 할 수있음
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
@Composable
fun Conversation(messages : List<Message>){
    LazyColumn{
        items(messages) {message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "conversation", showBackground = true)
@Composable
fun previewConversation(){
    MyApplicationTheme {
        Conversation(SampleData.conversationSample)
    }
}



