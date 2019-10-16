package com.example.basektest.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basektest.R;
import com.example.basektest.model.Answer;

public class AnswerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Answer> list;
    private Listener listener;
    private int questionPosition;

    public AnswerAdapter(List<Answer> list, Listener listener, int position) {
        this.list = list;
        this.listener = listener;
        this.questionPosition = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_answer, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position), this.questionPosition);
        HashMap<Integer, Integer> map = listener.getAnswers();
        boolean isAnswerSelected = map.containsKey(questionPosition);
        boolean isAnswered = map.get(questionPosition) != null && map.get(questionPosition) == list.get(position).getId();
        boolean isCorrect = list.get(position).isCorrect();
        holder.isAnswered(isAnswerSelected, isAnswered, isCorrect);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
