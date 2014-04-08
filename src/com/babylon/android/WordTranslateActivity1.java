package com.babylon.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.babylon.android.layout.PredicateLayout;
import com.babylon.core.Words;

public class WordTranslateActivity1 extends Activity {

    TextView questionTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.word_translate);

//        questionTextView = (TextView) findViewById(R.id.questionTextView);
//        questionTextView.setText("он делает");

        Words words = new Words();
        words.add("делать");
        words.add("любить");

        PredicateLayout l = new PredicateLayout(this);
        for (int i = 0; i < 10; i++) {
            Button button = new Button(this);
            button.setText(words.next());
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
}
