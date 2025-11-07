package com.unilifeai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShoppingRepository(private val shoppingItemDao: ShoppingItemDao) {

    val allItems = shoppingItemDao.getAll()

    suspend fun insert(item: ShoppingItem) {
        withContext(Dispatchers.IO) {
            shoppingItemDao.insert(item)
        }
    }

    suspend fun update(item: ShoppingItem) {
        withContext(Dispatchers.IO) {
            shoppingItemDao.update(item)
        }
    }

    suspend fun delete(item: ShoppingItem) {
        withContext(Dispatchers.IO) {
            shoppingItemDao.delete(item)
        }
    }
}
