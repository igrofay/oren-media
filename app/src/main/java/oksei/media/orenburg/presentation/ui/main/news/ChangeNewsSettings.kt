package oksei.media.orenburg.presentation.ui.main.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import oksei.media.orenburg.R
import oksei.media.orenburg.domain.types.DateType
import oksei.media.orenburg.domain.types.NewsType
import oksei.media.orenburg.domain.types.SortType
import oksei.media.orenburg.presentation.ui.widgets.selected_object.SelectedObject
import oksei.media.orenburg.presentation.vm.news.NewsState
import oksei.media.orenburg.ui.theme.ColorText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChangeNewsSettings(
    state: NewsState,
    reset: ()-> Unit,
    apply: (type: NewsType,date: DateType,sort: SortType)->Unit,
    close : ()->Unit
) {
    var type by remember {
        mutableStateOf(state.type)
    }
    var date by remember {
        mutableStateOf(state.date)
    }
    var sort by remember {
        mutableStateOf(state.sort)
    }
    Dialog(
        onDismissRequest = close
    ) {
        Column(
            Modifier
                .scrollable(rememberScrollState(),Orientation.Vertical)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6))
                .background(colors.background, RoundedCornerShape(6))
                .padding(8.dp)
        ) {
            Text(
                stringResource(R.string.news_about),
                color = colors.ColorText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.subtitle1
            )
            Spacer(modifier = Modifier.height(12.dp))
            SelectType(type, NewsType.All, NewsType.Society,){
                type = it
            }
            Spacer(modifier = Modifier.height(8.dp))
            SelectType(type, NewsType.Sport, NewsType.Culture){
                type = it
            }
            Spacer(modifier = Modifier.height(8.dp))
            SelectType(type, NewsType.Economy, NewsType.Politics){
                type = it
            }
            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = colors.ColorText)
            Spacer(modifier = Modifier.height(8.dp))
            // пропуск
            Text(
                stringResource(R.string.show_first),
                color = colors.ColorText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.subtitle1
            )
            Spacer(modifier = Modifier.height(12.dp))
            SelectSort(sort, SortType.New , SortType.Old ){
                sort = it
            }
            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = colors.ColorText)
            Spacer(modifier = Modifier.height(8.dp))
            // пропуск
            Text(
                stringResource(R.string.show_per),
                color = colors.ColorText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.subtitle1
            )
            Spacer(modifier = Modifier.height(12.dp))
            SelectDate(date, DateType.AllTime , DateType.Hour ){
                date = it
            }
            Spacer(modifier = Modifier.height(8.dp))
            SelectDate(date, DateType.Day , DateType.Week ){
                date = it
            }
            Spacer(modifier = Modifier.height(8.dp))
            SelectDate( date, DateType.Month , DateType.Year ){
                date = it
            }
            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = colors.ColorText)
            //пропуск
            SelectButtons(
                reset = { reset(); close()},
                save = { apply(type, date, sort); close() }
            )
        }
    }
}

@Composable
fun SelectType(
    type: NewsType,
    typeForSelectOne: NewsType,
    typeForSelectTwo: NewsType,
    onChange: (NewsType)-> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        SelectedObject(
            text = stringResource(typeForSelectOne.nameStringRes),
            selected = typeForSelectOne == type,
            onChange = {onChange(typeForSelectOne)},
            width = 135.dp,
        )
        SelectedObject(
            text = stringResource(typeForSelectTwo.nameStringRes),
            selected = typeForSelectTwo == type,
            onChange = {onChange(typeForSelectTwo)},
            width =135.dp
        )
    }
}

@Composable
fun SelectSort(
    sort: SortType,
    sortSelectOne: SortType,
    sortSelectTwo: SortType,
    onChange: (SortType)-> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        SelectedObject(
            text = stringResource(sortSelectOne.nameStringRes),
            selected = sortSelectOne == sort,
            onChange = {onChange(sortSelectOne)},
            width = 135.dp,
        )
        SelectedObject(
            text = stringResource(sortSelectTwo.nameStringRes),
            selected = sortSelectTwo == sort,
            onChange = {onChange(sortSelectTwo)},
            width =135.dp
        )
    }
}
@Composable
fun SelectDate(
    date: DateType,
    dateSelectOne: DateType,
    dateSelectTwo: DateType,
    onChange: (DateType)-> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        SelectedObject(
            text = stringResource(dateSelectOne.nameStringRes),
            selected = dateSelectOne == date,
            onChange = {onChange(dateSelectOne)},
            width = 135.dp,
        )
        SelectedObject(
            text = stringResource(dateSelectTwo.nameStringRes),
            selected = dateSelectTwo == date,
            onChange = {onChange(dateSelectTwo)},
            width =135.dp
        )
    }
}
@Composable
fun SelectButtons(
    reset: () -> Unit,
    save: ()->Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextButton(
            onClick = reset
        ) {
            Text(
                stringResource(R.string.reset),
                style = typography.body1,
                fontWeight = FontWeight.SemiBold
            )
        }
        TextButton(
            onClick = save
        ) {
            Text(
                stringResource(R.string.save),
                style = typography.body1,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
