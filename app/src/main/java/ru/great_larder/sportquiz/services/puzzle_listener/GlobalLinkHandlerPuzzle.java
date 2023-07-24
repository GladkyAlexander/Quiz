package ru.great_larder.sportquiz.services.puzzle_listener;

public class GlobalLinkHandlerPuzzle {
    public static HandlerPuzzleListener handlerPuzzleListener;
    
    public static HandlerPuzzleListener getHandlerPuzzleListener() {
        return handlerPuzzleListener;
    }
    
    public static void setHandlerPuzzleListener(HandlerPuzzleListener handlerPuzzleListener) {
        GlobalLinkHandlerPuzzle.handlerPuzzleListener = handlerPuzzleListener;
    }
    
    public GlobalLinkHandlerPuzzle() {
    }
}
