package com.babylon.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.babylon.R;
import com.babylon.core.Lang;
import com.babylon.core.Translations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.babylon.android.MainActivity.State.Original;
import static com.babylon.android.MainActivity.State.Translation;

public class MainActivity extends Activity {

    enum State {
        Original, Translation
    }

    enum Event {
        Next
    }


    Translations translations = new Translations(Lang.RU, Lang.DE);
    TextView originalTextView;
    TextView translationTextView;
    Button nextButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        originalTextView = (TextView) findViewById(R.id.originalTextView);
        translationTextView = (TextView) findViewById(R.id.translationTextView);
        nextButton = (Button) findViewById(R.id.nextButton);

        next();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
    }

    State state = Original;

    public void next() {
        switch (state) {
            case Original:
                state = Translation;
                originalTextView.setText(translations.getOriginal());
                translationTextView.setText("");
                break;
            case Translation:
                state = Original;
                translationTextView.setText(translations.getTranslation());
                translations.next();
                break;
        }
    }
}
