package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionRuLanguage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionRuLanguageInside {
    public List<QuestionRuLanguage> getListQuestion(String value) {
            List<QuestionRuLanguage> list = new ArrayList<>();
            
            list.add(new QuestionRuLanguage(null,"Сколько букв в русском алфавите?", "33"
                , "24", "30", "36", null, 1));
            list.add(new QuestionRuLanguage(null,"Сколько гласных букв?", "10"
                , "6", "23", "14", null, 1));
            list.add(new QuestionRuLanguage(null,"Слова какой части речи могут заменять существительные в предложениях?", "Местоимениями"
                , "Прилагательными", "Глаголами", "Предлогами", null, 1));
            list.add(new QuestionRuLanguage(null,"Как называется часть речи, обозначающая действие предмета?", "Глагол"
                , "Существительное", "Прилагательное", "Местоимение", null, 1));
            list.add(new QuestionRuLanguage(null,"Сколько гласных звуков в русском алфавите?", "6"
                , "12", "10", "8", null, 1));
            list.add(new QuestionRuLanguage(null,"Первый звук в слове ЯБЛОКО?", "Й"
                , "Э", "Е", "И", null, 1));
            list.add(new QuestionRuLanguage(null,"Как называется главный член предложения, отвечающий на вопросы ЧТО? или КТО? ", "Подлежащее"
                , "Определение", "Обстоятельство", "Сказуемое", null, 1));
            list.add(new QuestionRuLanguage(null,"Какая часть слова служит для связи слов в предложении?", "Окончание"
                , "Приставка", "Корень", "Суффикс", null, 1));
            list.add(new QuestionRuLanguage(null,"Сколько слогов в слове ОКЕАН?", "3"
                , "4", "2", "1", null, 1));
            list.add(new QuestionRuLanguage(null,"Первый звук в слове МЕЛ?", "М"
                , "Э", "В", "Ме", null, 1));
            list.add(new QuestionRuLanguage(null,"Какие буквы в русском алфавите не «дают» звуков?", "Ъ , Ь"
                , "Х", "Ш , Щ", "Э , Я", null, 1));
            list.add(new QuestionRuLanguage(null,"Как называется главный член предложения, отвечающий на вопросы ЧТО ДЕЛАЕТ? ЧТО ДЕЛАЛ?", "Сказуемое"
                , "Подлежащее", "Определение", "Дополнение", null, 1));
            list.add(new QuestionRuLanguage(null,"Слова какой части речи обозначают количество, счет предметов?", "Числительное"
                , "Местоимение", "Наречие", "Прилагательное", null, 1));
            list.add(new QuestionRuLanguage(null,"Первый звук в слове ШИШКА?", "Ш"
                , "С", "Эш", "Ша", null, 1));
            list.add(new QuestionRuLanguage(null,"Как называются части слова, с помощью которых образуются новые слова?", "Приставка и суффикс"
                , "Корень и окончание", "Корень", "Приставка", null, 1));
            list.add(new QuestionRuLanguage(null,"Сколько слогов в слове СИЛЬНАЯ?", "3"
                , "1", "2", "4", null, 1));
            list.add(new QuestionRuLanguage(null,"Подлежащее и сказуемое – это… ?", "Главные члены предложения"
                , "Звуки", "Вопросы", "Второстепенные члены предложения", null, 1));
            
            Collections.shuffle(list);
            
            return list;
    }
}
