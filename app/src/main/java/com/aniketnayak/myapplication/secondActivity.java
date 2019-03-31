package com.aniketnayak.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class secondActivity extends AppCompatActivity {
    public static String text;
    private TextView mTextView;
    private ScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Toast.makeText(this, MainActivity.speech, Toast.LENGTH_SHORT).show();
        // mTextView = (TextView)findViewById(R.id.textView);
        // mTextView.setText(text);
        sv = (ScrollView) findViewById(R.id.sv);
        TextView tv = new TextView(this);
        tv.setTextSize(20);
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tv.setText("What you said " + MainActivity.speech);
        tv.setVisibility(View.VISIBLE);
        //Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
        sv.addView(tv);
        tv.setText(tv.getText().toString() + "\n" + "\n" + "Words Used + Frequency:" + "\n");
        String[] data = MainActivity.speech.split(" ");
        int[] wordCount = new int[data.length];
        for (int i = 0; i < wordCount.length; i++)
            wordCount[i] = 0;
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < data.length; i++) {
            if (words.contains(data[i]))
                System.out.println();
                //Toast.makeText(this, "Word already exists once", Toast.LENGTH_SHORT).show();
            else {
                words.add(data[i]);
                wordCount[i] = getWordCount(data, data[i]);
                tv.setText(tv.getText().toString() + "\n" + data[i] + ": " + getWordCount(data, data[i]));

            }

        }
        tv.setText(" ");
        tv.setText("What you said: "+"\n"+"\n" + MainActivity.speech);
        tv.setText(tv.getText().toString() + "\n" + "\n" + "Words Used + Frequency:" + "\n");
        int temp;
        String dataTemp;
        for(int j = 0;j<wordCount.length;j++) {
            for (int i = 0; i < wordCount.length - 1; i++) {
                if (wordCount[i] < wordCount[i + 1]) {
                    temp = wordCount[i];
                    dataTemp = data[i];
                    wordCount[i] = wordCount[i + 1];
                    data[i] = data[i + 1];
                    wordCount[i + 1] = temp;
                    data[i + 1] = dataTemp;
                }
            }
        }
        for(int i = 0;i<wordCount.length;i++) {
            tv.setText(tv.getText().toString()+"\n"+data[i]+": "+wordCount[i]);
        }

    }
    public int getWordCount(String[] arrayList, String data) {
        int count = 0;
        for (String s : arrayList)
            if (s.equals(data))
                count++;
        return count;
    }
    public int getLargestIndex(int[] a) {
        if(a.length==1)
            return 0;
        int c = 0;
        for(int i = 0;i<a.length;i++)
            if(a[i]>a[c])
                c=i;
        return c;

    }

}

