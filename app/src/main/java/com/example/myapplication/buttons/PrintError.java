package com.example.myapplication.buttons;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.buttons.ButtonAction;

public class PrintError implements ButtonAction {

    @Override
    public void action(TextView textView, View view) {
        String text = (String) textView.getText();
        text = text.contains("=Ошибка") ? text : text + "=Ошибка";
        textView.setText(text);
    }

}
