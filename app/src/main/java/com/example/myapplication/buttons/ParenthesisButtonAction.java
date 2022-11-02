package com.example.myapplication.buttons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.buttons.ButtonAction;

public class ParenthesisButtonAction implements ButtonAction {
    @Override
    public void action(TextView textView, View view) {
        Button butt = (Button) view;
        String text = (String) butt.getText();
        if (textView.getText() == null) {
            textView.setText(text);
        } else {
            String text2 = (String) textView.getText() + text;
            textView.setText(text2);
        }
    }
}