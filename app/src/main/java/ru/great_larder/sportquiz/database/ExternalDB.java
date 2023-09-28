package ru.great_larder.sportquiz.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionCityMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.request_get_mysql.*;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.question.load_question.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExternalDB {
   
    public ExternalDB(User user, Context context) {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        
        executor.execute(() -> {
          
            GetListQuestionMySQL getListLanguageRuQuestion = new GetListLanguageRuQuestionMySQLImpl();
            List<Question> questionsRu = getListLanguageRuQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListLanguageEnQuestion = new GetListLanguageEnQuestionMySQLImpl();
            List<Question> questionsEn = getListLanguageEnQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListEtiquetteBusinessQuestion = new GetListEtiquetteBusinessQuestionMySQLImpl();
            List<Question> questionsEtiquetteBusiness = getListEtiquetteBusinessQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListEtiquetteSecularQuestion = new GetListEtiquetteSecularQuestionMySQLImpl();
            List<Question> questionsEtiquetteSecular = getListEtiquetteSecularQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListBiologyQuestion = new GetListBiologyQuestionMySQLImpl();
            List<Question> questionsBiology = getListBiologyQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListGeographyQuestion = new GetListGeographyQuestionMySQLImpl();
            List<Question> questionsGeography = getListGeographyQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListHistoryQuestion = new GetListHistoryQuestionMySQLImpl();
            List<Question> questionsHistory = getListHistoryQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListMathematicsQuestion = new GetListMathematicsQuestionMySQLImpl();
            List<Question> questionsMathematics = getListMathematicsQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListPhysicsQuestion = new GetListPhysicsQuestionMySQLImpl();
            List<Question> questionsPhysics = getListPhysicsQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListSportsQuestion = new GetListSportsQuestionMySQLImpl();
            List<Question> questionsSports = getListSportsQuestion.getListQuestion(user, context);
            
            GetListQuestionMySQL getListTrafficLawsQuestion = new GetListTrafficLawsQuestionMySQLImpl();
            List<Question> questionsTrafficLaws = getListTrafficLawsQuestion.getListQuestion(user, context);
            
            GetListQuestionCityMySQL getListCityQuestion = new GetListCityQuestionMySQLImpl();
            List<QuestionCity> questionsCity = getListCityQuestion.getListQuestion(user, context);
            
            handler.post(() -> {
                ListRuLanguageLoad.setQuestionList(questionsRu);
                ListBiologyLoad.setQuestionList(questionsBiology);
                ListEnLanguageLoad.setQuestionList(questionsEn);
                ListEtiquetteBusinessLoad.setQuestionList(questionsEtiquetteBusiness);
                ListEtiquetteSecularLoad.setQuestionList(questionsEtiquetteSecular);
                ListGeographyLoad.setQuestionList(questionsGeography);
                ListHistoryLoad.setQuestionList(questionsHistory);
                ListMathematicsLoad.setQuestionList(questionsMathematics);
                ListPhysicsLoad.setQuestionList(questionsPhysics);
                ListSportsLoad.setQuestionList(questionsSports);
                ListTrafficLawsLoad.setQuestionList(questionsTrafficLaws);
                ListCityLoad.setQuestionList(questionsCity);
            });
        });
    }
}
