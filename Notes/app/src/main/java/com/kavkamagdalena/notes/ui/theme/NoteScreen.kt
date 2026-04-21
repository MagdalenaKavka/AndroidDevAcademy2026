import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kavkamagdalena.notes.ui.theme.CustomButton
import com.kavkamagdalena.notes.ui.theme.DescriptionText
import com.kavkamagdalena.notes.ui.theme.EditViewModel
import com.kavkamagdalena.notes.ui.theme.SampleList
import com.kavkamagdalena.notes.ui.theme.TitleText


@Composable
fun NoteScreen(
    ID: String?,
    onBackClick: () -> Unit,
    viewModel: EditViewModel = viewModel()
) {
    val existingNote = if (ID == "new") null else SampleList.find { it.ID == ID }

    var title by remember { mutableStateOf(existingNote?.title ?: "") }
    var description by remember { mutableStateOf(existingNote?.description ?: "") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Row(horizontalArrangement = Arrangement.Start) {
            CustomButton(text = "<-", onClick = onBackClick)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = title,
            onValueChange = { title = it },
            placeholder = { TitleText(text = "Title") },
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = description,
            onValueChange = { description = it },
            placeholder = { DescriptionText(text = "Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            CustomButton(
                text = "Done",
                onClick = {
                    viewModel.save(
                        id = existingNote?.ID,
                        title = title,
                        description = description
                    )
                    onBackClick()
                }
            )
        }
    }
}
