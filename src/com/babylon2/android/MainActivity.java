package com.babylon.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.babylon.R;

public class MainActivity extends Activity {

    TextView questionTextView;
    EditText answerEditText;
    Button applyButton;

    String[] pronounsRu = {
            "я", "ты", "он", "она", "оно",
            "мы", "вы", "они", "Вы"
    };

    String[] pronounsGr = {
            "ich", "du", "er", "sie", "es",
            "wir", "ihr", "sie", "Sie"
    };

    String[] questions = {
            "он делает",
            "он делает",
            "он делает",
            "он делает",
    };

    interface VerbConjugations {
        public String get(int person, int counter);
    }

    class RussianVerbConjugations implements VerbConjugations {
        public RussianVerbConjugations(String firstSingular,
                                       String secondSingular,
                                       String thirdSingular,
                                       String firstPlural,
                                       String secondPlural,
                                       String thirdPlural) {

        }

        public String get(int person, int counter) {
            return "";
        }
    }

    /*
    я делаю    1s  1
    ты делаешь 2s  2
    он делает  3s  3
    она делает 3s  3
    оно делает 3s  3
    мы делаем  1p  4
    вы делаете 2p  5
    они делают 3p  6
    Вы делаете 2sr 5 (2-е лицо, single, respectful)
     */

    /*
    ich mache  1s  1
    du machst  2s  2
    er macht   3s  3
    sie macht  3s  3
    es macht   3s  3
    wir machen 1p  4
    ihr macht  2p  3
    sie machen 3p  4
    Sie machen 2sr 4
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        applyButton = (Button) findViewById(R.id.applyButton);



        questionTextView.setText("он делает");

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoWordsActivity();
//                String answer = answerEditText.getText().toString();
//                String rightMessage = MainActivity.this.getString(R.string.right_message);
//                String wrongMessage = MainActivity.this.getString(R.string.wrong_message);
//                String message = wrongMessage;
//
//                if (answer.equals("er macht")) {
//                    message = rightMessage;
//                }
//
//                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void gotoWordsActivity() {
        Intent i = new Intent(this, PhraseMatchActivity.class);
        startActivity(i);

    }
}
