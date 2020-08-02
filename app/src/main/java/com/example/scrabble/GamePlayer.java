package com.example.scrabble;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GamePlayer implements View.OnClickListener {

    private boolean isComputer;
    private Set<GameLetter> hand;
    private int score;
    private int cellSize;
    private int margin;
    private LinearLayout handLayout;
    private Context context;
    private ImageView clickedImage;
    private Map<ImageView, GameLetter> imageMap;
    private Set<ImageView> removedImages;
    private boolean changeMode;
    private Set<ImageView> changedImage;

    public GamePlayer(LinearLayout handLayout, Context context, int width) {

        System.out.println(1);

        isComputer = false;
        this.handLayout = handLayout;
        this.context = context;
        changeMode = false;
        cellSize = (int) ((width) / 9);
        margin = (int) (cellSize / 7);
        hand = new HashSet<>();
        score = 0;
        imageMap = new HashMap<>();
        removedImages = new HashSet<>();
        changedImage = new HashSet<>();
    }

    public GamePlayer() {

        System.out.println(2);

        isComputer = true;
        hand = new HashSet<>();
        score = 0;
        imageMap = new HashMap<>();
        removedImages = new HashSet<>();
        changedImage = new HashSet<>();
        changeMode = false;
    }

    private void setClickedImage(ImageView view) {

        System.out.println(3);

        clickedImage = view;
    }

    private void resetClickedImage() {

        System.out.println(4);

        clickedImage = null;
    }

    @Override
    public void onClick(View view) {

        System.out.println(5);

        if (!changeMode) {
            if (clickedImage != null) {
                clickedImage.animate().scaleX(1f).scaleY(1f).setDuration(500);
            }
            if (!clickedImage.equals((ImageView) view)) {
                view.animate().scaleX(1.3f).scaleY(1.3f).setDuration(500);
                setClickedImage((ImageView) view);
            } else {
                resetClickedImage();
            }
        }
        else {
            if (changedImage.contains((ImageView) view)) {
                view.animate().scaleX(1f).scaleY(1f).setDuration(500);
                changedImage.remove((ImageView) view);
            }
            else {
                view.animate().scaleX(1.3f).scaleY(1.3f).setDuration(500);
                changedImage.add((ImageView) view);
            }
        }
    }

    public GameLetter getClickedLetter() {

        System.out.println(6);

        if (clickedImage == null) {
            return null;
        }
        return imageMap.get(clickedImage);
    }

    public void removeClickedImageFromHand() {

        System.out.println(7);

        clickedImage.animate().scaleX(1f).scaleY(1f).setDuration(0);
        handLayout.removeView(clickedImage);
        hand.remove(imageMap.get(clickedImage));
        removedImages.add(clickedImage);
        resetClickedImage();
    }

    public void backLettersFromField() {

        System.out.println(8);

        if (removedImages == null) {
            return;
        }
        for (ImageView item : removedImages) {
            handLayout.addView(item);
        }
        removedImages.clear();
    }

    public void setChangeMode() {

        System.out.println(9);

        changeMode = !changeMode;
    }

    public boolean isChangeMode() {

        System.out.println(10);

        return changeMode;
    }

    public Set<GameLetter> removeChangedImages() {

        System.out.println(11);

        Set<GameLetter> backLetter = new HashSet<>();
        for (ImageView item : changedImage) {
            handLayout.removeView(item);
            hand.remove(imageMap.get(item));
            backLetter.add(imageMap.get(item));
        }
        changedImage.clear();
        return backLetter;
    }

    public int getNumChange() {

        System.out.println(12);

        return changedImage.size();
    }

    //111111111
    public void drawHand() {

        System.out.println(13);

        handLayout.removeAllViews();
        for (GameLetter item : hand) {
            ImageView imageLetter = new ImageView(context);
            imageMap.put(imageLetter, item);
            imageLetter.setImageResource(item.getImageId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cellSize, cellSize);
            layoutParams.setMargins(margin, 2 * margin, margin, 2 * margin);
            imageLetter.setLayoutParams(layoutParams);
            imageLetter.setOnClickListener(this);
            handLayout.addView(imageLetter);
        }
    }

    public Integer getScore() {

        System.out.println(14);

        return score;
    }

    public void setScore(int score) {

        System.out.println(15);

        this.score = score;
    }

    public int handSize() {

        System.out.println(16);

        return hand.size();
    }

    //11111111111111
    public void addLetter(GameLetter lt) {

        System.out.println(17);

        hand.add(lt);
    }

    public void addPoints(int p) {

        System.out.println(18);

        score += p;
    }

    public Set<GameLetter> getHand() {

        System.out.println(19);

        return hand;
    }

    public void setHand(Set<Character> set) {

        System.out.println(20);

        hand.clear();
        for (Character c : set) {
            hand.add(new GameLetter(c));
        }
    }
}
