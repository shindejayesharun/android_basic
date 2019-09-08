package com.shindejayesharun.room.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.shindejayesharun.room.R;
import com.shindejayesharun.room.database.DatabaseClient;
import com.shindejayesharun.room.model.TaskModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<TaskModel> taskModels;
    TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RecyclerView recyclerView=findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter=new TaskAdapter(taskModels,this);
        recyclerView.setAdapter(taskAdapter);

        new getAllList().execute();
    }

     class getAllList extends AsyncTask<Void,Void, List<TaskModel>>{

        @Override
        protected List<TaskModel> doInBackground(Void... voids) {
            TaskModel taskModel=new TaskModel();
            taskModel.setName("jayesh");
            taskModel.setAddress("");
            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao.insert(taskModel);
            return DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao.getTaskList();
        }

         @Override
         protected void onPostExecute(List<TaskModel> taskModel) {
             super.onPostExecute(taskModel);
             taskModels=taskModel;
             taskAdapter.notifyDataSetChanged();
         }
     }




}
