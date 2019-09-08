package com.shindejayesharun.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.shindejayesharun.room.model.TaskModel;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM taskmodel")
    List<TaskModel> getTaskList();

    @Insert
    void insert(TaskModel taskModel);

    @Update
    void update(TaskModel taskModel);

    @Delete
    void delete(TaskModel taskModel);

}
