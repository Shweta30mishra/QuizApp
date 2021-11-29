package com.example.quizapp;

public class Question {
    int QuestionId;
    boolean AnswerId;
    int ColorId;


    public Question(int questionID,boolean answerId,int colorId) {
        this.QuestionId = questionID;
        this.AnswerId= answerId;
        this.ColorId = colorId;

    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        this.QuestionId = questionId;
    }

    public boolean getAnswerId() {
        return AnswerId;
    }

    public void setAnswerId(boolean answerId) {
        this.AnswerId = answerId;
    }

    public int getColorId() {
        return ColorId;
    }

    public void setColorId(int colorId) {
        this.ColorId = colorId;
    }
}

