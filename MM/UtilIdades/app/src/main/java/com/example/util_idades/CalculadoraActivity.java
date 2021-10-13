package com.example.util_idades;


import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText usersInputBox;
    private ImageButton backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora2);
        setupUI();


        //clear all text in users input
        usersInputBox.setText("");
    }

    @Override
    public void onClick(View view) {

        int pos;

        switch (view.getId()){

            case (R.id.backspace):
                //gets the cursors position
                int cursorPosEnd = usersInputBox.getSelectionEnd();
                int textLength = usersInputBox.getText().length();

                if (cursorPosEnd != 0 && textLength != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) usersInputBox.getText();
                    selection.replace(cursorPosEnd - 1, cursorPosEnd, "");
                    //updates the text
                    usersInputBox.setText(selection);
                    //puts the cursor back in the correct spot
                    usersInputBox.setSelection(cursorPosEnd - 1);
                }
                break;

            case (R.id.zero):
                pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("0", usersInputBox.getText().toString(), pos));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.one):
                pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("1", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.two):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("2", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.three):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("3", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.four):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("4", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.five):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("5", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.six):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("6", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.seven):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("7", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.eight):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("8", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.nine):
                 pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("9", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
                break;

            case (R.id.clear):
                usersInputBox.setText("");
                break;

           case (R.id.exponent):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("^", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.plusMinus):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("-", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.point):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText(".", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.equals):
               String expression = usersInputBox.getText().toString();

               expression = expression.replaceAll("÷", "/");
               expression = expression.replaceAll("×", "*");

               Expression exp = new Expression(expression);

               String result = String.valueOf(exp.calculate());

               usersInputBox.setText(result);
               usersInputBox.setSelection(result.length());
                break;

           case (R.id.divide):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("÷", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.multiply):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("×", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.minus):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("-", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.add):
                pos = usersInputBox.getSelectionStart();
               usersInputBox.setText(updateText("+", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               usersInputBox.setSelection(pos + 1);
                break;

           case (R.id.parentheses):
               pos = usersInputBox.getSelectionStart();
               int openPar = 0;
               int closedPar = 0;
               int inboxLength = usersInputBox.getText().toString().length();

               for (int i = 0; i < usersInputBox.getSelectionStart(); i++){
                   if (usersInputBox.getText().toString().substring(i, i+1).equals("(")){
                       openPar += 1;
                   }
                   else if (usersInputBox.getText().toString().substring(i, i+1).equals(")")){
                       closedPar += 1;
                   }
               }

               if (openPar == closedPar || usersInputBox.getText().toString().substring(
                       inboxLength - 1, inboxLength).equals("(")){
                   //usersInputBox.setText(String.format("%s%s", usersInputBox.getText().toString(), "("));
                   usersInputBox.setText(updateText("(", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               }
               else if (closedPar < openPar && !usersInputBox.getText().toString().substring(
                       inboxLength - 1, inboxLength).equals("(")){
                   //usersInputBox.setText(String.format("%s%s", usersInputBox.getText().toString(), ")"));
                   usersInputBox.setText(updateText(")", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
               }
               usersInputBox.setSelection(pos + 1);
                break;



        }

    }

    private void setupUI(){

        //sets up the user interface views
        usersInputBox = findViewById(R.id.textView);
        //usersInputBox.setShowSoftInputOnFocus(false);   //used to prevent the users keyboard from popping up but keeps the carrot

        backspace = findViewById(R.id.backspace);
        Button btnClear = findViewById(R.id.clear);
        Button btnPar = findViewById(R.id.parentheses);
        Button btnExponent = findViewById(R.id.exponent);
        Button btnDivide = findViewById(R.id.divide);
        Button btnSeven = findViewById(R.id.seven);
        Button btnEight = findViewById(R.id.eight);
        Button btnNine = findViewById(R.id.nine);
        Button btnMultiply = findViewById(R.id.multiply);
        Button btnFour = findViewById(R.id.four);
        Button btnFive = findViewById(R.id.five);
        Button btnSix = findViewById(R.id.six);
        Button btnMinus = findViewById(R.id.minus);
        Button btnOne = findViewById(R.id.one);
        Button btnTwo = findViewById(R.id.two);
        Button btnThree = findViewById(R.id.three);
        Button btnPlus = findViewById(R.id.add);
        Button btnPlus_Minus = findViewById(R.id.plusMinus);
        Button btnZero = findViewById(R.id.zero);
        Button btnDecimal = findViewById(R.id.point);
        Button btnEqual = findViewById(R.id.equals);

        backspace.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnPar.setOnClickListener(this);
        btnExponent.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnPlus_Minus.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnEqual.setOnClickListener(this);



    }

    private String updateText(String stringToAdd, String oldString, int cursorPos){
        String leftOfCursor = oldString.substring(0, cursorPos);
        String rightOfCursor = oldString.substring(cursorPos);

        return leftOfCursor + stringToAdd + rightOfCursor;

    }


}