package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.QuestionTatarLanguage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionTatarLanguageInside {
	public List<QuestionTatarLanguage> getListQuestion(String value) {
		List<QuestionTatarLanguage> list = new ArrayList<>();
		list.add(new QuestionTatarLanguage(null,"В каком веке был создан алфавит татарского языка на основе арабской графики?", "XIII век"
				, "XI век", "VIII век", "V век", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какой звук отсутствует в татарском языке?", "χ"
				, "ð", "θ", "ŋ", null, 1));
		list.add(new QuestionTatarLanguage(null,"Сколько падежей в татарском языке?", "8"
				, "7", "6", "5", null, 1));
		list.add(new QuestionTatarLanguage(null,"Как называется наклонение, выражающее необходимость или приказ?", "Повелительное наклонение"
				, "Изъявительное наклонение", "Условное наклонение", "Желательное наклонение", null, 1));
		list.add(new QuestionTatarLanguage(null,"Что такое «авазлык»?", "Окончание принадлежности"
				, "Окончание прошедшего времени", "Окончание множественного числа", "Окончание настоящего времени", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какое слово переводится на татарский как «ягода»?", "Җиләк"
				, "Бәрәңге", "Көнбатыш", "Яңгыр", null, 1));
		list.add(new QuestionTatarLanguage(null,"Кто написал первый учебник по татарскому языку для русских школ?", "Каюм Насыйри"
				, "Шигабутдин Марджани", "Габдулла Тукай", "Галимджан Ибрагимов", null, 1));
		list.add(new QuestionTatarLanguage(null,"Как переводится на татарский слово \"земля\"?", "Ир"
				, "Идел", "Урал", "Кама", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какие согласные звуки в татарском языке всегда твердые?", "Глухие согласные"
				, "Звонкие согласные", "Полузвонкие согласные", "Полуглухие согласные", null, 1));
		list.add(new QuestionTatarLanguage(null,"В каких словах татарского языка употребляется окончание \"лар\"?", "Глаголы в прошедшем времени"
				, "Существительные во множественном числе", "Прилагательные в сравнительной степени", "Наречия в превосходной степени", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какая буква татарского алфавита обозначает звук \"χ\"?", "Х"
				, "Қ", "Г", "Ә", null, 1));
		list.add(new QuestionTatarLanguage(null,"Каким словом в татарском языке обозначается \"молоко\"?", "СӨТ"
				, "ЙӨЗ", "ТӨР", "КӨЛ", null, 1));
		list.add(new QuestionTatarLanguage(null,"Как будет по-татарски \"дом\"?", "Йорт"
				, "Урам", "Парк", "Музей", null, 1));
		list.add(new QuestionTatarLanguage(null,"СЧто обозначает слово \"бәхет\" на татарском языке?", "Счастье"
				, "Грусть", "Печаль", "Раздражение", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какой из этих глаголов переводится на татарский язык как \"идти\"?", "Барырга"
				, "Бегать", "Петь", "Танцевать", null, 1));
		list.add(new QuestionTatarLanguage(null,"В татарском языке, какое окончание имеет слово \"китапханә\"?", "-сыз/-сез"
				, "-лык/-лек", "-да/-дә", "-ты/-те", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какое из данных слов не является числительным?", "Бер"
				, "Егерме", "Биш", "Ун", null, 1));
		list.add(new QuestionTatarLanguage(null,"С каким звуком на конце слова буквы \"к\" и \"г\" в татарском языке произносятся мягко?", "Л"
				, "Н", "М", "Р", null, 1));
		list.add(new QuestionTatarLanguage(null,"Какой гласный звук в татарском языке отличается от русского отсутствием ударения?", "А"
				, "О", "Ы", "Э", null, 1));
		list.add(new QuestionTatarLanguage(null,"Как по-татарски называется столица Татарстана?", "Казан"
				, "Москва", "Санкт-Петербург", "Екатеринбург", null, 1));
		
		Collections.shuffle(list);
		
		return list;
	}
}
