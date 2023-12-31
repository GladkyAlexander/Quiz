package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionEnLanguage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionEnLanguageInside {
    public List<QuestionEnLanguage> getListQuestion(String value) {
            List<QuestionEnLanguage> list = new ArrayList<>();
            list.add(new QuestionEnLanguage(null,"Примерно какая доля мирового населения свободно владеет английским или компетентна в нем?", "Один из четырех"
                , "Один человек из тысячи", "Один из ста", "Один из десяти", null, 1));
            list.add(new QuestionEnLanguage(null,"В какой стране живет самое большое англоязычное население в мире?", "Индия"
                , "Соединенные Штаты", "Китай", "Австралия", null, 1));
            list.add(new QuestionEnLanguage(null,"Сколько стран использует английский язык как официальный или преобладающий?", "более 75"
                , "34", "45", "50", null, 1));
            list.add(new QuestionEnLanguage(null,"Какое из следующих слов, является наиболее широко используемым английским словом во всем мире?", "Okay"
                , "Movie", "Internet", "Dollar", null, 1));
            list.add(new QuestionEnLanguage(null,"Сколько слов составляет «ядро» английского языка, которое позволяет выразить то, что необходимо для целей повседневного существования?", "850"
                , "348", "44", "1420", null, 1));
            list.add(new QuestionEnLanguage(null,"Английский язык условно делится на три исторических периода. В каком из этих периодов Уильям Шекспир писал свои пьесы?", "Современный английский"
                , "Старый английский", "Средний английский", "Австралийский английский", null, 1));
            list.add(new QuestionEnLanguage(null,"An acronym (акроним) — это сокращение, которое легко произнести слитно. An eponym (эпоним) — это лицо, от имени которого образовано другое имя или место. Какой термин используется для слова, полученного от того же корня, что и другое слово?", "Paronym"
                , "Oronym", "Exonym", "Retronym", null, 1));
            list.add(new QuestionEnLanguage(null,"Какое из следующих слов является примером изограммы?", "Palindrome"
                , "Sesquipedalian", "Racecar", "Destruction", null, 1));
            list.add(new QuestionEnLanguage(null,"Какое из следующих замечаний относится к слову typewriter (печатная машинка)?", "Его можно ввести, используя только верхний ряд клавиш на стандартной клавиатуре"
                , "Это единственное слово в английском языке, которое не рифмуется ни с каким другим словом", "Это палиндром", "Это самое длинное слово, которое набирается только левой рукой", null, 1));
            list.add(new QuestionEnLanguage(null,"Какой из следующих словарей обычно рассматривается как первый подлинный словарь на английском языке?", "«A Table Alphabeticall» Роберта Каудри"
                , "«Glossographia» Томаса Блаунта", "«Dictionary of the English Language» Сэмюэля Джонсона", "«The Elementarie» Ричарда Мулкастера", null, 1));
            list.add(new QuestionEnLanguage(null,"Какие два примера одной грамматической структуры содержит предложение «Natasha is a friend of Diana’s and a client of Murray’s»?", "Двойной притяжательный падеж"
                , "Двойное толкование", "Двойное сравнение", "Двойное превосходство", null, 1));
            list.add(new QuestionEnLanguage(null,"Какой из следующих терминов является заменой нейтрального выражения более оскорбительным?", "Дисфемизм"
                , "Эвфемизм", "Драматизм", "Ортофемизм", null, 1));
            list.add(new QuestionEnLanguage(null,"Количество букв в английском алфавите?", "26"
                , "24", "33", "28", null, 1));
            list.add(new QuestionEnLanguage(null,"Сколько в классической английской грамматике указано временных форм?", "12"
                , "3", "16", "24", null, 1));
            Collections.shuffle(list);
            return list;
    }
}
