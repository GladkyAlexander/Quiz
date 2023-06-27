package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionGeography implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        return null;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Сколько океанов в мире?", "5"
            , "2", "7", "4", 1));
        list.add(new Question("Как называется река, протекающая через бразильские тропические леса?", "Амазонка."
            , "Волга.", "Парана.", "Мадейра.", 1));
        list.add(new Question("Какую страну также называют Нидерландами?", "Голландия."
            , "Норвегия.", "Великобритания.", "Гренландия.", 1));
        list.add(new Question("Какая самая большая пустыня в мире?", "Антарктическая пустыня."
            , "Сахара.", "Гоби.", "Аравийская пустыня.", 1));
        list.add(new Question("Сколько крупных островов составляют Гавайи?", "8"
            , "12", "4", "14", 1));
        list.add(new Question("Какая страна имеет самое большое население в мире?", "Китай."
            , "Россия.", "США.", "Бразилия.", 1));
        list.add(new Question("Где находится самый большой вулкан на Земле?", "Гавайи."
            , "Камчатка.", "Эквадор.", "Мексика.", 1));
        list.add(new Question("Какой остров самый большой в мире?", "Гренландия."
            , "Новая Гвинея.", "Калимантан.", "Мадагаскар.", 1));
        list.add(new Question("В каком штате США находится Ниагарский водопад?", "Нью-Йорк."
            , "Вашингтон.", "Миссури.", "Невада.", 1));
        list.add(new Question("Как называется самый высокий непрерывный водопад в мире?", "Анхель."
            , "Ниагарский.", "Виктория.", "Игуасу.", 1));
        list.add(new Question("Как называется самая большая река, протекающая через Париж?", "Сена."
            , "Луара.", "Гаронна.", "Мозель.", 1));
        list.add(new Question("Как называется самая маленькая страна в мире?", "Ватикан."
            , "Италия.", "Израиль.", "Иран.", 1));
        list.add(new Question("В какой стране вы бы нашли город Дрезден?", "Германия."
            , "Англия.", "Франция.", "Россия.", 1));
        list.add(new Question("Сколько часовых поясов у Австралии?", "3"
            , "5", "1", "2", 1));
        
        Collections.shuffle(list);
        
        return list.get(1);
    }
}
