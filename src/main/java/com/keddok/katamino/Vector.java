package com.keddok.katamino;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keddok
 * @since 26.09.2020
 */
public class Vector extends XY {
    private List<XY> cells = new ArrayList<>(5);
    private XY offset;

    private Vector(Direction direction, int length, int startX, int startY) {
        super(startX, startY);

        int offsetX = 0, offsetY = 0;
        switch (direction) {
            case UP:
                offsetY = 1;
                offset = new XY(0, length - 1);
                break;
            case RIGHT:
                offsetX = 1;
                offset = new XY(length - 1, 0);
                break;
        }
        for (int i = 0; i < length; i++) {
            XY cell = new XY(startX + offsetX * i, startY + offsetY * i);
            this.cells.add(cell);
        }
    }

    public static Vector of(Direction direction, int length, int startX, int startY) {
        return new Vector(direction, length, startX, startY);
    }

    public static Vector of(Direction direction, int length, XY startingCell) {
        return Vector.of(direction, length, startingCell.x, startingCell.y);
    }

    public static Vector of(Direction direction, int length) {
        return Vector.of(direction, length, 0, 0);
    }

    public static Vector of(int length) {
        return Vector.of(Direction.UP, length);
    }

    public List<XY> getCells() {
        return cells;
    }

    public XY getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", offset=" + offset +
                '}';
    }

    public enum Direction {
        UP, RIGHT;
    }
}
