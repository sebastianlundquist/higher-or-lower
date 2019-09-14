package com.sebastianlundquist.higherorlower;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand;
    int randomNumber;

    public void generateRandomNumber() {
        rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void guessNumber(View view) {
        EditText enterNumber = findViewById(R.id.enterNumber);
        try {
            int number = Integer.parseInt(enterNumber.getText().toString());
            String message;
            if (number == randomNumber) {
                message = "Correct! Try again!";
                generateRandomNumber();
            }
            else if (number < randomNumber) {
                message = "Higher!";
            }
            else {
                message = "Lower!";
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            enterNumber.getText().clear();
        }
        catch (Exception e) {
            Toast.makeText(this, "Enter a valid number!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        generateRandomNumber();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
