package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.QuestionChechenLanguage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionChechenLanguageInside {
	public List<QuestionChechenLanguage> getListQuestion(String value) {
		List<QuestionChechenLanguage> list = new ArrayList<>();
		
		list.add(new QuestionChechenLanguage(null,"Как называется чеченский алфавит на основе кириллицы?"
				, "Чеченская азбука"
				, "Вайнахская азбука", "Горская азбука", "Кавказская азбука ", null, 1));
		list.add(new QuestionChechenLanguage(null,"Сколько букв в чеченском алфавите?", "49 букв"
				, "33 буквы", "39 букв", "43 буквы", null, 1));
		list.add(new QuestionChechenLanguage(null,"Какой из перечисленных звуков отсутствует в чеченском языке?"
				, "Глухой альвеолярный латеральный аппроксимант \"l̥\""
				, "Звонкий постальвеолярный спирант \"ʒ\"", "Звонкий лабиовелярный аппроксимант \"ʍ\""
				, "Глоттальный смычный согласный \"ʔ\"", null, 1));
		list.add(new QuestionChechenLanguage(null,"Что такое \"дифтонгизация\" в фонетике чеченского языка?"
				, "Процесс слияния двух гласных в один слог"
				, "Процесс разделения гласного на два слога"
				, "Процесс изменения качества гласного звука"
				, "Процесс удлинения гласного звука", null, 1));
		list.add(new QuestionChechenLanguage(null,"Какой звук является звонким в чеченском языке?"
				, "Звонкий альвеолярный взрывной \"d\""
				, "Глухой постальвеолярный спирант \"s\""
				, "Глухой велярный взрывной \"k\""
				, "Глухой губно-губной взрывной \"p\"", null, 1));
		list.add(new QuestionChechenLanguage(null,"Что обозначает слово \"нана\" в чеченском языке?"
				, "Мать"
				, "Отец", "Брат", "Брат", null, 1));
		list.add(new QuestionChechenLanguage(null,"Какой падеж в чеченском языке отвечает за именительный падеж в русском языке?"
				, "Именительный падеж"
				, "Творительный падеж", "Дательный падеж", "Дательный падеж", null, 1));
		list.add(new QuestionChechenLanguage(null,"Как переводится на чеченский язык слово \"семья\"?"
				, "Доьзал"
				, "Даймохк", "Нийсо", "Мехк", null, 1));
		list.add(new QuestionChechenLanguage(null,"Какой звук в чеченском языке обозначает букву \"кх\"?"
				, "kʰ"
				, "ɡ", "q", "x", null, 1));
		list.add(new QuestionChechenLanguage(null,"Как называется звук, обозначаемый буквой \"кхъ\"?"
				, "глухим велярным смычным"
				, "звонким альвеолярным латеральным аппроксимантом"
				, "глухим постальвеолярным спирантом"
				, "звонким велярным аппроксимантом", null, 1));
		list.add(new QuestionChechenLanguage(null,"Какая буква чеченского алфавита не имеет заглавной формы?"
				, "А"
				, "Б", "В", "Г", null, 1));
		
		Collections.shuffle(list);
		
		return list;
	}
}
