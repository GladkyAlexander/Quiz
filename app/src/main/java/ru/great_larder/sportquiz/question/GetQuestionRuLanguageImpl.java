package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionRuLanguageImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Сколько букв в русском алфавите?", "33"
            , "24", "30", "36", 1));
        list.add(new Question("Сколько гласных букв?", "10"
            , "6", "23", "14", 1));
        list.add(new Question("Слова какой части речи могут заменять существительные в предложениях?", "Местоимениями"
            , "Прилагательными", "Глаголами", "Предлогами", 1));
        list.add(new Question("Как называется часть речи, обозначающая действие предмета?", "Глагол"
            , "Существительное", "Прилагательное", "Местоимение", 1));
        list.add(new Question("Сколько гласных звуков в русском алфавите?", "6"
            , "12", "10", "8", 1));
        list.add(new Question("Первый звук в слове ЯБЛОКО?", "Й"
            , "Э", "Е", "И", 1));
        list.add(new Question("Как называется главный член предложения, отвечающий на вопросы ЧТО? или КТО? ", "Подлежащее"
            , "Определение", "Обстоятельство", "Сказуемое", 1));
        list.add(new Question("Какая часть слова служит для связи слов в предложении?", "Окончание"
            , "Приставка", "Корень", "Суффикс", 1));
        list.add(new Question("Сколько слогов в слове ОКЕАН?", "3"
            , "4", "2", "1", 1));
        list.add(new Question("Первый звук в слове МЕЛ?", "М"
            , "Э", "В", "Ме", 1));
        list.add(new Question("Какие буквы в русском алфавите не «дают» звуков?", "Ъ , Ь"
            , "Х", "Ш , Щ", "Э , Я", 1));
        list.add(new Question("Как называется главный член предложения, отвечающий на вопросы ЧТО ДЕЛАЕТ? ЧТО ДЕЛАЛ?", "Сказуемое"
            , "Подлежащее", "Определение", "Дополнение", 1));
        list.add(new Question("Слова какой части речи обозначают количество, счет предметов?", "Числительное"
            , "Местоимение", "Наречие", "Прилагательное", 1));
        list.add(new Question("Первый звук в слове ШИШКА?", "Ш"
            , "С", "Эш", "Ша", 1));
        list.add(new Question("Как называются части слова, с помощью которых образуются новые слова?", "Приставка и суффикс"
            , "Корень и окончание", "Корень", "Приставка", 1));
        list.add(new Question("Сколько слогов в слове СИЛЬНАЯ?", "3"
            , "1", "2", "4", 1));
        list.add(new Question("Подлежащее и сказуемое – это… ?", "Главные члены предложения"
            , "Звуки", "Вопросы", "Второстепенные члены предложения", 1));
        
        Collections.shuffle(list);
        
        return list;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Сколько букв в русском алфавите?", "33"
            , "24", "30", "36", 1));
        list.add(new Question("Сколько гласных букв?", "10"
            , "6", "23", "14", 1));
        list.add(new Question("Слова какой части речи могут заменять существительные в предложениях?", "Местоимениями."
            , "Прилагательными.", "Глаголами.", "Предлогами.", 1));
        list.add(new Question("Как называется часть речи, обозначающая действие предмета?", "Глагол."
            , "Существительное.", "Прилагательное.", "Местоимение.", 1));
        list.add(new Question("Сколько гласных звуков в русском алфавите?", "6"
            , "12", "10", "8", 1));
        list.add(new Question("Первый звук в слове ЯБЛОКО?", "Й."
            , "Э.", "Е.", "И.", 1));
        list.add(new Question("Как называется главный член предложения, отвечающий на вопросы ЧТО? или КТО? ", "Подлежащее"
            , "Определение.", "Обстоятельство.", "Сказуемое.", 1));
        list.add(new Question("Какая часть слова служит для связи слов в предложении?", "Окончание."
            , "Приставка.", "Корень.", "Суффикс.", 1));
        list.add(new Question("Сколько слогов в слове ОКЕАН?", "3"
            , "4", "2", "1", 1));
        list.add(new Question("Первый звук в слове МЕЛ?", "М."
            , "Э.", "В.", "Ме.", 1));
        list.add(new Question("Какие буквы в русском алфавите не «дают» звуков?", "Ъ , Ь."
            , "Х.", "Ш , Щ.", "Э , Я.", 1));
        list.add(new Question("Как называется главный член предложения, отвечающий на вопросы ЧТО ДЕЛАЕТ? ЧТО ДЕЛАЛ?", "Сказуемое."
            , "Подлежащее.", "Определение.", "Дополнение.", 1));
        list.add(new Question("Слова какой части речи обозначают количество, счет предметов?", "Числительное."
            , "Местоимение.", "Наречие.", "Прилагательное.", 1));
        list.add(new Question("Первый звук в слове ШИШКА?", "Ш."
            , "С.", "Эш.", "Ша.", 1));
        list.add(new Question("Как называются части слова, с помощью которых образуются новые слова?", "Приставка и суффикс."
            , "Корень и окончание.", "Корень.", "Приставка.", 1));
        list.add(new Question("Сколько слогов в слове СИЛЬНАЯ?", "3"
            , "1", "2", "4", 1));
        list.add(new Question("Подлежащее и сказуемое – это… ?", "Главные члены предложения."
            , "Звуки.", "Вопросы.", "Второстепенные члены предложения.", 1));
        
        Collections.shuffle(list);
        
        return list.get(1);
    }
    
}
