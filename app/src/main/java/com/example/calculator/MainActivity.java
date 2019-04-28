package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.udojava.evalex.Expression;
import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    // Initialise Values
    private TextView Screen;
    private String Display = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the answer area and allow it to be edited
        Screen = findViewById(R.id.resultAreaTextView);
        Screen.setText(Display);
    }

    // Updates the answer area with whatever is in Display
    private void updateScreen(){
        Screen.setText(Display);
    }

    // Updates Display with the text of the button
    protected void onClickNumber(View V){
        Button b = (Button) V;
        Display += b.getText();
        updateScreen();
    }

    // Clears Display and updates it
    protected void onClickClear(View V){
        String clear = "";
        Display = clear;
        updateScreen();
    }

    // Uses EvalEx to calculate the current equation
    protected void onClickEqual(View V) {
        BigDecimal result;
        // Replace unicode with their math equivalents
        String Display1= Display.replace("\u00F7","/");
        String Display2= Display1.replace("\u00D7","*");
        Expression expression = new Expression(Display2);
        result = expression.eval();
        String DisplayResult = result.toString();
        Display = DisplayResult;
        updateScreen();
    }

}



