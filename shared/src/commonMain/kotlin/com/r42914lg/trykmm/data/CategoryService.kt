package com.r42914lg.trykmm.data

import com.r42914lg.trykmm.domain.DomainCategory
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CategoryService {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getCategories(
        amountOfCluesToReturn: Int,
        offset: Int,
    ): List<DomainCategory> {

        var catList: List<DomainCategory>? = null
        try {

             catList = client.get("https://jservice.io/api/categories/") {
                url {
                    parameters.append("count", "$amountOfCluesToReturn")
                    parameters.append("offset", "$offset")
                }
            }.body<List<DomainCategory>>()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return catList!!
    }
}

