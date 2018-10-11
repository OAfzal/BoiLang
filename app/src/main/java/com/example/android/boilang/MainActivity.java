package com.example.android.boilang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText textTBT;
    TextView translatedTextView;
    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageView) findViewById(R.id.button);
        textTBT = (EditText) findViewById(R.id.TEXT_TBT);
        translatedTextView = (TextView) findViewById(R.id.TRANSLATED_VIEW);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translatedText();
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });

    }

    private void translatedText(){

        char text[] = textTBT.getText().toString().trim().toCharArray();
        String trans = "";
        int size = text.length,j=0;
        char newText[] = new char[size];

        for(int i=size-1; i >= 0;i--){

            newText[j] = text[i];


            j++;
        }

        for(int i=0; i<size;i++){

            trans += newText[i];
        }

        String[] array = trans.split(" ");
        size = array.length - 1;

        trans = "";

        for(int i = size ;i>=0;i--){
            trans += array[i];
            trans+= " ";
        }
        translatedTextView.setText(trans.toLowerCase());

    }
}
