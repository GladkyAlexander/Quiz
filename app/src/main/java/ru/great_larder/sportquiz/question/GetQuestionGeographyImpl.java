package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.question.load_question.ListGeographyLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionGeographyImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        
        if (ListGeographyLoad.getQuestionList() != null && !ListGeographyLoad.getQuestionList().isEmpty()){
            return ListGeographyLoad.getQuestionList();
        } else {
            
            List<Question> list = new ArrayList<>();
            
            list.add(new Question("Сколько океанов в мире?", "5"
                , "2", "7", "4", null, 1));
            list.add(new Question("Как называется река, протекающая через бразильские тропические леса?", "Амазонка"
                , "Волга", "Парана", "Мадейра", null, 1));
            list.add(new Question("Какую страну также называют Нидерландами?", "Голландия"
                , "Норвегия", "Великобритания", "Гренландия", "https://vk.com/wall-221127130_23", 1));
            list.add(new Question("Какая самая большая пустыня в мире?", "Антарктическая пустыня"
                , "Сахара", "Гоби", "Аравийская пустыня", null, 1));
            list.add(new Question("Сколько крупных островов составляют Гавайи?", "8"
                , "12", "4", "14", null, 1));
            list.add(new Question("Какая страна имеет самое большое население в мире?", "Китай"
                , "Россия", "США", "Бразилия", "https://vk.com/wall-221127130_10", 1));
            list.add(new Question("Где находится самый большой вулкан на Земле?", "Гавайи"
                , "Камчатка", "Эквадор", "Мексика", "https://vk.com/wall-221127130_44", 1));
            list.add(new Question("Какой остров самый большой в мире?", "Гренландия"
                , "Новая Гвинея", "Калимантан", "Мадагаскар", null, 1));
            list.add(new Question("В каком штате США находится Ниагарский водопад?", "Нью-Йорк"
                , "Вашингтон", "Миссури", "Невада", null, 1));
            list.add(new Question("Как называется самый высокий непрерывный водопад в мире?", "Анхель"
                , "Ниагарский", "Виктория", "Игуасу", null, 1));
            list.add(new Question("Как называется самая большая река, протекающая через Париж?", "Сена"
                , "Луара", "Гаронна", "Мозель", null, 1));
            list.add(new Question("Как называется самая маленькая страна в мире?", "Ватикан"
                , "Италия", "Израиль", "Иран", "https://vk.com/wall-221127130_24", 1));
            list.add(new Question("В какой стране вы бы нашли город Дрезден?", "Германия"
                , "Англия", "Франция", "Россия", null, 1));
            list.add(new Question("Сколько часовых поясов у Австралии?", "3"
                , "5", "1", "2", "https://vk.com/wall-221127130_43", 1));
            
            Collections.shuffle(list);
            
            return list;
        }
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = getListQuestion(null);
        Collections.shuffle(list);
        
        return list.get(1);
    }
}
