package com.example.quizapp;

import android.app.Activity;
import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class StorageService {
    String filename = "database.txt";

    public void saveTask(Activity activity, String text) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            System.out.println("save file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// print all previous error
        } finally {
            // this will run if we have exception or not
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
// 3 /10# 7/10#
    public void resetallTask(Activity context) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);// earas data
            fileOutputStream.write("".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// print all previous error
        }
        finally {
            // this will run if we have exception or not
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String  getallTasks(Activity activity) {
        FileInputStream fileInputStream = null;

        StringBuffer stringBuffer = new StringBuffer();
        int read = 0;
        try {

            fileInputStream = activity.openFileInput(filename);
            while ((read = fileInputStream.read()) != -1) {//
                stringBuffer.append((char) read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
    public String noOfAttempts(String stringFile){

        int index = 0;
        int average=0;
        if (stringFile.isEmpty())   //defensive if stringFile null
            return "0 in 0";
        for (int i = 0 ; i < stringFile.toCharArray().length ; i++){
            if (stringFile.toCharArray()[i] == '#'){
                String fullTask = stringFile.substring(index, i  );
                average=average+ Integer.parseInt(fullTask.substring(0,1));
                index = index + 1;
                System.out.println(index);
            }
        }
        return average/index +" in " + index;

    }
}