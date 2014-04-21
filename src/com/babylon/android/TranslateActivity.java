package com.babylon.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.babylon.R;
import com.babylon.core.InMemoryTranslationsDatabase;
import com.babylon.ui.TranslatePresenter;
import com.babylon.ui.TranslateView;

public class TranslateActivity extends Activity implements TranslateView {
    TranslatePresenter presenter = new TranslatePresenter(this, new InMemoryTranslationsDatabase());

    TextView originalTextView;
    TextView translationTextView;
    Button nextButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        originalTextView = (TextView) findViewById(R.id.originalTextView);
        translationTextView = (TextView) findViewById(R.id.translationTextView);
        nextButton = (Button) findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.next();
            }
        });
    }

    @Override
    public void setOriginal(String original) {
        originalTextView.setText(original);
    }

    @Override
    public void setTranslation(String translation) {
        translationTextView.setText(translation);
    }

    @Override
    public void disablePrevBtn() {
        nextButton.setEnabled(false);
    }

    @Override
    public void enablePrevBtn() {
        nextButton.setEnabled(true);
    }
}
