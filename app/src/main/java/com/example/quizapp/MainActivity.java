package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean isCorrect1 = false;
    boolean isCorrect2 = false;
    boolean isCorrect3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    /**
     * Handle the click event for the first radio button
     */
    public void firstOnRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.correct_answer_q1:
                if (checked)
                    isCorrect1 = true;
                // Go to next question
                break;
            default:
                isCorrect1 = false;
                // Go to next question
                break;
        }


    }

    /**
     * Handle the click event for the second radio button
     */
    public void secondOnRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.correct_answer_q2:
                if (checked)
                    isCorrect2 = true;
                // Go to next question
                break;
            default:
                    isCorrect2 = false;
                // Go to next question
                break;
        }

    }

    /**
     * Handle the click event for the third radio button
     */
    public void thirdOnRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.correct_answer_q3:
                if (checked)
                    isCorrect3 = true;
                // Go to next question
                break;
            default:
                if (checked)
                    isCorrect3 = false;
                // Go to next question
                break;
        }


    }


    /**
     * Check which answers are correct and add 1 point to the score for every correct
     * answer
     */

    public void showScore(View view) {
        int score = 0;

        if (isCorrect1) {
            score++;
        }

        if (isCorrect2) {
            score++;
        }

        if (isCorrect3) {
            score++;
        }

        CheckBox isSedimentary = (CheckBox) findViewById(R.id.answer1_q4);
        boolean correct1_q4 = isSedimentary.isChecked();

        CheckBox isOil = (CheckBox) findViewById(R.id.answer2_q4);
        boolean incorrect_q4 = isOil.isChecked();

        CheckBox isIgneous = (CheckBox) findViewById(R.id.answer3_q4);
        boolean correct2_q4 = isIgneous.isChecked();

        CheckBox isMetamorphic = (CheckBox) findViewById(R.id.answer4_q4);
        boolean correct3_q4 = isMetamorphic.isChecked();

        if (correct1_q4 && correct2_q4 && correct3_q4 && !incorrect_q4) {
            score++;
        }

        EditText question5 = (EditText) findViewById(R.id.answer5_text_input);
        String answerQuestion5 = question5.getText().toString();

        if (answerQuestion5.equalsIgnoreCase("Crust")) {
            score++;
        }

        //Get user name from the Edit Text and store it in a variable
        EditText userName = (EditText) findViewById(R.id.name_text_input);
        String name = userName.getText().toString();


        //Display the final score using a Toast
        if (score == 5) {
            CharSequence text = "Congratulations " + name + " ,your score is: " + score + "/5.";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        } else {
            CharSequence text = "Try again " + name + " ,your score is: " + score + "/5.";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }
    }

}
