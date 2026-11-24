package dev.aalhdydy550.toolchaintest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT COUNT(*) FROM notes")
    fun count(): Flow<Int>

    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAll(): Flow<List<Note>>
}
