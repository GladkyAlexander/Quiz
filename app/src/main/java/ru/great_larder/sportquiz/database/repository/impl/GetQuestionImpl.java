package ru.great_larder.sportquiz.database.repository.impl;

import android.content.Context;
import ru.great_larder.sportquiz.database.repository.GetQuestion;
import ru.great_larder.sportquiz.database.repository.get_live.*;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.services.NameQuestion;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(Context context, String nameQuiz, String nameCity) {
        if (nameQuiz.equals(NameQuestion.BIOLOGY)) {
            return new ArrayList<>(ListBiologyLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.HISTORY)) {
            return new ArrayList<>(ListHistoryLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.GEOGRAPHY)) {
            return new ArrayList<>(ListGeographyLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.PHYSICS)) {
            return new ArrayList<>(ListPhysicsLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.MATHEMATICS)) {
            return new ArrayList<>(ListMathematicsLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.SOCIAL_STUDIES)) {
            return new ArrayList<>(ListSocialStudiesLoad.getQuestionList());
        }
        
        if (nameQuiz.equals(NameQuestion.SPORTS)) {
            return new ArrayList<>(ListSportsLoad.getQuestionList());
        }
        
        if (nameQuiz.equals(NameQuestion.RUSSIAN_LANGUAGE)) {
            return new ArrayList<>(ListRuLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.ENGLISH_LANGUAGE)) {
            return new ArrayList<>(ListEnLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.BASHKIR_LANGUAGE)) {
            return new ArrayList<>(ListBashkirLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.CHUVASH_LANGUAGE)) {
            return new ArrayList<>(ListChuvashLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.CHECHEN_LANGUAGE)) {
            return new ArrayList<>(ListChechenLanguageLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.TATAR_LANGUAGE)) {
            return new ArrayList<>(ListTatarLanguageLoad.getQuestionList());
        }
        
        if (nameQuiz.equals(NameQuestion.ETIQUETTE_BUSINESS)) {
            return new ArrayList<>(ListEtiquetteBusinessLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.ETIQUETTE_SECULAR)) {
            return new ArrayList<>(ListEtiquetteSecularLoad.getQuestionList());
        }
        
        if (nameQuiz.equals(NameQuestion.CITY)) {
            List<Question> questionCities = new ArrayList<>(ListCityLoad.getQuestionList());
            List<Question> result = new ArrayList<>();
            if (nameCity != null) {
                for (Question s : questionCities){
                    if(nameCity.equals(((QuestionCity)s).getCity())) result.add(s);
                }
            }
            return result;
        }
        
        if (nameQuiz.equals(NameQuestion.RAILWAY_TRANSPORT)) {
            return new ArrayList<>(ListRailwayTransportLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.ROAD_TRANSPORT)) {
            return new ArrayList<>(ListRoadTransportLoad.getQuestionList());
        }
        if (nameQuiz.equals(NameQuestion.AVIATION_TRANSPORT)) {
            return new ArrayList<>(ListAviationTransportLoad.getQuestionList());
        }
        
        return null;
    }
}
