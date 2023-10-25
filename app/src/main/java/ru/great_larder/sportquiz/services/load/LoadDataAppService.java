package ru.great_larder.sportquiz.services.load;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.database.CompareQuestions;
import ru.great_larder.sportquiz.database.GetListAuthorExternalDB;
import ru.great_larder.sportquiz.database.GetListCompanyPartnersExternalDB;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionCityMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.request_get_mysql.*;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.services.CheckNetClass;

import java.util.List;

public class LoadDataAppService extends Worker {
    private final User user = GlobalLinkUser.getUser();
    private final Context context;
    
    public LoadDataAppService(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }
    
    @NonNull
    @NotNull
    @Override
    public Result doWork() {
        CompareQuestions compareQuestions = new CompareQuestions(context);
        if (new CheckNetClass().isInternetAvailable()) {
            
            GetListQuestionMySQL getListLanguageRuQuestion = new GetListLanguageRuQuestionMySQLImpl();
            List<Question> questionsRu = getListLanguageRuQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsRu);
            
            GetListQuestionMySQL getListLanguageEnQuestion = new GetListLanguageEnQuestionMySQLImpl();
            List<Question> questionsEn = getListLanguageEnQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsEn);
            
            GetListQuestionMySQL getListEtiquetteBusinessQuestion = new GetListEtiquetteBusinessQuestionMySQLImpl();
            List<Question> questionsEtiquetteBusiness = getListEtiquetteBusinessQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsEtiquetteBusiness);
            
            GetListQuestionMySQL getListEtiquetteSecularQuestion = new GetListEtiquetteSecularQuestionMySQLImpl();
            List<Question> questionsEtiquetteSecular = getListEtiquetteSecularQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsEtiquetteSecular);
            
            GetListQuestionMySQL getListBiologyQuestion = new GetListBiologyQuestionMySQLImpl();
            List<Question> questionsBiology = getListBiologyQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsBiology);
            
            GetListQuestionMySQL getListGeographyQuestion = new GetListGeographyQuestionMySQLImpl();
            List<Question> questionsGeography = getListGeographyQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsGeography);
            
            GetListQuestionMySQL getListHistoryQuestion = new GetListHistoryQuestionMySQLImpl();
            List<Question> questionsHistory = getListHistoryQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsHistory);
            
            GetListQuestionMySQL getListMathematicsQuestion = new GetListMathematicsQuestionMySQLImpl();
            List<Question> questionsMathematics = getListMathematicsQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsMathematics);
            
            GetListQuestionMySQL getListPhysicsQuestion = new GetListPhysicsQuestionMySQLImpl();
            List<Question> questionsPhysics = getListPhysicsQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsPhysics);
            
            GetListQuestionMySQL getListSportsQuestion = new GetListSportsQuestionMySQLImpl();
            List<Question> questionsSports = getListSportsQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsSports);
            
            GetListQuestionMySQL getListTrafficLawsQuestion = new GetListTrafficLawsQuestionMySQLImpl();
            List<Question> questionsTrafficLaws = getListTrafficLawsQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsTrafficLaws);
            
            GetListQuestionCityMySQL getListCityQuestion = new GetListCityQuestionMySQLImpl();
            List<QuestionCity> questionsCity = getListCityQuestion.getListQuestion(user, context);
            compareQuestions.compare(questionsCity);
            
            GetListAuthorExternalDB getListAuthor = new GetListAuthorImpl();
            List<Author> authors = getListAuthor.getListAuthor(user, context);
            compareQuestions.compare(authors);
            
            GetListCompanyPartnersExternalDB getListCompanyPartners = new GetListCompanyPartnersImpl();
            List<CompanyPartners> companyPartners = getListCompanyPartners.getListCompanyPartners(user, context);
            compareQuestions.compare(companyPartners);
        } else {
            compareQuestions.compare(null);
        }
        
        return Result.success();
    }
}
