package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.domain.QuestionChuvashLanguage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionChuvashLanguageInside {
	public List<QuestionChuvashLanguage> getListQuestion(String value) {
		List<QuestionChuvashLanguage> list = new ArrayList<>();
		
		list.add(new QuestionChuvashLanguage(null,"К какой языковой группе относится чувашский язык?", "тюркской"
				, "финно-угорской", "славянской", "романской", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Как по-чувашски сказать «спасибо»?", "тавтапуç"
				, "тархасшăн", "сывлăх сунатăп", "ырă кун пултăр", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Ученый-тюрколог, основоположник чувашского языкознания, автор 17-томного издания «Словарь чувашского языка».", "Николай Иванович Ашмарин"
				, "Иван Яковлевич Яковлев", "Никита Яковлевич Бичурин", "Николай Иванович Золотницкий", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Язык, родственный чувашскому:", "татарский"
				, "русский", "мордовский", "марийский", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Какая буква не встречается в начале чувашских слов?", "Д"
				, "Ы", "Т", "Ă", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Как в чувашском языке называется бабушка со стороны отца?", "асанне"
				, "асатте", "кукамай", "кукаçи", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Весенний праздник чувашей, посвященный завершению посевных работ.", "Акатуй"
				, "Сабантуй", "Çăварни", "Кĕр сăри", null, 1));
		list.add(new QuestionChuvashLanguage(null,"Укажите чувашское блюдо.", "хуплу"
				, "хинкали", "чак-чак", "пахлава", null, 1));
		
		Collections.shuffle(list);
		
		return list;
	}
}
