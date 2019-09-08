package com.shindejayesharun.room.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shindejayesharun.room.R;
import com.shindejayesharun.room.model.TaskModel;

import java.util.List;

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    List<TaskModel> taskModels;
    Context context;


    public TaskAdapter(List<TaskModel> taskModels, Context context) {
        this.taskModels = taskModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_word,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskModel taskModel=taskModels.get(position);
        holder.tvName.setText(taskModel.getName());
    }

    @Override
    public int getItemCount() {
        return taskModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvWord);
        }
    }
}
