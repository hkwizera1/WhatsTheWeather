import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatstheweather.WeatherRepository
import com.example.whatstheweather.WeatherTodayView

class WeatherTodayViewModelFactory(private val repository: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherTodayView::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WeatherTodayView(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
