package com.keddok.katamino;

import java.util.Objects;

/**
 * @author keddok
 * @since 26.09.2020
 */
public class XY {
    public final int x;
    public final int y;

    XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static XY of(int x, int y) {
        return new XY(x, y);
    }

    public XY plus(XY xy) {
        return new XY(this.x + xy.x, this.y + xy.y);
    }

    @Override
    public String toString() {
        return "XY{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XY xy = (XY) o;
        return x == xy.x &&
                y == xy.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
