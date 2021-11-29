package com.example.quizapp;

import android.app.Activity;
import android.app.Application;

public class myApp extends Application {
    private QuestionBank manager = new QuestionBank();
    Activity appContext ;
    public StorageService storageService = new StorageService();
    public QuestionBank getmanager(){return manager;}
    public StorageService getStorageService(){return storageService;}
}
