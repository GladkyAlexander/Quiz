package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.QuestionGeography;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionGeographyInside {
    public List<QuestionGeography> getListQuestion(String value) {
            List<QuestionGeography> list = new ArrayList<>();
            
            list.add(new QuestionGeography(null,"Сколько океанов в мире?", "5"
                , "2", "7", "4", "https://vk.com/wall-221127130_49", 1));
            list.add(new QuestionGeography(null,"Как называется река, протекающая через бразильские тропические леса?", "Амазонка"
                , "Волга", "Парана", "Мадейра", "https://vk.com/wall-221127130_51", 1));
            list.add(new QuestionGeography(null,"Какую страну также называют Нидерландами?", "Голландия"
                , "Норвегия", "Великобритания", "Гренландия", "https://vk.com/wall-221127130_23", 1));
            list.add(new QuestionGeography(null,"Какая самая большая пустыня в мире?", "Антарктическая пустыня"
                , "Сахара", "Гоби", "Аравийская пустыня", "https://vk.com/wall-221127130_47", 1));
            list.add(new QuestionGeography(null,"Сколько крупных островов составляют Гавайи?", "8"
                , "12", "4", "14", "https://vk.com/wall-221127130_45", 1));
            list.add(new QuestionGeography(null,"Какая страна имеет самое большое население в мире?", "Китай"
                , "Россия", "США", "Бразилия", "https://vk.com/wall-221127130_10", 1));
            list.add(new QuestionGeography(null,"Где находится самый большой вулкан на Земле?", "Гавайи"
                , "Камчатка", "Эквадор", "Мексика", "https://vk.com/wall-221127130_44", 1));
            list.add(new QuestionGeography(null,"Какой остров самый большой в мире?", "Гренландия"
                , "Новая Гвинея", "Калимантан", "Мадагаскар", "https://vk.com/wall-221127130_53", 1));
            list.add(new QuestionGeography(null,"В каком штате США находится Ниагарский водопад?", "Нью-Йорк"
                , "Вашингтон", "Миссури", "Невада", "https://vk.com/wall-221127130_56", 1));
            list.add(new QuestionGeography(null,"Как называется самый высокий непрерывный водопад в мире?", "Анхель"
                , "Ниагарский", "Виктория", "Игуасу", "https://vk.com/wall-221127130_50", 1));
            list.add(new QuestionGeography(null,"Как называется самая большая река, протекающая через Париж?", "Сена"
                , "Луара", "Гаронна", "Мозель", "https://vk.com/wall-221127130_48", 1));
            list.add(new QuestionGeography(null,"Как называется самая маленькая страна в мире?", "Ватикан"
                , "Италия", "Израиль", "Иран", "https://vk.com/wall-221127130_24", 1));
            list.add(new QuestionGeography(null,"В какой стране вы бы нашли город Дрезден?", "Германия"
                , "Англия", "Франция", "Россия", "https://vk.com/wall-221127130_46", 1));
            list.add(new QuestionGeography(null,"Сколько часовых поясов у Австралии?", "3"
                , "5", "1", "2", "https://vk.com/wall-221127130_43", 1));
            
            Collections.shuffle(list);
            
            return list;
    }
}
