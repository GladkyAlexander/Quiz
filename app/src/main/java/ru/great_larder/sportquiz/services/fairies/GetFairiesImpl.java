package ru.great_larder.sportquiz.services.fairies;

import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.Fairies;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetFairiesImpl implements GetFairies{
    @Override
    public Fairies getFairiesById(Integer id) {
        for (Fairies f : getListFairies()){
            if(Objects.equals(id, f.getId())) return f;
        }
        return null;
    }
    
    @Override
    public List<Fairies> getListFairies() {
        List<Fairies> fonList = new ArrayList<>();
        
        fonList.add(new Fairies(1, null, "---", 5, R.drawable.fairies1, new Date(System.currentTimeMillis()), 5, 0));
        fonList.add(new Fairies(2, null, "---", 10, R.drawable.fairies2, new Date(System.currentTimeMillis()), 10, 0));
        fonList.add(new Fairies(3, null, "---", 15, R.drawable.fairies3, new Date(System.currentTimeMillis()), 15, 0));
        fonList.add(new Fairies(4, null, "---", 20, R.drawable.fairies4, new Date(System.currentTimeMillis()), 20, 0));
        fonList.add(new Fairies(5, null, "---", 25, R.drawable.fairies5, new Date(System.currentTimeMillis()), 25, 0));
        fonList.add(new Fairies(6, null, "---", 30, R.drawable.fairies6, new Date(System.currentTimeMillis()), 30, 0));
        fonList.add(new Fairies(7, null, "---", 35, R.drawable.fairies7, new Date(System.currentTimeMillis()), 35, 0));
        fonList.add(new Fairies(8, null, "---", 40, R.drawable.fairies8, new Date(System.currentTimeMillis()), 35, 0));
        fonList.add(new Fairies(9, null, "---", 45, R.drawable.fairies9, new Date(System.currentTimeMillis()), 45, 0));
        fonList.add(new Fairies(10, null, "---", 50, R.drawable.fairies10, new Date(System.currentTimeMillis()), 50, 0));
        fonList.add(new Fairies(11, null, "---", 55, R.drawable.fairies11, new Date(System.currentTimeMillis()), 55, 0));
        fonList.add(new Fairies(12, null, "---", 60, R.drawable.fairies12, new Date(System.currentTimeMillis()), 60, 0));
        
        return fonList;
    }
}
