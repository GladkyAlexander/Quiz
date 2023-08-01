package ru.great_larder.sportquiz.ui.dialog_puzzle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.great_larder.sportquiz.*;
import ru.great_larder.sportquiz.database.DatabaseAdapter;
import ru.great_larder.sportquiz.database.PuzzleDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.domain.User;
import ru.great_larder.sportquiz.services.user_listener.DataUser;

public class DialogPuzzleFragment extends DialogFragment {
    TextView textViewOnTheAccount;
    Button btnYesBuyPuzzle, btnNoBuyPuzzle;
    Puzzle puzzle;
    int idPuzzle;
    PuzzleDatabaseAdapter adapter;
    DatabaseAdapter userAdapter;
    int price;
    private ForAPuzzleFragment forAPuzzleFragment;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View root = inflater.inflate(R.layout.fragment_dialog_puzzle, container, false);
        adapter = new PuzzleDatabaseAdapter(requireActivity());
        userAdapter = new DatabaseAdapter(requireActivity());
        textViewOnTheAccount = root.findViewById(R.id.textViewOnTheAccount);
        btnNoBuyPuzzle = root.findViewById(R.id.btnNoBuyPuzzle);
        btnYesBuyPuzzle = root.findViewById(R.id.btnYesBuyPuzzle);
        if(getArguments() != null){
            idPuzzle = getArguments().getInt("idP");
            price = getArguments().getInt("price");
            adapter.open();
            puzzle = adapter.getPuzzleById(getArguments().getInt("idPuzzle"));
            adapter.close();
        }
        if(GlobalLinkUser.getUser() != null){
            textViewOnTheAccount.setText(String.valueOf(GlobalLinkUser.getUser().getGlasses()));
        }
        
        btnYesBuyPuzzle.setOnClickListener(view -> {
            if(GlobalLinkUser.getUser() != null && puzzle != null) {
                
                updatePuzzle(idPuzzle);
                Integer f;
                if(GlobalLinkUser.getUser().getGlasses() >= price) {
                    adapter.open();
                    f = adapter.update(puzzle);
                    adapter.close();
                    if (f != null) {
                        User us = GlobalLinkUser.getUser();
                        us.setGlasses(us.getGlasses() - price);
                        userAdapter.open();
                        userAdapter.update(us);
                        userAdapter.close();
                        GlobalLinkUser.getHandlerUserListener().onNewDataUser(new DataUser(us));
                        dismiss();
                    }
                } else {
                    Toast.makeText(requireActivity(), "Не достаточно Виктиков!", Toast.LENGTH_LONG).show();
                    dismiss();
                }
            } else { dismiss();}
        });
        btnNoBuyPuzzle.setOnClickListener(view -> {
            dismiss();
        });
        return root;
    }
    private void updatePuzzle(int value){
        
        if(value == 0){puzzle.setPuzzle1(true);
        } else if(value == 1) {puzzle.setPuzzle2(true);
        } else if(value == 2) {puzzle.setPuzzle3(true);
        } else if(value == 3) {puzzle.setPuzzle4(true);
        } else if(value == 4) {puzzle.setPuzzle5(true);
        } else if(value == 5) {puzzle.setPuzzle6(true);
        } else if(value == 6) {puzzle.setPuzzle7(true);
        } else if(value == 7) {puzzle.setPuzzle8(true);
        } else if(value == 8) {puzzle.setPuzzle9(true);
        } else if(value == 9) {puzzle.setPuzzle10(true);
        } else if(value == 10) {puzzle.setPuzzle11(true);
        } else if(value == 11) {puzzle.setPuzzle12(true);
        } else if(value == 12) {puzzle.setPuzzle13(true);
        } else if(value == 13) {puzzle.setPuzzle14(true);
        } else if(value == 14) {puzzle.setPuzzle15(true);
        } else if(value == 15) {puzzle.setPuzzle16(true);
        } else if(value == 16) {puzzle.setPuzzle17(true);
        } else if(value == 17) {puzzle.setPuzzle18(true);
        } else if(value == 18) {puzzle.setPuzzle19(true);
        } else if(value == 19) {puzzle.setPuzzle20(true);
        } else if(value == 20) {puzzle.setPuzzle21(true);
        } else if(value == 21) {puzzle.setPuzzle22(true);
        } else if(value == 22) {puzzle.setPuzzle23(true);
        } else if(value == 23) {puzzle.setPuzzle24(true);
        } else if(value == 24) {puzzle.setPuzzle25(true);
        } else if(value == 25) {puzzle.setPuzzle26(true);
        } else if(value == 26) {puzzle.setPuzzle27(true);
        } else if(value == 27) {puzzle.setPuzzle28(true);
        } else if(value == 28) {puzzle.setPuzzle29(true);
        } else if(value == 29) {puzzle.setPuzzle30(true);
        }
 }
}