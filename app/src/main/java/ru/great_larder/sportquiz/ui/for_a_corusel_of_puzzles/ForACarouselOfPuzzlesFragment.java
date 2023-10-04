package ru.great_larder.sportquiz.ui.for_a_corusel_of_puzzles;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.database.PuzzleDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class ForACarouselOfPuzzlesFragment extends Fragment {
    ImageView imgPZL;
    FrameLayout fl;
    Puzzle puzzle;
    PuzzleDatabaseAdapter adapter;
    Integer idPuzzle;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_for_a_carousel_of_puzzles, container, false);
        imgPZL = root.findViewById(R.id.imgPZL);
        fl = root.findViewById(R.id.fl);
        adapter = new PuzzleDatabaseAdapter(requireActivity());
        if(getArguments() != null){
            idPuzzle = getArguments().getInt("idPuzzle");
            adapter.open();
            puzzle = adapter.getPuzzleById(idPuzzle);
            adapter.close();
            loadFragment();
        }
        
        return root;
    }
    
    private void loadFragment() {
        if(puzzle != null){
            fl.removeAllViews();
            imgPZL.setImageResource(puzzle.getId_drawable_resource());
            fl.addView(imgPZL);
            
            List<ImageView> imageViewList = getListImg(puzzle);
            
            for (ImageView im : imageViewList){
                fl.addView(im);
            }
        }
    }
    private List<ImageView> getListImg(Puzzle p){
        List<ImageView> imageViewList = new ArrayList<>();
        if(!p.isPuzzle1()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse1);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle2()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse2);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle3()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse3);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle4()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse4);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle5()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse5);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle6()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse6);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle7()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse7);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle8()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse8);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle9()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse9);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle10()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse10);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle11()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse11);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle12()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse12);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle13()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse13);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle14()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse14);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle15()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse15);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle16()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse16);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle17()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse17);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle18()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse18);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle19()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse19);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle20()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse20);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle21()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse21);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle22()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse22);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle23()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse23);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle24()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse24);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle25()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse25);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle26()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse26);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle27()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse27);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle28()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse28);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle29()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse29);
            imageViewList.add(imageView);
        }
        if(!p.isPuzzle30()){
            ImageView imageView = new ImageView(requireActivity());
            imageView.setImageResource(R.drawable.pazl_reverse30);
            imageViewList.add(imageView);
        }
        return imageViewList;
    }
}