package ru.great_larder.sportquiz.services.chapters;

import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.Chapter;

import java.util.ArrayList;
import java.util.List;

public class GetChaptersImpl implements GetChapters {
    @Override
    public List<Chapter> getChapters() {
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(new Chapter("Математика", R.drawable.matematica));
        chapters.add(new Chapter("Физика", R.drawable.phizik));
        chapters.add(new Chapter("Биология", R.drawable.biolog));
        chapters.add(new Chapter("География", R.drawable.geografik));
        chapters.add(new Chapter("История", R.drawable.history));
//        chapters.add(new Chapter("Химия", R.drawable.himik));
        
        chapters.add(new Chapter("ПДД", R.drawable.pdd));
        
        chapters.add(new Chapter("Русский язык", R.drawable.ru));
        chapters.add(new Chapter("Английский язык", R.drawable.en));
       /* chapters.add("Китайский язык");
        chapters.add("Немецкий язык");
        chapters.add("Французский язык ");
        chapters.add("Испанский язык");
        chapters.add("Итальянский язык");
        chapters.add("Китайский язык");
        chapters.add("Немецкий язык");
        chapters.add("Французский язык ");
        chapters.add("Испанский язык");
        chapters.add("Итальянский язык");*/
        
        chapters.add(new Chapter("Олимпиада", R.drawable.olimpik));
        /*chapters.add("Водное поло");
        chapters.add("Волейбол");
        chapters.add("Легкая атлетика");
        chapters.add("Гимнастика");
        chapters.add("Хоккей");
        chapters.add("Футбол");
        chapters.add("Фигурное катание");*/
        
        chapters.add(new Chapter("Деловой этикет", R.drawable.business_etiquette));
        chapters.add(new Chapter("Светский этикет", R.drawable.social_etiquette));
        
        chapters.add(new Chapter("Города", R.drawable.city_quiz));
        
        
        
        return chapters;
    }
}
