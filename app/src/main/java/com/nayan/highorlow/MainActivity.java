package com.nayan.highorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;


    public void generateRandomNumber(){
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;//(max-min)+min//

    }

    public void guess(View view){
        EditText editText=(EditText) findViewById(R.id.editText);//we will get as string only//

        int guessvalue = Integer.parseInt(editText.getText().toString());//so we had converted to integer to compare with the random number//

        Log.i("randomNumber",Integer.toString(randomNumber));//we get integer here inorder to login we require a string//

        String  message;

        if (guessvalue>randomNumber){
            message="higher";
        } else if (guessvalue<randomNumber){
            message="lower";
        } else{
            message="you got it right";
            generateRandomNumber();
        }

        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();//we could have return inside if condition itself but for avoiding code redudency we write it seperatly//
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();




    }
}
