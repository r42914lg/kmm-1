package com.r42914lg.trykmm.data

import com.r42914lg.trykmm.domain.DomainCategory
import com.r42914lg.trykmm.utils.runOperationCatching
import trydb.Database
import trydb.DatabaseDriverFactory

/**
 * Remote
 */
class CategoryRemoteDataSource {

    private val categoryService: CategoryService = CategoryService()

    suspend fun getCategories() =
        runOperationCatching {
            categoryService.getCategories(NUM_OF_ITEMS, OFFSET)
        }
}

/**
 * Local
 */
class CategoryLocalDataSource constructor(
    databaseDriverFactory: DatabaseDriverFactory
) {

    private val database = Database(databaseDriverFactory)

    fun saveAll(data: List<DomainCategory>) {
        database.clearDatabase()
        database.createCategories(data)
    }

    fun nextItem(): DomainCategory {
        val dbCategory = database.getAllCategories()[(0 until NUM_OF_ITEMS).random()]

        return DomainCategory(
            dbCategory.id.toInt(),
            dbCategory.title,
            dbCategory.clue_count.toInt())
    }
}

const val NUM_OF_ITEMS = 20
const val OFFSET = 5

