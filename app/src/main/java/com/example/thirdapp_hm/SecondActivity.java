package com.example.thirdapp_hm;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

public class SecondActivity extends AppCompatActivity {

    String[] type = {"One", "Two", "Three"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterTypes;


    ImageView btnFav;
    boolean isFav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        autoCompleteTextView = findViewById(R.id.auto_complete_text);
        adapterTypes = new ArrayAdapter<String>(this, R.layout.list_items, type);
        autoCompleteTextView.setAdapter(adapterTypes);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String type = adapterView.getItemAtPosition(i).toString();
                autoCompleteTextView.setHint("");
                Toast.makeText(SecondActivity.this, "Type: " + type, Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.btn_next).setOnClickListener(view -> {
            finishAffinity();
        });

        btnFav = findViewById(R.id.btn_fav);
        btnFav.setOnClickListener(v -> {
            isFav = !isFav;
            if (isFav) {
                btnFav.setImageResource(R.drawable.ic_heart);
            } else {
                btnFav.setImageResource(R.drawable.ic_heart_f);
            }
        });


        int sumResult = getIntent().getIntExtra("SUM_RESULT", 0);
        TextView resultTextView = findViewById(R.id.result_sum);
        resultTextView.setText(String.valueOf(sumResult));
    }
}