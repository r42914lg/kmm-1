package com.r42914lg.trykmm.domain

import com.r42914lg.trykmm.utils.Result

interface CategoryRepository {
    suspend fun getCategories(): Result<List<DomainCategory>, Throwable>
    fun saveAll(data: List<DomainCategory>)
    fun requestNext(): DomainCategory
}