package ru.great_larder.sportquiz.database.repository.impl;

import android.content.Context;
import ru.great_larder.sportquiz.database.repository.GetQuestion;
import ru.great_larder.sportquiz.database.repository.get_live.*;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.*;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionBiology;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.question.*;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(Context context, String nameQuiz, String nameCity) {
        if (nameQuiz.equals("Biology")) {
            return new ArrayList<>(ListBiologyLoad.getQuestionList());
        }
        if (nameQuiz.equals("History")) {
            return new ArrayList<>(ListHistoryLoad.getQuestionList());
        }
        if (nameQuiz.equals("Geography")) {
            return new ArrayList<>(ListGeographyLoad.getQuestionList());
        }
        if (nameQuiz.equals("Physics")) {
            return new ArrayList<>(ListPhysicsLoad.getQuestionList());
        }
        if (nameQuiz.equals("Mathematics")) {
            return new ArrayList<>(ListMathematicsLoad.getQuestionList());
        }
        if (nameQuiz.equals("Sports")) {
            return new ArrayList<>(ListSportsLoad.getQuestionList());
        }
        if (nameQuiz.equals("Russian language")) {
            return new ArrayList<>(ListRuLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals("English language")) {
            return new ArrayList<>(ListEnLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals("Traffic Laws")) {
            return new ArrayList<>(ListTrafficLawsLoad.getQuestionList());
        }
        if (nameQuiz.equals("Etiquette Business")) {
            return new ArrayList<>(ListEtiquetteBusinessLoad.getQuestionList());
        }
        if (nameQuiz.equals("Etiquette Secular")) {
            return new ArrayList<>(ListEtiquetteSecularLoad.getQuestionList());
        }
        if (nameQuiz.equals("City")) {
            List<Question> questionCityes = new ArrayList<>(ListCityLoad.getQuestionList());
            List<Question> result = new ArrayList<>();
            if (nameCity != null) {
                for (Question s : questionCityes){
                    if(nameCity.equals(((QuestionCity)s).getCity())) result.add(s);
                }
            }
            return result;
        }
        return null;
    }
}
