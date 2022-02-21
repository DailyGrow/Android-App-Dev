package edu.neu.madcourse.numad22sp_chenjiebei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayInfo(View view){
        EditText nameview=findViewById(R.id.NameText);
        EditText emailview=findViewById(R.id.EmailText);
        nameview.setText("Chenjie Bei");
        emailview.setText("bei.c@northeastern.edu");


    }

    public void onTouch(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void onTouch2(View view){
        Intent intent=new Intent(this,LinkActivity.class);
        startActivity(intent);
    }

    public void onTouch3(View view){
        Intent intent=new Intent(this,LocationActivity.class);
        startActivity(intent);
    }

}