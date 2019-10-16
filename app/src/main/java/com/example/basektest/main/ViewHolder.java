package com.example.basektest.main;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.basektest.R;
import com.example.basektest.model.Answer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private Listener listener;

    public ViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        this.listener = listener;
        textView = itemView.findViewById(R.id.textView);
    }

    public void bind(final Answer answer, final int questionPosition) {
        String formattedAnswer = (char) (65 + getAdapterPosition()) + ") " + answer.getTitle();
        textView.setText(formattedAnswer);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickAnswer(questionPosition, answer);
            }
        });
    }

    public void isAnswered(boolean isAnswerSelected, boolean isAnswered, boolean isCorrect) {
        if (isAnswerSelected && isCorrect) {
            textView.setTextColor(Color.parseColor("#8AFF17"));
        } else if (isAnswered) {
            textView.setTextColor(Color.parseColor("#F44336"));
        } else {
            textView.setTextColor(Color.parseColor("#BA000000"));
        }
    }
}
