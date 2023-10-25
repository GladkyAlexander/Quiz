package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionPhysics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionPhysicsInside {
    public List<QuestionPhysics> getListQuestion(String value) {
            List<QuestionPhysics> list = new ArrayList<>();
            
            list.add(new QuestionPhysics(null,"Кто не учившись на всех языках разговаривает ?", "Эхо"
                , "Ни кто", "Иностранец", "Полиглот", "https://vk.com/wall-221127130_57", 1));
            list.add(new QuestionPhysics(null,"Чего в шкаф не спрячешь?", "Луч света"
                , "Кошку", "Одежду", "Швабру", null, 1));
            list.add(new QuestionPhysics(null,"Прибор для измерения сил?", "Динамометр"
                , "Амперметр", "Дальнометр", "Силометр", null, 1));
            list.add(new QuestionPhysics(null,"Сила, возникающая при движении одного тела по поверхности другого и направленная против движения?", "Сила трения"
                , "Сила падения", "Сила взлета", "Сила движения", "https://vk.com/wall-221127130_22", 1));
            list.add(new QuestionPhysics(null,"Линия, вдоль которой движется тело?", "Траектория"
                , "Кривая", "Плоскость", "Прямая", "https://vk.com/wall-221127130_58", 1));
            list.add(new QuestionPhysics(null,"Единица измерения силы электрического тока?", "Ампер"
                , "Литры", "Кг", "Вольт", null, 1));
            list.add(new QuestionPhysics(null,"На тело, погруженное в жидкость, действует?", "Архимедова сила", "Магическая сила"
                , "Сила отталкивания", "Сила погружения", null, 1));
            list.add(new QuestionPhysics(null,"Величина, равная отношению пройденного пути ко времени?", "Скорость"
                , "Глубина", "Время", "Расстояние", null, 1));
            list.add(new QuestionPhysics(null,"Смазка является одним из способов уменьшения?", "Силы трения"
                , "Возгорания", "Нагрева", "Силы притяжения", null, 1));
            list.add(new QuestionPhysics(null,"Разноименные заряды?", "Притягиваются"
                , "Пропадают", "Отталкиваются", "Растягиваются", null, 1));
            list.add(new QuestionPhysics(null,"Если вещество сохраняет объем, но легко меняет свою форму, то оно находится?", "В жидком состоянии"
                , "В состоянии покоя", "В газообразном состоянии", "В твердом состоянии", null, 1));
            list.add(new QuestionPhysics(null,"Единица электрического сопротивления?", "Ом"
                , "Градусы", "Вольт", "Ампер", "https://vk.com/wall-221127130_16", 1));
            list.add(new QuestionPhysics(null,"Величина, равная отношению массы тела к его объёму?", "Плотность"
                , "Объем", "Масса", "Площадь", null, 1));
            list.add(new QuestionPhysics(null,"Величина, характеризующаяся отношением работы ко времени, за которое она была совершена?", "Мощность"
                , "Площадь", "Объем", "Длина", "https://vk.com/wall-221127130_17", 1));
            
            Collections.shuffle(list);
            
            return list;
    }
}
