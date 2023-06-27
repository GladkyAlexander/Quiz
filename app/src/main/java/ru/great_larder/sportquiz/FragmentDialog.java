package ru.great_larder.sportquiz;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

import java.util.Objects;

public class FragmentDialog extends DialogFragment implements View.OnClickListener {
    
    final String LOG_TAG = "myLogs";
    TextView textView1;
    Integer img, idFon;
    
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container
        , @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        
        @SuppressLint("InflateParams") View root = inflater.inflate(R.layout.fragment_dialog, null);
        
        Objects.requireNonNull(getDialog()).setTitle("Title!");
        root.findViewById(R.id.btnYes).setOnClickListener(this);
        root.findViewById(R.id.btnNo).setOnClickListener(this);
        textView1 = root.findViewById(R.id.textView1);
        
        textView1.setText("Установить в качестве фона?");
        
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
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
        setFon();
        ((MainActivity) requireActivity()).setBackgroundActivity(img);
    }
    
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
    private void setFon(){
        User u = GlobalLinkUser.getUser();
        u.setThemeInstalledNow(idFon);
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(requireActivity());
        databaseAdapter.open();
        databaseAdapter.update(u);
        databaseAdapter.close();
        GlobalLinkUser.setUser(u);
        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(u));
    }
}
