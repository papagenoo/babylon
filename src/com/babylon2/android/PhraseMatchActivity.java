package com.babylon.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.babylon.R;
import com.babylon.android.layout.PredicateLayout;
import com.babylon.core.PhraseParserTransaction;
import com.babylon.core.PhraseWithVariants;
import com.babylon.core.TranslationDatabase;

import java.util.Arrays;
import java.util.List;

public class PhraseMatchActivity extends Activity implements View.OnClickListener {
    //

    TextView questionTextView;
    String original;
    String translation;
    List<List<String>> variants;
    PredicateLayout variantButtonsLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase_translate);

        fillDb();

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        variantButtonsLayout = (PredicateLayout) findViewById(R.id.variant_buttons_layout);

        original = "Я тебя люблю";

        questionTextView.setText(original);

        PhraseWithVariants pwv = TranslationDatabase.getPhraseWithVariants(original);
        original = pwv.getOriginal();
        translation = pwv.getTranslation();
        variants = pwv.getVariants();

        List<String> words = variants.get(0);

        for (String word : words) {
            Button button = new Button(this);
            button.setText(word);
            variantButtonsLayout.addView(button, new PredicateLayout.LayoutParams(2, 0));
        }


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

    private void fillDb() {
        addPhrase("Я тебя люблю ; Ich liebe dich ; Ich|Du|Ihr + liebe|lieben|liebst|liebt + dich|mich|du");
    }

    private void addPhrase(String src) {
        PhraseParserTransaction parser = new PhraseParserTransaction(src);
        try {
            parser.execute();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
