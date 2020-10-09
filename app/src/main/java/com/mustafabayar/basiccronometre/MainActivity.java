package com.mustafabayar.basiccronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler;
    Runnable runnable;
    int number=0;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.button);
    }
    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : " + number );
                number++;
                textView.setText("Time : " + number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time : " + number);
        number = 0;
        Toast.makeText(getApplicationContext(),"Sıfırlandı!",Toast.LENGTH_LONG).show();
    }
}