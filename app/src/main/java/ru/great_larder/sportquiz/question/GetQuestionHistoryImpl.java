package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.question.load_question.ListHistoryLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionHistoryImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        
        if (ListHistoryLoad.getQuestionList() != null && !ListHistoryLoad.getQuestionList().isEmpty()){
            return ListHistoryLoad.getQuestionList();
        } else {
            
            List<Question> list = new ArrayList<>();
            
            list.add(new Question("Столица  Древнего Египта?", "Мемфис"
                , "Каир", "Вавилон", "Атлантида", "https://vk.com/wall-221127130_30", 1));
            list.add(new Question("Как называются гробницы  фараонов Древнего Египта?", "Пирамиды"
                , "Шахты", "Катакомбы", "Храмы", "https://vk.com/wall-221127130_15", 1));
            list.add(new Question("Кому принадлежала верховная власть в Древнем Египте?", "Фараону"
                , "Царю", "Жрецам", "Вельможам", "https://vk.com/wall-221127130_37", 1));
            list.add(new Question("Какому богу были посвящены Олимпийские игры в Древней Греции?", "Зевсу"
                , "Аиду", "Посейдону", "Апполону", null, 1));
            list.add(new Question("В честь военных побед полководцев в Древнем Риме воздвигали?", "Триумфальные арки"
                , "Мосты.", "Храмы", "Обелиски", "https://vk.com/wall-221127130_35", 1));
            list.add(new Question("Как назывался народ, издавна населявший Англию?", "Бритты"
                , "Саксы", "Норманы", "Англы", "https://vk.com/wall-221127130_34", 1));
            list.add(new Question("Как  в средние века называлось земельное владение, за которое несли военную службу?", "Феод"
                , "Налог", "Титул", "Оброк", "https://vk.com/wall-221127130_33", 1));
            list.add(new Question("В каких произведениях описывались приключения Робина Гуда?", "Баллады"
                , "Сказки", "Летописи", "Романы", null, 1));
            list.add(new Question("Огромная держава монголов была создана?", "Чингисханом"
                , "Батыем", "Тамерланом", "Гай Юлий Цезарь", "https://vk.com/wall-221127130_39", 1));
            list.add(new Question("От какой империи Россия унаследовала двуглавого орла на гербе?", "Византийской"
                , "Османской", "Китайской", "Римской", "https://vk.com/wall-221127130_32", 1));
            list.add(new Question("Почему Великий князь Владимирский Всеволод Большое гнездо получил такое прозвище?", "Имел много детей"
                , "Любил птиц", "Имел много братьев и сестер", "Имел много резиденций", "https://vk.com/wall-221127130_36", 1));
            list.add(new Question("Когда Москва впервые упомянута в летописи?", "1147 г"
                , "987 г", "1735 г", "1056 г", "https://vk.com/wall-221127130_38", 1));
            list.add(new Question("Перед началом какой знаменитой битвы произошёл поединок Пересвета с Челубеем?", "Куликовской битвой"
                , "Битвой на Чудском озере", "Ледовом побоище", "Стоянии на реке Угре", "https://vk.com/wall-221127130_41", 1));
            list.add(new Question("Кто был первым русским царём?", "Иван IV Грозный"
                , "Пётр I", "Иван Калита", "Фёдор I", "https://vk.com/wall-221127130_31", 1));
            
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
