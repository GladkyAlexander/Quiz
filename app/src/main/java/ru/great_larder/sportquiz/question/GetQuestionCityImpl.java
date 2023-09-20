package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.question.load_question.ListCityLoad;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionCityImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        if(ListCityLoad.getQuestionList() != null && !ListCityLoad.getQuestionList().isEmpty()){
            
            List<Question> retList = new ArrayList<>();
            List<QuestionCity> inList = ListCityLoad.getQuestionList();
            
            for (QuestionCity q : inList){
                if (value.equals(q.getCity())){
                   retList.add(q);
                }
            }
           return retList;
        }
        return null;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        return null;
    }
    public List<Question> getListAll(){
        if(ListCityLoad.getQuestionList() != null && !ListCityLoad.getQuestionList().isEmpty()){
            
            List<QuestionCity> inList = ListCityLoad.getQuestionList();
            
            return new ArrayList<>(inList);
        }
        return null;
    }
}
