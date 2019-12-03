package com.letsandroid.lesson2_uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 1 pressed", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 2 pressed", Toast.LENGTH_LONG).show();
            }
        });

        ((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(buttonView,
                        "Checkbox is " + (isChecked ? "CHECKED" : "UNCHECKED"),
                        Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        ((Switch) findViewById(R.id.switch1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(buttonView,
                        "Switch is " + (isChecked ? "CHECKED" : "UNCHECKED"),
                        Snackbar.LENGTH_SHORT).show();
            }
        });

        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        findViewById(R.id.buttonClearText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Text ///" + editText.getText().toString() + "/// will be cleared",
                        Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        Toast.makeText(MainActivity.this,
                                "Radio (1) selected",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this,
                                "Radio (2) selected",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
