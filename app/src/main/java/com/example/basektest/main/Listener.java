package com.example.basektest.main;

import com.example.basektest.model.Answer;

import java.util.HashMap;

public interface Listener {
    HashMap<Integer, Integer> getAnswers();

    void onClickAnswer(int position, Answer answer);
}
