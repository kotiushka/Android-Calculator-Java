package com.example.calculator;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenerateNum {
    private final TextView textView;
    private final StringBuilder stringBuilder;
    private static final ArrayList<Character> array = new ArrayList<>();

    public GenerateNum(TextView textView, StringBuilder stringBuilder) {
        this.textView = textView;
        this.stringBuilder = stringBuilder;
        array.add('/');
        array.add('*');
        array.add('+');
        array.add('-');
        array.add('.');
    }


    public void generate_num(String num_To_add) {

        if (stringBuilder.toString().equals("0")) {
            stringBuilder.setLength(0);
        }
        if (textView.getText().length() < 50) {
            stringBuilder.append(num_To_add);
            textView.setText(stringBuilder);
        }
    }

    public void generate_symbol(String symbol_To_add) {
        char last_char = textView.getText().charAt(textView.getText().length() - 1);
            if (!array.contains(last_char) || symbol_To_add.equals("(") || symbol_To_add.equals(")")) {
                if (textView.getText().length() < 50) {
                    stringBuilder.append(symbol_To_add);
                    textView.setText(stringBuilder);
                }
            }

        }
    }



//    public void Doriv(View view) {
//        try {
//            StringBuilder dec = new StringBuilder(String.valueOf(Calculator.decide(stringBuilder.toString())));
//            char symbol_1 = dec.charAt(dec.length()-1);
//            char symbol_2 = dec.charAt(dec.length()-2);
//
//            if (dec.toString().equals("0.0")) {
//                dec.setLength(0);
//                mShowRes.setText(dec.toString());
//                return;
//            }
//
//
//            if (symbol_1 == '0' && symbol_2 == '.' && !dec.toString().equals("0.0")) {

//            stringBuilder.setLength(0);
//
//            stringBuilder.append(Math.round(Double.parseDouble(dec.toString())));
//            mShowRes.setText(stringBuilder.toString());
//        } catch (StringIndexOutOfBoundsException | EmptyStackException | NumberFormatException e) {
//            mShowRes.setText(stringBuilder);}
//
//
//    }











