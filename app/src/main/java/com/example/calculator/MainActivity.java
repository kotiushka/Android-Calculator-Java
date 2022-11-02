/*

Created by kotiushka posted November 2

 */

package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.EmptyStackException;


public class MainActivity extends AppCompatActivity {
    private TextView mShowRes;
    private final StringBuilder stringBuilder = new StringBuilder("0");
    private Vibrator vibrator;
    private GenerateNum generateNum;


    @SuppressLint({"MissingInflatedId", "SourceLockedOrientationActivity"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);
        mShowRes = findViewById(R.id.math_operation);
        generateNum = new GenerateNum(mShowRes, stringBuilder);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        }

    }

    public void Zero(View view) {
        generateNum.generate_num("0");
        vibrator.vibrate(25);
    }

    public void One(View view) {
        generateNum.generate_num("1");
        vibrator.vibrate(25);
    }

    public void Two(View view) {
        generateNum.generate_num("2");
        vibrator.vibrate(25);
    }

    public void Three(View view) {
        generateNum.generate_num("3");
        vibrator.vibrate(25);
    }

    public void Four(View view) {
        generateNum.generate_num("4");
        vibrator.vibrate(25);
    }

    public void Five(View view) {
        generateNum.generate_num("5");
        vibrator.vibrate(25);
    }

    public void Six(View view) {
        generateNum.generate_num("6");
        vibrator.vibrate(25);
    }

    public void Seven(View view) {
        generateNum.generate_num("7");
        vibrator.vibrate(25);
    }

    public void Eight(View view) {
        generateNum.generate_num("8");
        vibrator.vibrate(25);
    }

    public void Nine(View view) {
        generateNum.generate_num("9");
        vibrator.vibrate(25);
    }


    public void AC(View view) {
        stringBuilder.setLength(0);
        stringBuilder.append("0");
        mShowRes.setText(stringBuilder);
        vibrator.vibrate(25);
    }

    public void DEL(View view) {
        int length = stringBuilder.length();
        if (length != 1) {
            stringBuilder.setLength(length - 1);
            mShowRes.setText(stringBuilder);
        } else {
            stringBuilder.setLength(0);
            stringBuilder.append("0");
            mShowRes.setText(stringBuilder);
        }
        vibrator.vibrate(25);
    }


    public void Right(View view) {
        generateNum.generate_symbol("(");
        vibrator.vibrate(25);
    }

    public void Left(View view) {
        generateNum.generate_symbol(")");
        vibrator.vibrate(25);
    }

    public void Dil(View view) {
        generateNum.generate_symbol("/");
        vibrator.vibrate(25);
    }

    public void Mnoj(View view) {
        generateNum.generate_symbol("*");
        vibrator.vibrate(25);
    }

    public void Plus(View view) {
        generateNum.generate_symbol("+");
        vibrator.vibrate(25);
    }

    public void Minus(View view) {
        generateNum.generate_symbol("-");
        vibrator.vibrate(25);
    }

    public void Tok(View view) {
        generateNum.generate_symbol(".");
        vibrator.vibrate(25);
    }

    public void Doriv(View view) {
        try {
            StringBuilder dec = new StringBuilder(String.valueOf(Calculator.decide(stringBuilder.toString())));
            if (dec.toString().equals("0.0")) {
                stringBuilder.setLength(0);
                stringBuilder.append(0);
                mShowRes.setText(stringBuilder.toString());
            }
            else if (dec.charAt(dec.length() - 1) == '0' && dec.charAt(dec.length() - 2) == '.' && !dec.toString().equals("0.0")) {
                stringBuilder.setLength(0);
                stringBuilder.append(Math.round(Double.parseDouble(dec.toString())));
                mShowRes.setText(stringBuilder.toString());
            } else {
                stringBuilder.setLength(0);
                stringBuilder.append(dec);
                mShowRes.setText(stringBuilder.toString());
            }

        } catch (StringIndexOutOfBoundsException | EmptyStackException | NumberFormatException e) {
            mShowRes.setText(stringBuilder);
        }
        vibrator.vibrate(25);
    }
}
