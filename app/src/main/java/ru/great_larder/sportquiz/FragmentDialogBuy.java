package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

public class FragmentDialogBuy extends DialogFragment /*implements View.OnClickListener*/ {
    
    TextView textViewBuy;
    Integer img, idFon;
    
    @SuppressLint("DetachAndAttachSameFragment")
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View root = inflater.inflate(R.layout.fragment_dialog_buy, null);
        
        textViewBuy = root.findViewById(R.id.textViewBuy);
        textViewBuy.setText("Купить ?");
        
        assert getArguments() != null;
        img = getArguments().getInt("numberImage");
        idFon = getArguments().getInt("idFon");
        
        root.findViewById(R.id.btnYesBuy).setOnClickListener(view -> {
            User u = GlobalLinkUser.getUser();
            u.setThemeInstalledNow(idFon);
            GetFon fon = new GetFonImpl();
            u.setGlasses(u.getGlasses() - fon.getFonById(idFon).getPrice());
            DatabaseAdapter databaseAdapter = new DatabaseAdapter(requireActivity());
            databaseAdapter.open();
            databaseAdapter.update(u);
            databaseAdapter.close();
            
            GlobalLinkUser.setUser(u);
            GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
            
            dismiss();
        });
        root.findViewById(R.id.btnNoBuy).setOnClickListener(view -> {
            dismiss();
        });
        
        return root;
    }
    
}
