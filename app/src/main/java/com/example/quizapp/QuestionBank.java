package com.example.quizapp;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionBank {
    ArrayList<Integer> listOfColors = new ArrayList<>();
    ArrayList<Question> listOfQuestion = new ArrayList<Question>(0);
    public QuestionBank() {

        listOfColors.add(R.color.purple_200);
        listOfColors.add(R.color.purple_500);
        listOfColors.add(R.color.purple_700);
        listOfColors.add(R.color.teal_700);
        listOfColors.add(R.color.teal_200);

        Collections.shuffle(listOfColors);

        Question question1 = new Question(R.string.question1,true,listOfColors.get(0));
        Question question2 = new Question(R.string.question2,true,listOfColors.get(1));
        Question question3 = new Question(R.string.question3,false,listOfColors.get(2));
        Question question4 = new Question(R.string.question4,false,listOfColors.get(3));
        Question question5 = new Question(R.string.question5,true,listOfColors.get(0));
        Question question6 = new Question(R.string.question6,false,listOfColors.get(2));
        Question question7 = new Question(R.string.question7,true,listOfColors.get(1));
        Question question8 = new Question(R.string.question8,true,listOfColors.get(3));
        Question question9 = new Question(R.string.question9,true,listOfColors.get(2));
        Question question10 = new Question(R.string.question10,false,listOfColors.get(3));


        listOfQuestion.add(question1);
        listOfQuestion.add(question2);
        listOfQuestion.add(question3);
        listOfQuestion.add(question4);
        listOfQuestion.add(question5);
        listOfQuestion.add(question6);
        listOfQuestion.add(question7);
        listOfQuestion.add(question8);
        listOfQuestion.add(question9);
        listOfQuestion.add(question10);
        Collections.shuffle(listOfQuestion);

    }

};





