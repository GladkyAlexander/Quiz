package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.database.DatabaseAdapterFon;
import ru.great_larder.sportquiz.domain.Fon;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.Objects;

public class FragmentDialogBuy extends DialogFragment implements View.OnClickListener {
    
    TextView textViewBuy;
    Integer img, idFon;
    DialogFragment dialogFragment;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container
        , @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View root = inflater.inflate(R.layout.fragment_dialog_buy, null);
        
        Objects.requireNonNull(getDialog()).setTitle("Title!");
        root.findViewById(R.id.btnYesBuy).setOnClickListener(this);
        root.findViewById(R.id.btnNoBuy).setOnClickListener(this);
        textViewBuy = root.findViewById(R.id.textViewBuy);
        
        textViewBuy.setText("Купить ?");
        
        dialogFragment = new FragmentDialog();
        
        assert getArguments() != null;
        img = getArguments().getInt("numberImage");
        idFon = getArguments().getInt("idFon");
        
        return root;
    }
    
    @Override
    public void onClick(View v) {
        dismiss();
    }
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        buyFon();
    }
    
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
    private void buyFon(){
        
        User u = GlobalLinkUser.getUser();
        
        GetFon getFon = new GetFonImpl();
        Fon f = getFon.getFonById(idFon);
        u.setThemeInstalledNow(f.getImageI());
        u.setGlasses(u.getGlasses() - f.getPrice());
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(requireActivity());
        databaseAdapter.open();
        databaseAdapter.update(u);
        databaseAdapter.close();
        GlobalLinkUser.setUser(u);
        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
        
       
    }
}
