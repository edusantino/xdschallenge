package com.santino.data

import com.santino.data.repository.ProductRepositoryImpl
import com.santino.domain.datasource.ProductRemoteDataSource
import com.santino.domain.models.ProductDetails
import com.santino.domain.repository.ConfigRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ProductRepositoryImplTest {

    private val remote = mockk<ConfigRepository>()
    private val offline = mockk<ProductRemoteDataSource>()
    private val mock = mockk<ProductRemoteDataSource>()
    private lateinit var repository: ProductRepositoryImpl

    @Before
    fun setup() {
        repository = ProductRepositoryImpl(remote, offline, mock)
    }

    @Test
    fun `deve usar remoteConfig se estiver disponível`() = runTest {
        // JSON mockado (simulando o que viria do Remote Config)
        val fakeJson = """
        [
          {"id": "1", "title": "Peperoni", "imageUrl": "", "rating": 4.4, "priceList": []}
        ]
    """.trimIndent()

        // Mocka o comportamento do remoteConfig
        coEvery { remote.getString("pizza_catalog") } returns fakeJson

        // Mocka offline e mockDataSource só por segurança
        coEvery { offline.getProductCatalog() } returns emptyList()
        coEvery { mock.getProductCatalog() } returns emptyList()

        val result = repository.getProductList().first()

        // Verifica se o JSON foi convertido corretamente
        assertEquals("Peperoni", result?.first()?.title)

        // Garante que só o remote foi chamado
        coVerify(exactly = 1) { remote.getString("pizza_catalog") }
        coVerify(exactly = 0) { offline.getProductCatalog() }
        coVerify(exactly = 0) { mock.getProductCatalog() }
    }

    @Test
    fun `deve usar offline se remote falhar`() = runTest {
        // Simula falha no remoteConfig
        coEvery { remote.getString("pizza_catalog") } throws Exception("Remote error")

        // Mocka o retorno do offline
        coEvery { offline.getProductCatalog() } returns listOf(
            ProductDetails(
                id = "2",
                title = "Mussarela",
                imageUrl = "",
                rating = 4.0f,
                priceList = listOf()
            )
        )

        val result = repository.getProductList().first()

        assertEquals("Mussarela", result?.first()?.title)

        // Verificações
        coVerify(exactly = 1) { remote.getString("pizza_catalog") }
        coVerify(exactly = 1) { offline.getProductCatalog() }
        coVerify(exactly = 0) { mock.getProductCatalog() }
    }

    @Test
    fun `deve usar mock se remote e offline falharem`() = runTest {
        coEvery { remote.getString("pizza_catalog") } throws Exception("Remote error")
        coEvery { offline.getProductCatalog() } throws Exception("Offline error")

        coEvery { mock.getProductCatalog() } returns listOf(
            ProductDetails(
                id = "3",
                title = "Quatro Queijos",
                imageUrl = "",
                rating = 4.6f,
                priceList = listOf()
            )
        )

        val result = repository.getProductList().first()

        assertEquals("Quatro Queijos", result?.first()?.title)

        coVerify(exactly = 1) { remote.getString("pizza_catalog") }
        coVerify(exactly = 1) { offline.getProductCatalog() }
        coVerify(exactly = 1) { mock.getProductCatalog() }
    }
}