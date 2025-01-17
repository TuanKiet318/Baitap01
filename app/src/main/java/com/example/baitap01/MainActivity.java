package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    private TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100) + 1;
            numbers.add(randomNumber);
        }

        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }


        Log.d("OddNumbers", "Số lẻ: " + oddNumbers.toString());

        Log.d("EvenNumbers", "Số chẵn: " + evenNumbers.toString());

        editTextInput = findViewById(R.id.editTextInput);
        textViewOutput = findViewById(R.id.textViewOutput);
        Button buttonProcess = findViewById(R.id.buttonProcess);

        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();

                // Hiển thị chuỗi ban đầu trong TextView
                textViewOutput.setText(inputText);

                // Đảo ngược chuỗi và in hoa
                String reversedText = reverseAndUpperCase(inputText);

                // Hiển thị chuỗi đảo ngược và in hoa trong Toast
                Toast.makeText(MainActivity.this, reversedText, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private String reverseAndUpperCase(String text) {
        if (text.isEmpty()) {
            return "";
        }

        String[] words = text.split(" ");
        StringBuilder reversedText = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedText.append(words[i]).append(" ");
        }

        return reversedText.toString().trim().toUpperCase();
    }
}