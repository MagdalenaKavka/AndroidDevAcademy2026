package com.example.androidacademyapi.ui.productdetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidacademyapi.data.model.Product
import com.example.androidacademyapi.data.repository.ProductRepository
import com.example.androidacademyapi.ui.productlistscreen.ProductListViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

sealed interface ProductDetailsUIState {
    data object Loading : ProductDetailsUIState
    data class Success(val product: Product) : ProductDetailsUIState
    data class Error(val message: String) : ProductDetailsUIState
}
class ProductDetailsViewModel(
    private val repository: ProductRepository,
    private val productId: Int
) : ViewModel() {
    private val _uiState: MutableState<ProductDetailsUIState> =
        mutableStateOf(ProductDetailsUIState.Loading)
    val uiState: State<ProductDetailsUIState> = _uiState

    init {
        loadProduct()
    }

    private fun loadProduct() {
        if (productId < 0) {
            _uiState.value = ProductDetailsUIState.Error("Invalid product ID: ID cannot be negative.")
            return
        }

        viewModelScope.launch {
            _uiState.value = ProductDetailsUIState.Loading
            repository.getProducts()
                .onSuccess { products ->
                    val product = products.find { it.id == productId }
                    if (product != null) {
                        _uiState.value = ProductDetailsUIState.Success(product)
                    } else {
                        _uiState.value = ProductDetailsUIState.Error("Product not found.")
                    }
                }
                .onFailure { e ->
                    val isNoInternet = e is java.net.UnknownHostException ||
                            e is java.net.SocketException ||
                            e is java.net.ConnectException
                    if (isNoInternet) {
                        _uiState.value = ProductDetailsUIState.Error("NO_INTERNET")
                    } else {
                        _uiState.value = ProductDetailsUIState.Error(e.message ?: "Unknown error")
                    }
                }
        }
    }
}

class ProductDetailsViewModelFactory(
    private val repository: ProductRepository,
    private val productId: Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductDetailsViewModel(repository,productId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}