package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements fragmentDialog.DialogClickListner{
    Button TrueButton, FalseButton;
    ProgressBar progressBar;
    AlertDialog.Builder builder;
    QuestionBank Qbank = new QuestionBank();
    ArrayList<Question> Question;
    int index;
    int progress = 0;
    int rightAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TrueButton = findViewById(R.id.True);
        FalseButton = findViewById(R.id.False);
        progressBar = findViewById(R.id.progressBar);
        builder = new AlertDialog.Builder(this);
        //Qbank= (MyApp) getApplication()).getmanager()
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("currentIndex");

        } else {
            index = 0;

            updateFragment(Qbank.listOfQuestion.get(index).getQuestionId(), Qbank.listOfQuestion.get(index).getColorId());
        }
    }

    private void updateFragment(int QuestId, int ColorId) {
        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.frameLayout);
        FragmentManager1 fragment = FragmentManager1.newInstance(QuestId, ColorId);
        fm.beginTransaction().replace(R.id.frameLayout, fragment).commit();

    }
    public void truePressed(View view) {
        if (Qbank.listOfQuestion.get(index).getAnswerId() == true) {

            rightAns++;
            Toast.makeText(MainActivity.this, "your answer is right", Toast.LENGTH_SHORT).show();

        }
        System.out.println("true answers"+rightAns);
        index++;

        if (index == Qbank.listOfQuestion.size()) {

            index = 0;
            ShowDialog();
        }
        updateFragment(Qbank.listOfQuestion.get(index).QuestionId, Qbank.listOfQuestion.get(index).ColorId);

        progress = progress + 1;
        progressBar.setProgress(progress);
        progressBar.setMax(10);
    }
    public void falsePressed(View view) {
        if (Qbank.listOfQuestion.get(index).getAnswerId() == false) {

            rightAns++;
            Toast.makeText(MainActivity.this, "your answer is right", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "your answer is wrong", Toast.LENGTH_SHORT).show();
        }
        index++;

         if (index == Qbank.listOfQuestion.size()) {
            index = 0;
            ShowDialog();
        }
        updateFragment(Qbank.listOfQuestion.get(index).QuestionId, Qbank.listOfQuestion.get(index).ColorId);
        progress = progress + 1;
        progressBar.setProgress(progress);
        progressBar.setMax(10);

    }
    StorageService storageServiceObj = new StorageService();
    public void ShowDialog(){
        builder.setMessage("Your Score is "+ rightAns+ " out of "+ Qbank.listOfQuestion.size());
       
        int lengthfQuestion = Qbank.listOfQuestion.size();
        String string = rightAns+"/"+ lengthfQuestion  +"#";
        builder.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            storageServiceObj.saveTask(MainActivity.this,string);

            }
        });
        builder.setNegativeButton("ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });
        builder.show();
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("currentIndex", index);
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuitems,menu);
        return true;
    }
    public  void open_dialog(){
        FragmentManager fm = getSupportFragmentManager();
        fragmentDialog msg_fragment = new fragmentDialog();
        msg_fragment.listner=this;
        msg_fragment.show(fm.beginTransaction(),"1");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.Item1:{
                builder.setMessage("Your Correct answers  are "+ storageServiceObj.noOfAttempts(storageServiceObj.getallTasks(MainActivity.this))+ " attempts.");
                builder.show();

                break;
            }
            case R.id.Item2:{

            }
            case R.id.Item3:{
                storageServiceObj.resetallTask(MainActivity.this);
             break;
            }
            case R.id.Item4:{
              open_dialog();

                break;
            }
        }
        return true;
    }

    @Override
    public void dialogAddQuestuions(String quetions, boolean answers) {

    }
}