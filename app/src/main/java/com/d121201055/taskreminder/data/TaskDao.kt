package com.d121201055.taskreminder.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.d121201055.taskreminder.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM task WHERE status='Belum Selesai'")
    fun readAllData(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE status='Selesai'")
    fun readAllDataHistory(): LiveData<List<Task>>

    @Update
    suspend fun updateTask(task: Task)

}