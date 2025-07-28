package rekru.zr.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the Restaurant Detail Screen
 * Manages category selection and carousel auto-scroll functionality
 */
@HiltViewModel
open class RestaurantViewmodel @Inject constructor() : ViewModel() {

    private val _selectedCategory = MutableStateFlow("Burger")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    private val _carouselCurrentPage = MutableStateFlow(2)
    val carouselCurrentPage: StateFlow<Int> = _carouselCurrentPage.asStateFlow()

    private val _isAutoScrollActive = MutableStateFlow(true)
    val isAutoScrollActive: StateFlow<Boolean> = _isAutoScrollActive.asStateFlow()

    private var autoScrollJob: Job? = null
    private val carouselTotalPages = 6
    private val autoScrollDelayMs = 3000L

    init {
        startAutoScroll()
    }

    /**
     * Selects a category and updates the UI state
     */
    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }

    /**
     * Handles manual carousel page change and restarts auto-scroll
     */
    fun onCarouselPageChanged(page: Int) {
        _carouselCurrentPage.value = page
        pauseAndRestartAutoScroll()
    }

    /**
     * Starts the auto-scroll functionality
     */
    private fun startAutoScroll() {
        autoScrollJob?.cancel()
        autoScrollJob = viewModelScope.launch {
            while (_isAutoScrollActive.value) {
                delay(autoScrollDelayMs)

                if(_carouselCurrentPage.value != carouselTotalPages -1 ){
                    val nextPage = (_carouselCurrentPage.value + 1)
                    onCarouselPageChanged(nextPage)
                }
            }
        }
    }

    /**
     * Pauses auto-scroll temporarily and restarts after user interaction
     */
    private fun pauseAndRestartAutoScroll() {
        autoScrollJob?.cancel()
        viewModelScope.launch {
            delay(2000L) // Wait 2 seconds after user interaction
            startAutoScroll()
        }
    }

    /**
     * Enables or disables auto-scroll
     */
    fun setAutoScrollActive(active: Boolean) {
        _isAutoScrollActive.value = active
        if (active) {
            startAutoScroll()
        } else {
            autoScrollJob?.cancel()
        }
    }

    override fun onCleared() {
        super.onCleared()
        autoScrollJob?.cancel()
    }
}
