package com.aniketnayak.myapplication;

import android.content.Intent;
import android.os.TestLooperManager;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView mStartTalkingText;
    public static String speech;
    private Button mstartTalking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartTalkingText = (TextView)findViewById(R.id.startTalkingText);


    }
    public void getSpeechInput(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if(intent.resolveActivity(getPackageManager())!=null) {
            startActivityForResult(intent, 10);
        }
        else {
            Toast.makeText(this, "Your device does not support Speech to Text", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        switch (requestCode) {
            case 10:
                if(resultCode==RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mStartTalkingText.setText(result.get(0));
                    speech = mStartTalkingText.getText().toString();
                    startActivity(new Intent(MainActivity.this, secondActivity.class));
                }



                break;
        }
    }
}
