package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {
        if (this.value < 16) {
            return new Color(0x776e65);
        } else {
            return new Color(0xf9f6f2);
        }
    }

    public Color getTileColor() {
        int i;
        switch (this.value) {
            case 0:
                i=0xcdc1b4;
                break;
            case 2:
                i=0xeee4da;
                break;
            case 4:
                i=0xede0c8;
                break;
            case 8:
                i=0xf2b179;
                break;
            case 16:
                i=0xf59563;
                break;
            case 32:
                i=0xf67c5f;
                break;
            case 64:
                i=0xf65e3b;
                break;
            case 128:
                i=0xedcf72;
                break;
            case 256:
                i=0xedcc61;
                break;
            case 512:
                i=0xedc850;
                break;
            case 1024:
                i=0xedc53f;
                break;
            case 2048:
                i=0xedc22e;
                break;
            default:
                i = 0xff0000;
        }
        return new Color(i);
    }
}
