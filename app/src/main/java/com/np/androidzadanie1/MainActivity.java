package com.np.androidzadanie1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.np.androidzadanie1.entity.Question;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "Quiz";
    public static final String KEY_CURRENT_INDEX = "currentIndex";

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;
    private Question[] questions = new Question[] {
        new Question(R.string.q_activity, true),
        new Question(R.string.q_find_resources, false),
        new Question(R.string.q_listener, true),
        new Question(R.string.q_resources, true),
        new Question(R.string.q_version, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        }

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(view -> checkAnswerCorrectness(true));
        falseButton.setOnClickListener(view -> checkAnswerCorrectness(false));
        nextButton.setOnClickListener(view -> {
            currentQuestionIndex = (++currentQuestionIndex) % questions.length;
            setNextQuestion();
        });
        setNextQuestion();

        Log.d(LOG_TAG, "Została wywołana metoda onCreate()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "Została wywołana metoda onSaveInstanceState()");
        outState.putInt(KEY_CURRENT_INDEX, currentQuestionIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOG_TAG, "Została wywołana metoda onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(LOG_TAG, "Została wywołana metoda onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "Została wywołana metoda onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LOG_TAG, "Została wywołana metoda onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "Została wywołana metoda onResume()");
    }



    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentQuestionIndex].isTrueAnswer();
        int resultMessageId = 0;
        if(userAnswer == correctAnswer) {
            resultMessageId = R.string.correct_answer;
        }
        else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        questionTextView.setText(questions[currentQuestionIndex].getId());
    }
}