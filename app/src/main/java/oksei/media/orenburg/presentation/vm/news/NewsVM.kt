package oksei.media.orenburg.presentation.vm.news

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import oksei.media.orenburg.domain.model.DetailedNews
import oksei.media.orenburg.domain.use_case.news.NewsUseCase
import javax.inject.Inject

@HiltViewModel
class NewsVM @Inject constructor(
    private val useCase: NewsUseCase
): ViewModel(){
    private var getNewsEventInfo: Job? = null
    private var getDetailedNews: Job?=null
    private val _state = mutableStateOf(NewsState())
    val state : State<NewsState> = _state
    init {
        getNews()
    }
    private val _openNews = mutableStateOf<DetailedNews?>(null)
    val openNews: State<DetailedNews?> = _openNews

    fun onEvent(event: NewsInfoEvent){
        when(event){
            is NewsInfoEvent.OpenNews -> {
                getDetailedNews?.cancel()
                getDetailedNews = viewModelScope.async(Dispatchers.IO) {
                    val answer= useCase.getDetailedNews(event.id)
                    withContext(Dispatchers.Main){_openNews.value = answer}
                }
            }
            is NewsInfoEvent.ResetNews ->{
                _state.value = NewsState()
                getNews()
            }
            is NewsInfoEvent.ToggleNews ->{
                _state.value = NewsState(
                    type = event.filter,
                    date = event.date,
                    sort = event.sort
                )
                getNews()
            }
            is NewsInfoEvent.CloseDetailedNews -> {
                _openNews.value=null
            }
        }
    }

    private fun getNews(){
        getNewsEventInfo?.cancel()
        val s = _state.value
        getNewsEventInfo = viewModelScope.async(Dispatchers.IO){
            val answer1 =  useCase.getListNewsEvent(s.type,s.date,s.sort)
            withContext(Dispatchers.Main){
                s.news.addAll(answer1)
                s.stateList.value = if (s.news.isEmpty()){ ListNewsEventsState.NoHaveData }else{ ListNewsEventsState.HaveData }
            }
        }
    }
}