package com.r42914lg.trykmm.data

import com.r42914lg.trykmm.utils.Result
import com.r42914lg.trykmm.domain.CategoryRepository
import com.r42914lg.trykmm.domain.DomainCategory
import trydb.DatabaseDriverFactory

class CategoryRepositoryImpl constructor(
    databaseDriverFactory: DatabaseDriverFactory
): CategoryRepository {

    private val categoryLocalDataSource: CategoryLocalDataSource = CategoryLocalDataSource(databaseDriverFactory)

    private val categoryRemoteDataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()

    override suspend fun getCategories(): Result<List<DomainCategory>, Throwable> =
        categoryRemoteDataSource.getCategories()

    override fun saveAll(data: List<DomainCategory>) {
        categoryLocalDataSource.saveAll(data)
    }

    override fun requestNext() = categoryLocalDataSource.nextItem()
}