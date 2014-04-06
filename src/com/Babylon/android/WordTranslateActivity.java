package com.babylon.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.babylon.R;
import com.babylon.android.layout.PredicateLayout;
import com.babylon.core.Words;

public class WordTranslateActivity extends Activity implements View.OnClickListener {

    TextView questionTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.word_translate);

//        questionTextView = (TextView) findViewById(R.id.questionTextView);
//        questionTextView.setText("он делает");

//        Words words = new Words();
//        words.add("делать");
//        words.add("любить");

        String[] words = new String[] {
                "делать",
                "любить",
                "спрашивать",
                "отвечать"
        };


        PredicateLayout l = new PredicateLayout(this);
        for (int i = 0; i < words.length; i++) {
            Button button = new Button(this);
            button.setText(words[i]);
            l.addView(button, new PredicateLayout.LayoutParams(2, 0));
        }

        setContentView(l);

        /*applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = answerEditText.getText().toString();
                String rightMessage = WordTranslateActivity.this.getString(R.string.right_message);
                String wrongMessage = WordTranslateActivity.this.getString(R.string.wrong_message);
                String message = wrongMessage;

                if (answer.equals("er macht")) {
                    message = rightMessage;
                }

                Toast.makeText(WordTranslateActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public void onClick(View view) {

    }
}
