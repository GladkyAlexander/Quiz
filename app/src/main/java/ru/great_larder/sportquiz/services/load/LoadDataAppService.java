package ru.great_larder.sportquiz.services.load;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.database.author_and_partners.ListLoadAuthor;
import ru.great_larder.sportquiz.database.mysql.GetListAuthor;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionCityMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.request_mysql.*;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.SetQuestionMathematicsImpl;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.question.load_question.*;

import java.util.List;

public class LoadDataAppService extends Worker {
    static final String TAG = LoadDataAppService.class.getSimpleName();
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
        /*try {
            TimeUnit.SECONDS.sleep(10);*/
            
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
            
            GetListAuthor getListAuthor = new GetListAuthorImpl();
            List<Author> authors = getListAuthor.getListAuthor(user, context);
            
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
            
            ListLoadAuthor.setAuthors(authors);
            
       /* } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return Result.success();
    }
}
