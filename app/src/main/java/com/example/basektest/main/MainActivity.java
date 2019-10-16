package com.example.basektest.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.basektest.R;
import com.example.basektest.model.Answer;
import com.example.basektest.model.Question;
import com.example.basektest.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements Listener {
    private Button buttonDalee, buttonPred ;

    private ViewPager viewPager;
    private String FILENAME = "test.json";
    private HashMap<Integer, Integer> map = new HashMap<>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        buttonDalee = findViewById(R.id.bottomDalee);
        buttonPred = findViewById(R.id.bottomPred);

        adapter = new ViewPagerAdapter(getQuestions(), this);
        viewPager.setAdapter(adapter);

        buttonDalee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() - 1){
                    Intent intent = new Intent(MainActivity.this,Total.class);
                    intent.putExtra("map",getAnswers());
                    startActivity(intent);

                } else viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
            // MVP MVVM
        });

        buttonPred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == adapter.getCount() + 1){

                } else viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
    }

    private List<Question> getQuestions() {
        String json = ResourceManager.readFromAssets(this, FILENAME);
        Type type = new TypeToken<List<Question>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    public HashMap<Integer, Integer> getAnswers() {
        return map;
    }

    @Override
    public void onClickAnswer(int position, Answer answer) {
        map.put(position, answer.getId());
        adapter.notifyDataSetChanged();
    }
}
