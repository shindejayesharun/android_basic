package com.shindejayesharun.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.shindejayesharun.room.dao.TaskDao;
import com.shindejayesharun.room.model.TaskModel;

@Database(entities = {TaskModel.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public TaskDao taskDao;
}
