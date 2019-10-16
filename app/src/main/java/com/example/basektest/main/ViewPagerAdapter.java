package com.example.basektest.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.basektest.R;
import com.example.basektest.model.Question;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    private List<Question> list;
    private Listener listener;

    public ViewPagerAdapter(List<Question> questions, Listener listener) {
        this.list = questions;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Question question = list.get(position);
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_pager, container, false);

        TextView textView = itemView.findViewById(R.id.textView);
        RecyclerView recyclerView = itemView.findViewById(R.id.recyclerView);
        AnswerAdapter adapter = new AnswerAdapter(question.getAnswers(), listener, position);

        String title = itemView.getContext().getString(R.string.question_title, position, question.getTitle());
        textView.setText(title);
        recyclerView.setAdapter(adapter);
        container.addView(itemView);
        return itemView;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
