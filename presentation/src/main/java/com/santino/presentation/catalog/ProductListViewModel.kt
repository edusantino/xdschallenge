package com.santino.presentation.catalog

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.xdschallenge.di.AppModule
import com.santino.domain.models.ProductDetails
import com.santino.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductListViewModel(
    val repository: ProductRepository = AppModule.repository
) : ViewModel() {
    private val _productList = MutableStateFlow<List<ProductDetails>?>(null)
    val productList: StateFlow<List<ProductDetails>?> = _productList.asStateFlow()

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                repository.getProductList().collect {
                    _productList.value = it
                }
            } catch (t: Throwable) {
                Log.e("MainViewModel", "error: ${t.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}