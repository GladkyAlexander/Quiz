package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.question.load_question.ListEtiquetteBusinessLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetEtiquetteBusinessImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        
        if(ListEtiquetteBusinessLoad.getQuestionList() != null && !ListEtiquetteBusinessLoad.getQuestionList().isEmpty()){
            return ListEtiquetteBusinessLoad.getQuestionList();
        } else {
            
            List<Question> list = new ArrayList<>();
            list.add(new Question("С какого слова звонящий должен начать разговор?", "Здравствуйте"
                , "Алло", "Чего не берешь трубку", "Слушаю", null, 1));
            list.add(new Question("Что нельзя делать во время разговора?", "Перебивать друг друга"
                , "Внимательно слушать", "Задавать вопросы", "Улыбаться", null, 1));
            list.add(new Question("Вы чихнули, а находящиеся рядом люди сказали вам «Будь здоров». Что сделаете вы?", "Поблагодарите"
                , "Сделаете вид, что не расслышали", "Извинитесь", "Отвернетесь", null, 1));
            list.add(new Question("Если вы входите в помещение, то кто должен поздороваться первым?", "Вы"
                , "Присутствующие в помещении", "Ни кто", "Секретарь", null, 1));
            list.add(new Question("Можно ли использовать рукопожатия двумя руками в деловом этикете", "Нет"
                , "Можно если это друг", "Можно если это женщина", "В зависимости от настроения", null, 1));
            list.add(new Question("Кто первым должен входить в вращающуюся дверь?", "Мужчина"
                , "Женщина", "Ни кто", "Ассистент", null, 1));
            list.add(new Question("Кто встречает деловых партнеров в аэропорту, на вокзале?", "Агент офиса, фирмы"
                , "Директор", "Заместитель директора", "Таксист", null, 1));
            list.add(new Question("Что следует сделать с врученной визиткой?", "Положить на стол если переговоры, или положить в сумочку или карман"
                , "Выкинуть", "Вернуть", "Смять", null, 1));
            list.add(new Question("До которого часа можно совершать звонки по телефону без договоренности?", "до 21:00"
                , "до 18:00", "до 23:00", "до 13:00", null, 1));
            list.add(new Question("Кто перезванивает, если во время разговора телефон внезапно отключился?", "тот кто звонил"
                , "тот кому звонили", "секретарь", "ни кто", null, 1));
            list.add(new Question("Назовите оптимальную продолжительность делового телефонного разговора?", "3 минуты"
                , "6 минут", "20 минут", "11 минут", null, 1));
            
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
