package com.example.basektest.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basektest.R;
import com.example.basektest.model.Answer;
import com.example.basektest.model.Question;

import java.util.HashMap;
import java.util.List;

public class Total extends AppCompatActivity {

    TextView textFalse, textTrue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_total);

        textTrue = findViewById(R.id.textTrue);
        textFalse = findViewById(R.id.textFalse);

        Intent intent = getIntent();
        HashMap<Integer, Answer> hashMap = (HashMap<Integer, Answer>)intent.getSerializableExtra("map");

        textTrue.setText(hashMap.toString());

    }
}
