package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionMathematics implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        return null;
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = new ArrayList<>();
        
        list.add(new Question("Число, у которого нет собственного числа?", "0"
            , "1", "2", "4", 1));
        list.add(new Question("Как еще называют периметр круга?", "Окружность."
            , "Угол.", "Диаметр.", "Радиус.", 1));
        list.add(new Question("Каков фактический чистый номер после 7?", "11"
            , "23", "8", "15", 1));
        list.add(new Question("Сколько миллиметров в одном литре?", "1 000"
            , "10 000", "10", "100", 1));
        list.add(new Question("Какой день является числом Пи?", "14 марта."
            , "23 марта.", "5 марта", "3 марта.", 1));
        list.add(new Question("Кто является отцом математики?", "Архимед."
            , "Пушкин.", "Толстой.", "Ньютон.", 1));
        list.add(new Question("Среднее первых 50 натуральных чисел?", "25.5"
            , "20", "15.5", "24", 1));
        list.add(new Question("Значение Пи?", "3.14159"
            , "3.13", "3", "3.45", 1));
        list.add(new Question("Значение cos 360°?", "1"
            , "2", "3", "4", 1));
        list.add(new Question("Сколько акров составляет квадратную милю?", "640"
            , "512", "434", "539", 1));
        list.add(new Question("Какой единицей является сотая часть метра?", "Сантиметр."
            , "Километр.", "Дециметр.", "Миллиметр.", 1));
        list.add(new Question("Сколько градусов в прямом угле?", "90"
            , "45", "15", "67", 1));
        list.add(new Question("Пифагор разработал теорию о каких формах?", "Треугольник."
            , "Круг.", "Прямоугольник.", "Квадрат.", 1));
        list.add(new Question("Сколько ребер у октаэдра?", "12"
            , "3", "16", "24", 1));
        
        Collections.shuffle(list);
        
        return list.get(1);
    }
}
