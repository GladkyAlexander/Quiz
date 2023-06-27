package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionTrafficLaws implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        return null;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Документ на одну поездку в общественном транспорте?", "Билет."
            , "Договор.", "Визитка.", "Бумажка.", 1));
        list.add(new Question("Животное, которое вспоминают, измеряя единицы мощности автомобиля?", "Лошадь."
            , "Корова.", "Овца.", "Осел.", 1));
        list.add(new Question("«Обувь» для колес?", "Шины."
            , "Сапоги-скороходы.", "Тапки.", "Сапоги.", 1));
        list.add(new Question("Маневр, который совершает машина, обходя впереди идущее транспортное средство?", "Обгон."
            , "Перестраивание.", "Торможение.", "Обход.", 1));
        list.add(new Question("Что, в переводе с французского, означает слово «тротуар»?", "Дорога для пешеходов."
            , "Стоп.", "Трасса", "Шоссе", 1));
        list.add(new Question("Какой цвет светофора означает стой?", "Красный."
            , "Белый.", "Зеленый.", "Желтый.", 1));
        list.add(new Question("Какой цвет светофора означает иди?", "Зеленый."
            , "Белый.", "Желтый.", "Красный.", 1));
        list.add(new Question("Подземный общественный транспорт?", "Метро."
            , "Трамвай.", "Автобус.", "Машина.", 1));
        list.add(new Question("Животное лежащее на пешеходном переходе?", "Зебра."
            , "Кошка.", "Суслик.", "Корова.", 1));
        list.add(new Question("Что ищет водитель, если дорога закрыта на ремонт?", "Объезд."
            , "Тоннель.", "Переезд.", "Съезд.", 1));
        list.add(new Question("Как называется знак, вывешиваемый в тех местах, где могут появиться ребятишки?", "«Осторожно: дети!»."
            , "«Осторожно: переезд!».", "«Осторожно: скользко!».", "«Осторожно: сосульки!».", 1));
        list.add(new Question("В каких единицах измеряют скорость транспорта?", "«Километры- в час»."
            , "«Метры- в час».", "«Километры- в минуту».", "«Метры- в минуту».", 1));
        list.add(new Question("Какой строительный материал вспоминают, видя знак «Въезд запрещен»?", "Кирпич."
            , "Мяч.", "Палка.", "Стакан.", 1));
        list.add(new Question("Сигнал светофора, который ждут с нетерпением?", "Зеленый"
            , "Белый", "Желтый", "Красный", 1));
        
        Collections.shuffle(list);
        
        return list.get(1);
    }
}
