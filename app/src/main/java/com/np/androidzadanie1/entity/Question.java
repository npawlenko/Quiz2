package com.np.androidzadanie1.entity;

public class Question {
    private int id;
    private boolean answer;

    public Question(int id, boolean answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public boolean isTrueAnswer() {
        return answer;
    }
}
