package ru.great_larder.sportquiz.question;

import ru.great_larder.sportquiz.GetQuestion;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.question.load_question.ListBiologyLoad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetQuestionBiologyImpl implements GetQuestion {
    @Override
    public List<Question> getListQuestion(String value) {
        
        if(ListBiologyLoad.getQuestionList() != null && !ListBiologyLoad.getQuestionList().isEmpty()){
            return ListBiologyLoad.getQuestionList();
        } else {
            
            List<Question> list = new ArrayList<>();
            list.add(new Question("Муж овцы?", "Баран"
                , "Козел.", "Овчар.", "Овцебык", null, 1));
            list.add(new Question("Чем питаются колибри?", "Нектаром и мелкими насекомыми"
                , "Цветами и фруктами.", "Мелкой рыбой.", "Семенами трав", null, 1));
            list.add(new Question("Какая бабочка вредит людям тем, что портит одежду?", "Моль"
                , "Капустница", "Махаон", "Огнёвка", "https://vk.com/wall-221127130_12", 1));
            list.add(new Question("Какой рыбы не существует?", "Рыба-плоскогубцы"
                , "Рыба-пила", "Рыба-молот", "Рыба-игла", null, 1));
            list.add(new Question("Какая из этих птиц умеет летать?", "Гусь"
                , "Страус", "Пингвин", "Киви", "https://vk.com/wall-221127130_28", 1));
            list.add(new Question("Как называются молодые рога марала, изюбря и пятнистого оленя?", "Панты"
                , "Пуанты", "Панталоны", "Пенаты", null, 1));
            list.add(new Question("Как называется специальный ящик для содержания пчёл?", "Улей"
                , "Пасечник", "Скворечник", "Конура", "https://vk.com/wall-221127130_29", 1));
            list.add(new Question("У какой птицы самый большой размах крыльев?", "Альбатрос"
                , "Журавль", "Орлан", "Коршун", null, 1));
            list.add(new Question("К каким животным относится морской конёк?", "Рыбы"
                , "Моллюски", "Копытные", "Ракообразные", "https://vk.com/wall-221127130_25", 1));
            list.add(new Question("Кто из этих животных — не насекомое?", "Жужелица"
                , "Богомол", "Зяблик", "Клоп", null, 1));
            list.add(new Question("Динозавр — это?", "Рептилия"
                , "Млекопитающее", "Амфибия", "Насекомое", null, 1));
            list.add(new Question("Какая из этих птиц не улетает на зиму?", "Дятел"
                , "Трясогузка", "Стриж", "Грач", null, 1));
            list.add(new Question("Как называются детёныши коровы?", "Телята"
                , "Жеребята", "Кутята", "Бычата", null, 1));
            list.add(new Question("Какая часть тела помогает кузнечику стрекотать?", "Крылья"
                , "Усики", "Глаза", "Рот", null, 1));
            list.add(new Question("Какие козы бывают в природе?", "Горные"
                , "Полярные", "Летучие", "Морские", null, 1));
            list.add(new Question("Как называются самые крупные рыбы на планете?", "Акулы"
                , "Моржи", "Дельфины", "Киты", "https://vk.com/wall-221127130_26", 1));
            list.add(new Question("Что означает название «птерозавр»?", "Летающий ящер"
                , "Рогатый ящер", "Быстрый охотник", "Рыбоящер", "https://vk.com/wall-221127130_27", 1));
            
            Collections.shuffle(list);
            
            return list;
        }
    }
    
    @Override
    public Question getRandomQuestion(String value) {
        List<Question> list = getListQuestion(null);
        Collections.shuffle(list);
        return list.get(1);
    }
}
