package oksei.media.orenburg.presentation.vm.weather

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import oksei.media.orenburg.domain.model.WeatherNow
import oksei.media.orenburg.domain.use_case.settings.SettingsUseCase
import oksei.media.orenburg.domain.use_case.weather.WeatherUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherVM @Inject constructor(
    private val useCaseW: WeatherUseCase,
    private val useCaseS: SettingsUseCase
) : ViewModel() {
    private val _state  = mutableStateOf<WeatherNowSate>(WeatherNowSate.LoadingData)
    val state: State<WeatherNowSate> = _state
    private var _weatherNow : WeatherNow? = null
    val weatherNow get() = _weatherNow
    private var _getWeatherNow: Job? =null
    init { getWeatherNow() }

    fun onEvent(event: WeatherEvent){
        when(event){
            WeatherEvent.UpdateWeatherNow -> {
                getWeatherNow()
            }
        }
    }
    private fun getWeatherNow(){
        _state.value = WeatherNowSate.LoadingData
        _getWeatherNow?.cancel()
        _getWeatherNow = viewModelScope.async(Dispatchers.IO) {
            val city = useCaseS.getSettingsApp().city
            val answer = useCaseW.getWeatherNow(city)
            withContext(Dispatchers.Main){
                _weatherNow = answer
                _state.value = if(_weatherNow != null) WeatherNowSate.HaveData else WeatherNowSate.NoHaveData
            }
        }
    }
}