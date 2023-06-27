package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionPhisics implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        return null;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Кто не учившись на всех языках разговаривает ?", "Эхо."
            , "Ни кто.", "Иностранец.", "Полиглот.", 1));
        list.add(new Question("Чего в шкаф не спрячешь?", "Луч света."
            , "Кошку.", "Одежду.", "Швабру.", 1));
        list.add(new Question("Прибор для измерения сил?", "Динамометр."
            , "Амперметр.", "Дальнометр.", "Силометр.", 1));
        list.add(new Question("Сила, возникающая при движении одного тела по поверхности другого и направленная против движения?", "Сила трения."
            , "Сила падения.", "Сила взлета.", "Сила движения.", 1));
        list.add(new Question("Линия, вдоль которой движется тело?", "Траектория."
            , "Кривая.", "Плоскость.", "Прямая.", 1));
        list.add(new Question("Единица измерения силы электрического тока?", "Ампер."
            , "Литры.", "Кг.", "Вольт.", 1));
        list.add(new Question("На тело, погруженное в жидкость, действует?", "Архимедова сила."
            , "Сила отталкивания.", "Сила погружения.", "Магическая сила.", 1));
        list.add(new Question("Величина, равная отношению пройденного пути ко времени?", "Скорость."
            , "Глубина.", "Время.", "Расстояние.", 1));
        list.add(new Question("Смазка является одним из способов уменьшения?", "Силы трения."
            , "Возгорания.", "Нагрева.", "Силы притяжения.", 1));
        list.add(new Question("Разноименные заряды?", "Притягиваются."
            , "Пропадают.", "Отталкиваются.", "Растягиваются.", 1));
        list.add(new Question("Если вещество сохраняет объем, но легко меняет свою форму, то оно находится?", "В жидком состоянии."
            , "В состоянии покоя.", "В газообразном состоянии.", "В твердом состоянии.", 1));
        list.add(new Question("Единица электрического сопротивления?", "Ом."
            , "Градусы.", "Вольт.", "Ампер.", 1));
        list.add(new Question("Величина, равная отношению массы тела к его объёму?", "Плотность."
            , "Объем.", "Масса.", "Площадь.", 1));
        list.add(new Question("Величина, характеризующаяся отношением работы ко времени, за которое она была совершена?", "Мощность."
            , "Площадь.", "Объем.", "Длина.", 1));
        
        Collections.shuffle(list);
        
        return list.get(1);
    }
}
