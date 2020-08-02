package com.example.scrabble;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GameBag {

    private Map<GameLetter, Integer> bag = new HashMap<>();
    private int num = 131;

    public GameBag() {
        bag.put(new GameLetter('а'), 10);
        bag.put(new GameLetter('б'), 3);
        bag.put(new GameLetter('в'), 5);
        bag.put(new GameLetter('г'), 3);
        bag.put(new GameLetter('д'), 5);
        bag.put(new GameLetter('е'), 9);
        bag.put(new GameLetter('ж'), 2);
        bag.put(new GameLetter('з'), 2);
        bag.put(new GameLetter('и'), 8);
        bag.put(new GameLetter('й'), 4);
        bag.put(new GameLetter('к'), 6);
        bag.put(new GameLetter('л'), 4);
        bag.put(new GameLetter('м'), 5);
        bag.put(new GameLetter('н'), 8);
        bag.put(new GameLetter('о'), 10);
        bag.put(new GameLetter('п'), 6);
        bag.put(new GameLetter('р'), 6);
        bag.put(new GameLetter('с'), 6);
        bag.put(new GameLetter('т'), 5);
        bag.put(new GameLetter('у'), 3);
        bag.put(new GameLetter('ф'), 1);
        bag.put(new GameLetter('х'), 2);
        bag.put(new GameLetter('ц'), 1);
        bag.put(new GameLetter('ч'), 2);
        bag.put(new GameLetter('ш'), 1);
        bag.put(new GameLetter('щ'), 1);
        bag.put(new GameLetter('ъ'), 1);
        bag.put(new GameLetter('ы'), 2);
        bag.put(new GameLetter('ь'), 2);
        bag.put(new GameLetter('э'), 1);
        bag.put(new GameLetter('ю'), 1);
        bag.put(new GameLetter('я'), 3);
        bag.put(new GameLetter('*'), 3);
    }

    public GameLetter getLetter() {
        if (bag.size() == 0) {
            return null;
        }
        int idx = new Random().nextInt(num) + 1;
        int i = 0;
        for(Map.Entry<GameLetter, Integer> item : bag.entrySet()) {
            i += item.getValue();
            if (i >= idx) {
                if (item.getValue() > 1) {
                    item.setValue(item.getValue() - 1);
                }
                else {
                    bag.remove(item);
                }
                --num;
                return item.getKey();
            }
        }
        return new GameLetter();
    }

    public void backLetter(Set<GameLetter> backSet) {
        for (GameLetter item : backSet) {
            bag.put(item, bag.get(item) + 1);
        }
    }

    public Map<GameLetter, Integer> getBag() {
        return bag;
    }
}
