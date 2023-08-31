package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.question.load_question.ListTrafficLawsLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionTrafficLawsImpl implements GetQuestion {
    
    @Override
    public List<Question> getListQuestion(String value) {
        
        if(ListTrafficLawsLoad.getQuestionList() != null && !ListTrafficLawsLoad.getQuestionList().isEmpty()){
            return ListTrafficLawsLoad.getQuestionList();
        } else {
            
            List<Question> list = new ArrayList<>();
            
            list.add(new Question("Документ на одну поездку в общественном транспорте?", "Билет"
                , "Договор", "Визитка.", "Бумажка.", null, 1));
            list.add(new Question("Животное, которое вспоминают, измеряя единицы мощности автомобиля?", "Лошадь"
                , "Корова", "Овца", "Осел", null, 1));
            list.add(new Question("«Обувь» для колес?", "Шины"
                , "Сапоги-скороходы", "Тапки", "Сапоги", null, 1));
            list.add(new Question("Маневр, который совершает машина, обходя впереди идущее транспортное средство?", "Обгон"
                , "Перестраивание", "Торможение", "Обход", null, 1));
            list.add(new Question("Что, в переводе с французского, означает слово «тротуар»?", "Дорога для пешеходов"
                , "Стоп", "Трасса", "Шоссе", null, 1));
            list.add(new Question("Какой цвет светофора означает стой?", "Красный"
                , "Белый", "Зеленый", "Желтый", null, 1));
            list.add(new Question("Какой цвет светофора означает иди?", "Зеленый"
                , "Белый", "Желтый", "Красный", null, 1));
            list.add(new Question("Подземный общественный транспорт?", "Метро"
                , "Трамвай", "Автобус", "Машина", null, 1));
            list.add(new Question("Животное лежащее на пешеходном переходе?", "Зебра."
                , "Кошка", "Суслик", "Корова", null, 1));
            list.add(new Question("Что ищет водитель, если дорога закрыта на ремонт?", "Объезд"
                , "Тоннель", "Переезд", "Съезд", null, 1));
            list.add(new Question("Как называется знак, вывешиваемый в тех местах, где могут появиться ребятишки?", "«Осторожно: дети!»"
                , "«Осторожно: переезд!»", "«Осторожно: скользко!»", "«Осторожно: сосульки!»", null, 1));
            list.add(new Question("В каких единицах измеряют скорость транспорта?", "«Километры- в час»"
                , "«Метры- в час»", "«Километры- в минуту»", "«Метры- в минуту»", "https://vk.com/wall-221127130_19", 1));
            list.add(new Question("Какой строительный материал вспоминают, видя знак «Въезд запрещен»?", "Кирпич"
                , "Мяч", "Палка", "Стакан", null, 1));
            list.add(new Question("Сигнал светофора, который ждут с нетерпением?", "Зеленый"
                , "Белый", "Желтый", "Красный", null, 1));
            
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
