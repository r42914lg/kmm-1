package trydb

import com.r42914lg.trykmm.domain.DomainCategory

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = MyDb(databaseDriverFactory.createDriver())
    private val dbQuery = database.myDbQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllCategories()
        }
    }

    internal fun getAllCategories(): List<Category> {
        return dbQuery.selectAllCategories().executeAsList()
    }

    internal fun createCategories(categories: List<DomainCategory>) {
        dbQuery.transaction {
            categories.forEach { category ->
                insertCategory(category)
            }
        }
    }

    private fun insertCategory(category: DomainCategory) {
        dbQuery.insertCategory(
            id = category.id.toLong(),
            title = category.title,
            clue_count = category.clues_count.toString()
        )
    }
}