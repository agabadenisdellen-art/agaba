package com.unilifeai

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {
    @Insert
    suspend fun insert(item: ShoppingItem)

    @Update
    suspend fun update(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items ORDER BY category")
    fun getAll(): Flow<List<ShoppingItem>>
}
