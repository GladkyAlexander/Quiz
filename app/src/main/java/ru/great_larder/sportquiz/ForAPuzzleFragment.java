package ru.great_larder.sportquiz;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.great_larder.sportquiz.database.PuzzleDatabaseAdapter;
import ru.great_larder.sportquiz.databinding.FragmentForAPuzzleBinding;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.services.puzzle_listener.DataPuzzle;
import ru.great_larder.sportquiz.services.puzzle_listener.GlobalLinkHandlerPuzzle;
import ru.great_larder.sportquiz.services.puzzle_listener.HandlerPuzzleListener;
import ru.great_larder.sportquiz.services.puzzle_listener.ObserverPuzzle;
import ru.great_larder.sportquiz.ui.dialog_puzzle.DialogPuzzleFragment;
import ru.great_larder.sportquiz.ui.gallery.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class ForAPuzzleFragment extends Fragment {
    Puzzle puzzle;
    private ImageView imgP1, imgP2, imgP3, imgP4, imgP5, imgP6, imgP7, imgP8, imgP9, imgP10
        , imgP11, imgP12, imgP13, imgP14, imgP15, imgP16, imgP17, imgP18, imgP19, imgP20
        , imgP21, imgP22, imgP23, imgP24, imgP25, imgP26, imgP27, imgP28, imgP29, imgP30, imgStartForAPuzzle;
    private TextView textP1, textP2, textP3, textP4, textP5, textP6, textP7, textP8, textP9, textP10
        , textP11, textP12, textP13, textP14, textP15, textP16, textP17, textP18, textP19, textP20
        , textP21, textP22, textP23, textP24, textP25, textP26, textP27, textP28, textP29, textP30;
    private FrameLayout frameLayoutPuzzleFr;
    List<ImageView> imageViewList;
    List<TextView> textViewList;
    List<Integer> listDraw;
    List<Integer> listPuzzle;
    List<Integer> listPrice;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FragmentForAPuzzleBinding binding = FragmentForAPuzzleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        
        /*HandlerPuzzleListener handlerPuzzleListener = new HandlerPuzzleListener();
        handlerPuzzleListener.registerObserverPuzzle(this);
        GlobalLinkHandlerPuzzle.setHandlerPuzzleListener(handlerPuzzleListener);*/
        
        imgStartForAPuzzle = binding.imgStartForAPuzzle;
        frameLayoutPuzzleFr = binding.frameLayoutPuzzleFr;
        
        textViewList = new ArrayList<>();
        textViewList.add(textP1 = binding.textP1);
        textViewList.add(textP2 = binding.textP2);
        textViewList.add(textP3 = binding.textP3);
        textViewList.add(textP4 = binding.textP4);
        textViewList.add(textP5 = binding.textP5);
        textViewList.add(textP6 = binding.textP6);
        textViewList.add(textP7 = binding.textP7);
        textViewList.add(textP8 = binding.textP8);
        textViewList.add(textP9 = binding.textP9);
        textViewList.add(textP10 = binding.textP10);
        textViewList.add(textP11 = binding.textP11);
        textViewList.add(textP12 = binding.textP12);
        textViewList.add(textP13 = binding.textP13);
        textViewList.add(textP14 = binding.textP14);
        textViewList.add(textP15 = binding.textP15);
        textViewList.add(textP16 = binding.textP16);
        textViewList.add(textP17 = binding.textP17);
        textViewList.add(textP18 = binding.textP18);
        textViewList.add(textP19 = binding.textP19);
        textViewList.add(textP20 = binding.textP20);
        textViewList.add(textP21 = binding.textP21);
        textViewList.add(textP22 = binding.textP22);
        textViewList.add(textP23 = binding.textP23);
        textViewList.add(textP24 = binding.textP24);
        textViewList.add(textP25 = binding.textP25);
        textViewList.add(textP26 = binding.textP26);
        textViewList.add(textP27 = binding.textP27);
        textViewList.add(textP28 = binding.textP28);
        textViewList.add(textP29 = binding.textP29);
        textViewList.add(textP30 = binding.textP30);
        
        imageViewList = new ArrayList<>();
        imageViewList.add(imgP1 = binding.imgP1);
        imageViewList.add(imgP2 = binding.imgP2);
        imageViewList.add(imgP3 = binding.imgP3);
        imageViewList.add(imgP4 = binding.imgP4);
        imageViewList.add(imgP5 = binding.imgP5);
        imageViewList.add(imgP6 = binding.imgP6);
        imageViewList.add(imgP7 = binding.imgP7);
        imageViewList.add(imgP8 = binding.imgP8);
        imageViewList.add(imgP9 = binding.imgP9);
        imageViewList.add(imgP10 = binding.imgP10);
        imageViewList.add(imgP11 = binding.imgP11);
        imageViewList.add(imgP12 = binding.imgP12);
        imageViewList.add(imgP13 = binding.imgP13);
        imageViewList.add(imgP14 = binding.imgP14);
        imageViewList.add(imgP15 = binding.imgP15);
        imageViewList.add(imgP16 = binding.imgP16);
        imageViewList.add(imgP17 = binding.imgP17);
        imageViewList.add(imgP18 = binding.imgP18);
        imageViewList.add(imgP19 = binding.imgP19);
        imageViewList.add(imgP20 = binding.imgP20);
        imageViewList.add(imgP21 = binding.imgP21);
        imageViewList.add(imgP22 = binding.imgP22);
        imageViewList.add(imgP23 = binding.imgP23);
        imageViewList.add(imgP24 = binding.imgP24);
        imageViewList.add(imgP25 = binding.imgP25);
        imageViewList.add(imgP26 = binding.imgP26);
        imageViewList.add(imgP27 = binding.imgP27);
        imageViewList.add(imgP28 = binding.imgP28);
        imageViewList.add(imgP29 = binding.imgP29);
        imageViewList.add(imgP30 = binding.imgP30);
        
        listDraw = new ArrayList<>();
        listDraw.add(R.drawable.pazl_reverse1);
        listDraw.add(R.drawable.pazl_reverse2);
        listDraw.add(R.drawable.pazl_reverse3);
        listDraw.add(R.drawable.pazl_reverse4);
        listDraw.add(R.drawable.pazl_reverse5);
        listDraw.add(R.drawable.pazl_reverse6);
        listDraw.add(R.drawable.pazl_reverse7);
        listDraw.add(R.drawable.pazl_reverse8);
        listDraw.add(R.drawable.pazl_reverse9);
        listDraw.add(R.drawable.pazl_reverse10);
        listDraw.add(R.drawable.pazl_reverse11);
        listDraw.add(R.drawable.pazl_reverse12);
        listDraw.add(R.drawable.pazl_reverse13);
        listDraw.add(R.drawable.pazl_reverse14);
        listDraw.add(R.drawable.pazl_reverse15);
        listDraw.add(R.drawable.pazl_reverse16);
        listDraw.add(R.drawable.pazl_reverse17);
        listDraw.add(R.drawable.pazl_reverse18);
        listDraw.add(R.drawable.pazl_reverse19);
        listDraw.add(R.drawable.pazl_reverse20);
        listDraw.add(R.drawable.pazl_reverse21);
        listDraw.add(R.drawable.pazl_reverse22);
        listDraw.add(R.drawable.pazl_reverse23);
        listDraw.add(R.drawable.pazl_reverse24);
        listDraw.add(R.drawable.pazl_reverse25);
        listDraw.add(R.drawable.pazl_reverse26);
        listDraw.add(R.drawable.pazl_reverse27);
        listDraw.add(R.drawable.pazl_reverse28);
        listDraw.add(R.drawable.pazl_reverse29);
        listDraw.add(R.drawable.pazl_reverse30);
        
        Bundle bundle = this.getArguments();
        if (bundle != null){
            PuzzleDatabaseAdapter adapter = new PuzzleDatabaseAdapter(requireActivity());
            adapter.open();
            puzzle = adapter.getPuzzleById(bundle.getInt("getPuzzleId"));
            adapter.close();
            loadFragment(puzzle);
        }
        
        return root;
    }
    
    public void loadFragment(Puzzle puzz) {
            if (GlobalLinkUser.getUser() != null && puzz != null) {
                frameLayoutPuzzleFr.removeAllViews();
                imgStartForAPuzzle.setImageResource(puzz.getId_drawable_resource());
                frameLayoutPuzzleFr.addView(imgStartForAPuzzle);
                
                listPuzzle = new ArrayList<>();
                listPuzzle.add(getPaz(puzz.isPuzzle1()));
                listPuzzle.add(getPaz(puzz.isPuzzle2()));
                listPuzzle.add(getPaz(puzz.isPuzzle3()));
                listPuzzle.add(getPaz(puzz.isPuzzle4()));
                listPuzzle.add(getPaz(puzz.isPuzzle5()));
                listPuzzle.add(getPaz(puzz.isPuzzle6()));
                listPuzzle.add(getPaz(puzz.isPuzzle7()));
                listPuzzle.add(getPaz(puzz.isPuzzle8()));
                listPuzzle.add(getPaz(puzz.isPuzzle9()));
                listPuzzle.add(getPaz(puzz.isPuzzle10()));
                listPuzzle.add(getPaz(puzz.isPuzzle11()));
                listPuzzle.add(getPaz(puzz.isPuzzle12()));
                listPuzzle.add(getPaz(puzz.isPuzzle13()));
                listPuzzle.add(getPaz(puzz.isPuzzle14()));
                listPuzzle.add(getPaz(puzz.isPuzzle15()));
                listPuzzle.add(getPaz(puzz.isPuzzle16()));
                listPuzzle.add(getPaz(puzz.isPuzzle17()));
                listPuzzle.add(getPaz(puzz.isPuzzle18()));
                listPuzzle.add(getPaz(puzz.isPuzzle19()));
                listPuzzle.add(getPaz(puzz.isPuzzle20()));
                listPuzzle.add(getPaz(puzz.isPuzzle21()));
                listPuzzle.add(getPaz(puzz.isPuzzle22()));
                listPuzzle.add(getPaz(puzz.isPuzzle23()));
                listPuzzle.add(getPaz(puzz.isPuzzle24()));
                listPuzzle.add(getPaz(puzz.isPuzzle25()));
                listPuzzle.add(getPaz(puzz.isPuzzle26()));
                listPuzzle.add(getPaz(puzz.isPuzzle27()));
                listPuzzle.add(getPaz(puzz.isPuzzle28()));
                listPuzzle.add(getPaz(puzz.isPuzzle29()));
                listPuzzle.add(getPaz(puzz.isPuzzle30()));
                
                listPrice = new ArrayList<>();
                listPrice.add(puzz.getPrice1());
                listPrice.add(puzz.getPrice2());
                listPrice.add(puzz.getPrice3());
                listPrice.add(puzz.getPrice4());
                listPrice.add(puzz.getPrice5());
                listPrice.add(puzz.getPrice6());
                listPrice.add(puzz.getPrice7());
                listPrice.add(puzz.getPrice8());
                listPrice.add(puzz.getPrice9());
                listPrice.add(puzz.getPrice10());
                listPrice.add(puzz.getPrice11());
                listPrice.add(puzz.getPrice12());
                listPrice.add(puzz.getPrice13());
                listPrice.add(puzz.getPrice14());
                listPrice.add(puzz.getPrice15());
                listPrice.add(puzz.getPrice16());
                listPrice.add(puzz.getPrice17());
                listPrice.add(puzz.getPrice18());
                listPrice.add(puzz.getPrice19());
                listPrice.add(puzz.getPrice20());
                listPrice.add(puzz.getPrice21());
                listPrice.add(puzz.getPrice22());
                listPrice.add(puzz.getPrice23());
                listPrice.add(puzz.getPrice24());
                listPrice.add(puzz.getPrice25());
                listPrice.add(puzz.getPrice26());
                listPrice.add(puzz.getPrice27());
                listPrice.add(puzz.getPrice28());
                listPrice.add(puzz.getPrice29());
                listPrice.add(puzz.getPrice30());
                
                for (ImageView k : imageViewList) {
                    k.setImageResource(listDraw.get(imageViewList.indexOf(k)));
                    textViewList.get(imageViewList.indexOf(k)).setText(String.valueOf(listPrice.get(imageViewList.indexOf(k))));
                    if (listPuzzle.get(imageViewList.indexOf(k)) == 0) {
                        ImageView im = new ImageView(requireActivity());
                        im.setImageResource(listDraw.get(imageViewList.indexOf(k)));
                        im.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                        frameLayoutPuzzleFr.addView(im);
                    }
                    k.setOnClickListener(t -> {
                        Bundle args = new Bundle();
                        args.putInt("idPuzzle", puzz.getId());
                        args.putInt("idP", imageViewList.indexOf(k));
                        args.putInt("price", listPrice.get(imageViewList.indexOf(k)));
                        DialogFragment dialogFragment = new DialogPuzzleFragment();
                        dialogFragment.setArguments(args);
                        dialogFragment.show(getChildFragmentManager(), "dlg 1");
                    });
                }
            }
    }
    private Integer getPaz(boolean v){
        if (v){return 1;} else {return 0;}
    }
    public void updateFr(Puzzle puzzle) {
        this.puzzle = puzzle;
        loadFragment(puzzle);
    }
    
}