package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionTrafficLaws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionTrafficLawsInside {
    public List<QuestionTrafficLaws> getListQuestion(String value) {
            List<QuestionTrafficLaws> list = new ArrayList<>();
            
            list.add(new QuestionTrafficLaws(null,"Документ на одну поездку в общественном транспорте?", "Билет"
                , "Договор", "Визитка", "Бумажка", null, 1));
            list.add(new QuestionTrafficLaws(null,"Животное, которое вспоминают, измеряя единицы мощности автомобиля?", "Лошадь"
                , "Корова", "Овца", "Осел", null, 1));
            list.add(new QuestionTrafficLaws(null,"«Обувь» для колес?", "Шины"
                , "Сапоги-скороходы", "Тапки", "Сапоги", null, 1));
            list.add(new QuestionTrafficLaws(null,"Маневр, который совершает машина, обходя впереди идущее транспортное средство?", "Обгон"
                , "Перестраивание", "Торможение", "Обход", null, 1));
            list.add(new QuestionTrafficLaws(null,"Что, в переводе с французского, означает слово «тротуар»?", "Дорога для пешеходов"
                , "Стоп", "Трасса", "Шоссе", null, 1));
            list.add(new QuestionTrafficLaws(null,"Какой цвет светофора означает стой?", "Красный"
                , "Белый", "Зеленый", "Желтый", null, 1));
            list.add(new QuestionTrafficLaws(null,"Какой цвет светофора означает иди?", "Зеленый"
                , "Белый", "Желтый", "Красный", null, 1));
            list.add(new QuestionTrafficLaws(null,"Подземный общественный транспорт?", "Метро"
                , "Трамвай", "Автобус", "Машина", null, 1));
            list.add(new QuestionTrafficLaws(null,"Животное лежащее на пешеходном переходе?", "Зебра"
                , "Кошка", "Суслик", "Корова", null, 1));
            list.add(new QuestionTrafficLaws(null,"Что ищет водитель, если дорога закрыта на ремонт?", "Объезд"
                , "Тоннель", "Переезд", "Съезд", null, 1));
            list.add(new QuestionTrafficLaws(null,"Как называется знак, вывешиваемый в тех местах, где могут появиться ребятишки?", "«Осторожно: дети!»"
                , "«Осторожно: переезд!»", "«Осторожно: скользко!»", "«Осторожно: сосульки!»", null, 1));
            list.add(new QuestionTrafficLaws(null,"В каких единицах измеряют скорость транспорта?", "«Километры- в час»"
                , "«Метры- в час»", "«Километры- в минуту»", "«Метры- в минуту»", "https://vk.com/wall-221127130_19", 1));
            list.add(new QuestionTrafficLaws(null,"Какой строительный материал вспоминают, видя знак «Въезд запрещен»?", "Кирпич"
                , "Мяч", "Палка", "Стакан", null, 1));
            list.add(new QuestionTrafficLaws(null,"Сигнал светофора, который ждут с нетерпением?", "Зеленый"
                , "Белый", "Желтый", "Красный", null, 1));
            
            Collections.shuffle(list);
            
            return list;
    }
}
