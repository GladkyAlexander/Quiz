package ru.great_larder.sportquiz;

import ru.great_larder.sportquiz.domain.Fon;

import java.util.List;

public interface GetFon {
    Fon getFonById(Integer id);
    List<Fon> getListFon();
}
