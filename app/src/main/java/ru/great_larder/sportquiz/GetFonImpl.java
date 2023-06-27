package ru.great_larder.sportquiz;

import ru.great_larder.sportquiz.domain.Fon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetFonImpl implements GetFon{
    @Override
    public Fon getFonById(Integer id) {
        for (Fon f : getListFon()){
            if(Objects.equals(id, f.getId())) return f;
        }
        return null;
    }
    
    @Override
    public List<Fon> getListFon() {
        List<Fon> fonList = new ArrayList<>();
        
        Fon fon1 = new Fon();
        fon1.setId(1);
        fon1.setName("fon1");
        fon1.setPrice(5);
        fon1.setImageI(R.drawable.fon1);
        
        Fon fon2 = new Fon();
        fon2.setId(2);
        fon2.setName("fon2");
        fon2.setPrice(10);
        fon2.setImageI(R.drawable.fon2);
        
        Fon fon3 = new Fon();
        fon3.setId(3);
        fon3.setName("fon3");
        fon3.setPrice(15);
        fon3.setImageI(R.drawable.fon3);
        
        Fon fon4 = new Fon();
        fon4.setId(4);
        fon4.setName("fon4");
        fon4.setPrice(20);
        fon4.setImageI(R.drawable.fon4);
        
        Fon fon5 = new Fon();
        fon5.setId(5);
        fon5.setName("fon5");
        fon5.setPrice(25);
        fon5.setImageI(R.drawable.fon5);
        
        Fon fon6 = new Fon();
        fon6.setId(6);
        fon6.setName("fon6");
        fon6.setPrice(30);
        fon6.setImageI(R.drawable.fon6);
        
        Fon fon7 = new Fon();
        fon7.setId(7);
        fon7.setName("fon7");
        fon7.setPrice(35);
        fon7.setImageI(R.drawable.fon7);
        
        Fon fon8 = new Fon();
        fon8.setId(8);
        fon8.setName("fon8");
        fon8.setPrice(40);
        fon8.setImageI(R.drawable.fon8);
        
        Fon fon9 = new Fon();
        fon9.setId(9);
        fon9.setName("fon9");
        fon9.setPrice(45);
        fon9.setImageI(R.drawable.fon9);
        
        fonList.add(fon1);
        fonList.add(fon2);
        fonList.add(fon3);
        fonList.add(fon4);
        fonList.add(fon5);
        fonList.add(fon6);
        fonList.add(fon7);
        fonList.add(fon8);
        fonList.add(fon9);
        return fonList;
    }
    
}
