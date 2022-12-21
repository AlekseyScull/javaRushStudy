package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        this.score = 0;
        this.maxTile = 0;
        resetGameTiles();
    }

    Tile[][] getGameTiles() {
        return gameTiles;
    }

    boolean canMove() {
        return getEmptyTiles().size() > 0 || hasPairToMerge();
    }

    private boolean hasPairToMerge() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.value != 0) {
                    if (j < FIELD_WIDTH - 1 && tile.value == gameTiles[i][j + 1].value)
                        return true;
                    else if (i < FIELD_WIDTH - 1 && tile.value == gameTiles[i + 1][j].value)
                        return true;
                }
            }
        }
        return false;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            Tile randomTile = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            randomTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                if (tile.isEmpty()) list.add(tile);
            }
        }
        return list;
    }

    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean b = false;
        for (int i = 0; i < tiles.length; i++) {
            Tile tile = tiles[i];
            if (!tile.isEmpty() && i > 0) {
                for (int j = 0; j < i; j++) {
                    Tile t = tiles[j];
                    if (t.isEmpty()) {
                        t.value = tile.value;
                        tile.value = 0;
                        b = true;
                    }
                }
            }
        }
        return b;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (!tiles[i].isEmpty()) {
                Tile t = tiles[i];
                Tile nextT = tiles[i + 1];
                if (t.value == nextT.value) {
                    t.value *= 2;
                    score += t.value;
                    nextT.value = 0;
                    isMerged = true;
                    if (t.value > maxTile) maxTile = t.value;
                }
            }
        }
        compressTiles(tiles);
        return isMerged;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] copy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                copy[i][j] = new Tile(tiles[i][j].value);
            }
        }

        previousStates.push(copy);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private void rotate(Tile[][] tiles) {
        Tile[][] rotated = new Tile[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                rotated[tiles.length - 1 - j][i] = tiles[i][j];
            }
        }
        gameTiles = rotated;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean flag = false;
        for (Tile[] gameRow : gameTiles) {
            if (compressTiles(gameRow) | mergeTiles(gameRow)) flag = true;
        }
        if (flag) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
    }

    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                down();
                break;
            case 3:
                up();
                break;
        }
    }

    public boolean hasBoardChanged() {
        int currentWeight = 0;
        int prevWeight = 0;
        for (Tile[] gameRow : gameTiles) {
            for (Tile tile : gameRow) {
                if (!tile.isEmpty()) {
                    currentWeight += tile.value;
                }
            }
        }
        for (Tile[] prevRow : previousStates.peek()) {
            for (Tile tile : prevRow) {
                if (!tile.isEmpty()) {
                    prevWeight += tile.value;
                }
            }
        }
        return currentWeight != prevWeight;
    }

    public MoveEfficiency getMoveEfficiency (Move move) {
        move.move();
        MoveEfficiency me = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) return new MoveEfficiency(-1, 0, move);
        rollback();
        return me;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::down));
        assert priorityQueue.peek() != null;
        priorityQueue.peek().getMove().move();
    }
}
