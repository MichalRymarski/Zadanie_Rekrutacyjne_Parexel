package rekru.zr.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class RecruitmentViewmodel : ViewModel() {

    private val _uiError = MutableStateFlow<String?>(null)
    val uiError = _uiError.asStateFlow()



}