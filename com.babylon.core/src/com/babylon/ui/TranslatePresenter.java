package com.babylon.ui;

import com.babylon.core.Lang;
import com.babylon.core.Translations;
import com.babylon.core.TranslationsDatabase;

/**
 * Created by max on 21/04/14.
 */
public class TranslatePresenter {
    enum InnerState {
        Original,
        Translation
    }

    enum Event {
        Prev,
        Next
    }

    enum OuterState {
        Start,
        Middle,
        End,
        StartEnd
    }


    private TranslateView view;
    private TranslationsDatabase database;
    Translations translations = new Translations(Lang.RU, Lang.DE);

    public TranslatePresenter(TranslateView view,
                              TranslationsDatabase database)
    {
        this.view = view;
        this.database = database;
    }

    InnerState innerState = InnerState.Original;
    OuterState outerState = OuterState.Start;

    public void handle(Event event) {
        switch (outerState) {
            case Start:
                switch (event) {
                    case Prev:

                        view.disablePrevBtn();

                        break;
                    case Next:
                        view.enablePrevBtn();
                        break;
                }
                break;
            case Middle:
                switch (event) {
                    case Prev:
                        break;
                    case Next:
                        break;
                }
                break;
            case End:
                switch (event) {
                    case Prev:
                        break;
                    case Next:
                        break;
                }
                break;
            case StartEnd:
                switch (event) {
                    case Prev:
                        break;
                    case Next:
                        break;
                }
                break;
        }

        switch (innerState) {
            case Original:
                switch (event) {
//                    case Prev:
//                        innerState = InnerState.Original;
//                        translations.prev();
//                        view.setOriginal(translations.getOriginal());
//                        view.setTranslation("");
//                        break;
                    case Next:
                        innerState = InnerState.Translation;
                        view.setOriginal(translations.getOriginal());
                        view.setTranslation("");
                        break;
                }
                break;
            case Translation:
                switch (event) {
//                    case Prev:
//                        innerState = InnerState.Original;
//                        translations.prev();
//                        view.setOriginal(translations.getOriginal());
//                        view.setTranslation("");
//                        break;
                    case Next:
                        innerState = InnerState.Original;
                        view.setTranslation(translations.getTranslation());
                        translations.next();
                        break;
                }
                break;
        }
    }

}
