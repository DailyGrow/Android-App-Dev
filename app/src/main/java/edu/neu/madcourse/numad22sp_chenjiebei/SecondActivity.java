package edu.neu.madcourse.numad22sp_chenjiebei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView myTextView = findViewById(R.id.textView3);
    }

    public void onClick(View view){
        TextView myTextView = findViewById(R.id.textView3);
        switch(view.getId()){
            case R.id.buttonA:

                myTextView.setText("Pressed: A");
                //Toast toastA= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastA.setGravity(Gravity.CENTER,0,0);
                //toastA.show();
                break;
            case R.id.buttonB:

                myTextView.setText("Pressed: B");
                //Toast toastB= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastB.setGravity(Gravity.CENTER,0,0);
                //toastB.show();
                break;
            case R.id.buttonC:
                myTextView.setText("Pressed: C");
                //Toast toastC= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastC.setGravity(Gravity.CENTER,0,0);
                //toastC.show();
                break;
            case R.id.buttonD:
                myTextView.setText("Pressed: D");
                //Toast toastD= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastD.setGravity(Gravity.CENTER,0,0);
                //toastD.show();
                break;
            case R.id.buttonE:
                myTextView.setText("Pressed: E");
                //Toast toastE= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastE.setGravity(Gravity.CENTER,0,0);
                //toastE.show();
                break;
            case R.id.buttonF:
                myTextView.setText("Pressed: F");
                //Toast toastF= Toast.makeText(getApplicationContext(),"Pressed: A", Toast.LENGTH_SHORT);
                //toastF.setGravity(Gravity.CENTER,0,0);
                //toastF.show();
                break;
        }

    }
}