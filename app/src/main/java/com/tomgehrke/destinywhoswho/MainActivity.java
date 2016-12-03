package com.tomgehrke.destinywhoswho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int questionCount = 0;
    public int correctCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View v) {
        // Reset counters in case answers are submitted multiple times
        correctCount = 0;
        questionCount = 0;

        if (quizComplete()) {
            if (questionCount == correctCount) {
                String guardianName = ((EditText) findViewById(R.id.answer10_edittext)).getText().toString().toUpperCase();
                Toast.makeText(getBaseContext(), getString(R.string.perfect_score, guardianName), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), getString(R.string.quiz_score, correctCount, questionCount), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getBaseContext(), getString(R.string.complete_quiz_request), Toast.LENGTH_LONG).show();
        }
    }

    private boolean quizComplete() {
        boolean isComplete = checkQuestion01();
        if (isComplete) {isComplete = checkQuestion02();}
        if (isComplete) {isComplete = checkQuestion03();}
        if (isComplete) {isComplete = checkQuestion04();}
        if (isComplete) {isComplete = checkQuestion05();}
        if (isComplete) {isComplete = checkQuestion06();}
        if (isComplete) {isComplete = checkQuestion07();}
        if (isComplete) {isComplete = checkQuestion08();}
        if (isComplete) {isComplete = checkQuestion09();}
        if (isComplete) {isComplete = checkQuestion10();}

        return isComplete;
    }

    private boolean checkQuestion01() {
        EditText answerEditText = (EditText) findViewById(R.id.answer01_edittext);
        final String answer = answerEditText.getText().toString();

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.toLowerCase().equals(getString(R.string.answer_01).toLowerCase())) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion02() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer02_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_02))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion03() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer03_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_03))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion04() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer04_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_04))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion05() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer05_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_05))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion06() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer06_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_06))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion07() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer07_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_07))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion08() {
        // No checks for whether this question is answered since no checkboxes checked would
        // be a valid response if allow the possibility that this is a trick question.

        boolean correctAnswer = true;
        int checkedItemsCount = 0;

        // Build array of checkboxes associated with this answer
        final String[] answer08Checkboxes = {"answer08a_checkbox","answer08b_checkbox","answer08c_checkbox","answer08d_checkbox","answer08e_checkbox"
                ,"answer08f_checkbox","answer08g_checkbox","answer08h_checkbox","answer08i_checkbox","answer08j_checkbox"};

        // Iterate through array, finding each resource ID, and then check for correctness
        for (String answer08Checkbox : answer08Checkboxes) {
            int checkboxID = getResources().getIdentifier(answer08Checkbox,"id",getPackageName());

            if ( ((CheckBox)findViewById(checkboxID)).isChecked()) {
                checkedItemsCount += 1;
                if (!getString(R.string.answer_08).toLowerCase().contains(((CheckBox) findViewById(checkboxID)).getText().toString().toLowerCase())) {
                    correctAnswer = false;
                    break;
                }
            }
        }

        questionCount += 1;

        if (correctAnswer && checkedItemsCount == getString(R.string.answer_08).split(",").length) {
            correctCount += 1;
        }

        return true;
    }

    private boolean checkQuestion09() {
        String answer = "";

        RadioGroup answerRadioGroup = (RadioGroup) findViewById(R.id.answer09_radiogroup);
        if ( answerRadioGroup.getCheckedRadioButtonId() != -1 ) {
            answer = ((RadioButton) findViewById(answerRadioGroup.getCheckedRadioButtonId())).getText().toString();
        }

        if (answer.isEmpty()) {
            return false;
        } else {
            questionCount += 1;

            if (answer.equals(getString(R.string.answer_09))) {
                correctCount += 1;
            }
        }

        return true;
    }

    private boolean checkQuestion10() {
        if (((EditText) findViewById(R.id.answer10_edittext)).getText().toString().isEmpty()) {
            return false;
        } else {
            // As long as they entered *something* they'll get at least one answer correct
            questionCount += 1;
            correctCount += 1;
        }

        return true;
    }
}
