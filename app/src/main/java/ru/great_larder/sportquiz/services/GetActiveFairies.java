package ru.great_larder.sportquiz.services;

import android.content.Context;
import android.widget.ProgressBar;
import ru.great_larder.sportquiz.database.FairiesDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Fairies;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetActiveFairies {
    private final ProgressBar progressBar;
    private final Context context;
    
    
    public GetActiveFairies(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }
    
    public Fairies getFairies(){
        if(context != null){
            FairiesDatabaseAdapter fairiesDatabaseAdapter = new FairiesDatabaseAdapter(context);
            Fairies fairies;
            fairiesDatabaseAdapter.open();
            fairies = fairiesDatabaseAdapter.getFairiesByActive();
            fairiesDatabaseAdapter.close();
            if(fairies != null) {
                int difference = fairies.getPrice() - getDifferenceInDays(fairies.getDateStart());
                if (difference < 0) {
                    fairies.setActivity_fairies(0);
                    fairiesDatabaseAdapter.open();
                    long ret = fairiesDatabaseAdapter.update(fairies);
                    fairiesDatabaseAdapter.close();
                    progressBar.setProgress(100);
                    return null;
                } else {
                    progressBar.setProgress((100 / fairies.getPrice()) * (difference));
                    return fairies;
                }
                
            }
            
        }
        return null;
    }
    private int getDifferenceInDays(Date g) {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        try {
            Date dateCurrent = dateFormat.parse(currentDate);
            assert dateCurrent != null;
            assert g != null;
            long milliseconds = dateCurrent.getTime() - g.getTime();
            return (int) (milliseconds / (24 * 60 * 60 * 1000));
        } catch (ParseException e) {
            e.getStackTrace();
        }
        return 0;
    }
}
