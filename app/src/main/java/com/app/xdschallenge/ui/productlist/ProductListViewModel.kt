package com.app.xdschallenge.ui.productlist

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.xdschallenge.domain.models.ProductDetails
import com.app.xdschallenge.domain.remote.AppContainer
import com.app.xdschallenge.domain.remote.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductListViewModel(
    val repository: ProductRepository = AppContainer.repository
) : ViewModel() {
    private val _productList: MutableState<List<ProductDetails>?> =
        mutableStateOf(null)
    val productList: State<List<ProductDetails>?> = _productList

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    fun loadProducts() {
        viewModelScope.launch(Dispatchers.IO) {
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