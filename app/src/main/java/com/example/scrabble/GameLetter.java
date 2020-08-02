package com.example.scrabble;

import java.util.Objects;

public class GameLetter {
    private int imageId;
    private char letter;
    private int points;

    public GameLetter() {
        letter = '-';
        imageId = R.drawable.cell;
        points = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameLetter letter1 = (GameLetter) o;
        return imageId == letter1.imageId &&
                letter == letter1.letter &&
                points == letter1.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, letter, points);
    }

    public GameLetter(char letter) {
        this.letter = letter;
        switch (letter) {
            case ('а'):
                imageId = R.drawable.a;
                points = 1;
                break;
            case ('б'):
                imageId = R.drawable.b;
                points = 3;
                break;
            case ('в'):
                imageId = R.drawable.v;
                points = 2;
                break;
            case ('г'):
                imageId = R.drawable.g;
                points = 3;
                break;
            case ('д'):
                imageId = R.drawable.d;
                points = 2;
                break;
            case ('е'):
                imageId = R.drawable.e;
                points = 1;
                break;
            case ('ё'):
                imageId = R.drawable.e;
                points = 1;
                break;
            case ('ж'):
                imageId = R.drawable.zh;
                points = 5;
                break;
            case ('з'):
                imageId = R.drawable.z;
                points = 5;
                break;
            case ('и'):
                imageId = R.drawable.i;
                points = 1;
                break;
            case ('й'):
                imageId = R.drawable.y;
                points = 4;
                break;
            case ('к'):
                imageId = R.drawable.k;
                points = 2;
                break;
            case ('л'):
                imageId = R.drawable.l;
                points = 2;
                break;
            case ('м'):
                imageId = R.drawable.m;
                points = 2;
                break;
            case ('н'):
                imageId = R.drawable.n;
                points = 1;
                break;
            case ('о'):
                imageId = R.drawable.o;
                points = 1;
                break;
            case ('п'):
                imageId = R.drawable.p;
                points = 2;
                break;
            case ('р'):
                imageId = R.drawable.r;
                points = 2;
                break;
            case ('с'):
                imageId = R.drawable.s;
                points = 2;
                break;
            case ('т'):
                imageId = R.drawable.t;
                points = 2;
                break;
            case ('у'):
                imageId = R.drawable.u;
                points = 3;
                break;
            case ('ф'):
                imageId = R.drawable.f;
                points = 10;
                break;
            case ('х'):
                imageId = R.drawable.kh;
                points = 5;
                break;
            case ('ц'):
                imageId = R.drawable.ts;
                points = 5;
                break;
            case ('ч'):
                imageId = R.drawable.ch;
                points = 5;
                break;
            case ('ш'):
                imageId = R.drawable.sh;
                points = 10;
                break;
            case ('щ'):
                imageId = R.drawable.shch;
                points = 10;
                break;
            case ('ъ'):
                imageId = R.drawable.tz;
                points = 10;
                break;
            case ('ы'):
                imageId = R.drawable.y2;
                points = 5;
                break;
            case ('ь'):
                imageId = R.drawable.mz;
                points = 5;
                break;
            case ('э'):
                imageId = R.drawable.e2;
                points = 8;
                break;
            case ('ю'):
                imageId = R.drawable.yu;
                points = 10;
                break;
            case ('я'):
                imageId = R.drawable.ya;
                points = 4;
                break;
            case ('*'):
                imageId = R.drawable.st;
                points = -1;
                break;
        }
    }

    public int getImageId() {
        return imageId;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

}
