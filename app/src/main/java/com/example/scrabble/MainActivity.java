package com.example.scrabble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        switch (view.getId()) {
            case (R.id.btnStart):
                intent.putExtra(getString(R.string.mode), 1);
                break;
            case (R.id.btnStartCmp):
                intent.putExtra(getString(R.string.mode), 2);
                break;
            case (R.id.btnCont):
                intent.putExtra(getString(R.string.mode), 3);
                break;
        }
        startActivity(intent);
    }
}