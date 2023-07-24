package ru.great_larder.sportquiz.services.fairies;

import ru.great_larder.sportquiz.domain.Fairies;

import java.util.List;

public interface GetFairies {
    Fairies getFairiesById(Integer id);
    List<Fairies> getListFairies();
}
