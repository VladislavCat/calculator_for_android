package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.buttons.BackspaceButtonAction;
import com.example.myapplication.buttons.ButtonAction;
import com.example.myapplication.buttons.EqualsButtonAction;
import com.example.myapplication.buttons.NumbersButtonAction;
import com.example.myapplication.buttons.OperationButtonAction;
import com.example.myapplication.buttons.ParenthesisButtonAction;
import com.example.myapplication.buttons.SqrtButtonAction;
import com.example.myapplication.calculation.LogicPriority;


public class MainActivity extends AppCompatActivity {
        private TextView textView;
        LogicPriority l;
        String text;
        private boolean operationSymbol;
        private boolean numberSymbol;
        private boolean sqrtSymbol;
        private boolean negativeNumber;
        private boolean openParentOn;
        ButtonAction nba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewCalc);
        l = new LogicPriority();
        operationSymbol = false;
        numberSymbol = true;
        openParentOn = false;
        text = (String) textView.getText();
        negativeNumber = true;
        sqrtSymbol = true;
    }

    public void clickOnNumber(View view) {
        nba = new NumbersButtonAction();
        if(numberSymbol) {
            nba.action(textView, view);
            operationSymbol = true;
        }
    }

    public void clickOnArithmeticOperation(View view){
        nba = new OperationButtonAction();
        Button button = (Button) view;
        text = (String) textView.getText();
        negativeNumber = (text.length() >= 1 && CheckElement.checkOperation(text.charAt(text.length() - 1))
                && (!CheckElement.checkOperation(text.charAt(text.length()-2))));
        if(operationSymbol || (text.length() == 0 && "-".equals(button.getText()))
                || negativeNumber){
            nba.action(textView, view);
            operationSymbol = false;
            sqrtSymbol = true;
        }
    }

    public void clickOnEqualsButt(View view){
        nba = new EqualsButtonAction();
        nba.action(textView, view);
        operationSymbol = false;
        numberSymbol = false;
    }

    public void clickOnDeleteButton(View view){
        textView.setText(null);
        operationSymbol = false;
        numberSymbol = true;
        sqrtSymbol = true;
    }

    public void clickOnBackSpaceButton(View view){
        nba = new BackspaceButtonAction();
        nba.action(textView, view);
        if(!(textView.getText().length() == 0)) {
            operationSymbol = BackspaceButtonAction.getFlags(textView);
        }
        numberSymbol = true;
    }

    public void clickOnOpenParenthesisButton(View view){
        nba = new ParenthesisButtonAction();
        if(!operationSymbol) {
            nba.action(textView, view);
            openParentOn = true;
        }
    }

    public void clickOnCloseParenthesisButton(View view) {
        nba = new ParenthesisButtonAction();
        if(openParentOn) {
            nba.action(textView, view);
        }
    }
}