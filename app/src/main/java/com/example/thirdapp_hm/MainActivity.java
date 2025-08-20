package com.example.thirdapp_hm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {



    private TextView textView;
    private Button button;
    private int a, b;
    private boolean isOperationClick;
    private boolean isPlusClick;
    private boolean isMinusClick;
    private boolean isMulClick;
    private boolean isDivClick;
    private boolean isEqualClick;

    private int sumResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.btn_show_res);
        button.setVisibility(View.GONE);

        initListeners();



        findViewById(R.id.btn_show_res).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("SUM_RESULT", sumResult);
            startActivity(intent);
        });
    }

    private void initListeners() {
        findViewById(R.id.btn_dot).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_zero).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_one).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_two).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_three).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_four).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_five).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_six).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_seven).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_eight).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_nine).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_clear).setOnClickListener(this::onNumberClick);

        findViewById(R.id.btn_plus).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btn_minus).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btn_multiplication).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btn_division).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btn_equal).setOnClickListener(this::onOperationClick);
    }

    private void onNumberClick(View view){
        String text = ((MaterialButton) view).getText().toString();
        if(text.equals("AC")){
            textView.setText("0");
            a = 0;
            b = 0;
            isPlusClick = false;
            isMinusClick = false;
            isMulClick = false;
            isDivClick = false;
        } else if (textView.getText().toString().equals("0") || isOperationClick){
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
        button.setVisibility(View.GONE);

    }

    private void onOperationClick(View view){
        if(view.getId() == R.id.btn_plus){
            a = Integer.parseInt(textView.getText().toString());
            isPlusClick = true;
            button.setVisibility(View.GONE);
        } else if(view.getId() == R.id.btn_minus){
            a = Integer.parseInt(textView.getText().toString());
            isMinusClick = true;
            button.setVisibility(View.GONE);
        } else if (view.getId() == R.id.btn_multiplication) {
            a = Integer.parseInt(textView.getText().toString());
            isMulClick = true;
            button.setVisibility(View.GONE);
        } else if (view.getId() == R.id.btn_division) {
            a = Integer.parseInt(textView.getText().toString());
            isDivClick = true;
            button.setVisibility(View.GONE);
        } else if(view.getId() == R.id.btn_equal && isPlusClick) {
            b = Integer.parseInt(textView.getText().toString());
            int result = a + b;
            sumResult = result;
            textView.setText(String.valueOf(result));
            button.setVisibility(View.VISIBLE);
        } else if(view.getId() == R.id.btn_equal && isMinusClick) {
            b = Integer.parseInt(textView.getText().toString());
            int result = a - b;
            sumResult = result;
            textView.setText(String.valueOf(result));
            button.setVisibility(View.VISIBLE);
        } else if(view.getId() == R.id.btn_equal && isMulClick) {
            b = Integer.parseInt(textView.getText().toString());
            int result = a * b;
            sumResult = result;
            textView.setText(String.valueOf(result));
            button.setVisibility(View.VISIBLE);
        } else if(view.getId() == R.id.btn_equal && isDivClick) {
            b = Integer.parseInt(textView.getText().toString());
            int result = a / b;
            sumResult = result;
            textView.setText(String.valueOf(result));
            button.setVisibility(View.VISIBLE);
        }
        isOperationClick = true;
    }

}