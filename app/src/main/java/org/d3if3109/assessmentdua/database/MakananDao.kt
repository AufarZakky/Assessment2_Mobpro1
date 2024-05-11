package org.d3if3109.assessmentdua.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3109.assessmentdua.model.Makanan


@Dao
interface MakananDao {

    @Insert
    suspend fun insert(makanan: Makanan)

    @Update
    suspend fun update(makanan: Makanan)

    @Query("SELECT * FROM makanan ORDER BY jenis ASC")
    fun getMakanan(): Flow<List<Makanan>>

    @Query("SELECT * FROM makanan WHERE id = :id")
    suspend fun getMakananById(id: Long): Makanan?
    @Query("DELETE FROM makanan WHERE id = :id")
    suspend fun deleteById(id: Long)
}