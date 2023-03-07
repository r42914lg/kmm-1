package com.r42914lg.trykmm.data

import com.r42914lg.trykmm.domain.DomainCategory
import com.r42914lg.trykmm.httpClient
import io.ktor.client.call.*
import io.ktor.client.request.get

class CategoryService {

    private val client = httpClient()

    suspend fun getCategories(
        amountOfCluesToReturn: Int,
        offset: Int,
    ): List<DomainCategory> {

        val result = client.get("https://jservice.io/api/categories/") {
            url {
                parameters.append("count", "$amountOfCluesToReturn")
                parameters.append("offset", "$offset")
            }
        }

        val catList: List<DomainCategory> = result.body()
        return catList
    }
}

