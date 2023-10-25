package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionMathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionMathematicsInside {
    public List<QuestionMathematics> getListQuestion(String value) {
            List<QuestionMathematics> list = new ArrayList<>();
            
            list.add(new QuestionMathematics(null,"Число, у которого нет собственного числа?", "0"
                , "1", "2", "4", null, 1));
            list.add(new QuestionMathematics(null,"Как еще называют периметр круга?", "Окружность"
                , "Угол", "Диаметр", "Радиус", null, 1));
            list.add(new QuestionMathematics(null,"Каков фактический чистый номер после 7?", "11"
                , "23", "8", "15", null, 1));
            list.add(new QuestionMathematics(null,"Сколько миллиметров в одном литре?", "1 000"
                , "10 000", "10", "100", null, 1));
            list.add(new QuestionMathematics(null,"Какой день является числом Пи?", "14 марта"
                , "23 марта", "5 марта", "3 марта", null, 1));
            list.add(new QuestionMathematics(null,"Кто является отцом математики?", "Архимед"
                , "Пушкин", "Толстой", "Ньютон", "https://vk.com/wall-221127130_21", 1));
            list.add(new QuestionMathematics(null,"Среднее первых 50 натуральных чисел?", "25.5"
                , "20", "15.5", "24", null, 1));
            list.add(new QuestionMathematics(null,"Значение Пи?", "3.14159"
                , "3.13", "3", "3.45", "https://vk.com/wall-221127130_14", 1));
            list.add(new QuestionMathematics(null,"Значение cos 360°?", "1"
                , "2", "3", "4", null, 1));
            list.add(new QuestionMathematics(null,"Сколько акров составляет квадратную милю?", "640"
                , "512", "434", "539", null, 1));
            list.add(new QuestionMathematics(null,"Какой единицей является сотая часть метра?", "Сантиметр"
                , "Километр", "Дециметр", "Миллиметр", null, 1));
            list.add(new QuestionMathematics(null,"Сколько градусов в прямом угле?", "90"
                , "45", "15", "67", null, 1));
            list.add(new QuestionMathematics(null,"Пифагор разработал теорию о каких формах?", "Треугольник"
                , "Круг", "Прямоугольник", "Квадрат", null, 1));
            list.add(new QuestionMathematics(null,"Сколько ребер у октаэдра?", "12"
                , "3", "16", "24", null, 1));
            
            Collections.shuffle(list);
            
            return list;
    }
}
