package com.keddok.katamino;

import org.junit.Test;

import java.util.List;

/**
 * @author keddok
 * @since 10.10.2020
 */
public class VectorTest {

    @Test
    public void getCells() {
        Vector vector = Vector.of(Vector.Direction.RIGHT, 3, 1, 1);
        List<XY> checkCells = List.of(XY.of(1, 1), XY.of(2, 1), XY.of(3, 1));

        assert checkCells.equals(vector.getCells());
    }

    @Test
    public void getOffset() {
        Vector vector = Vector.of(Vector.Direction.RIGHT, 3, 1, 1);

        assert vector.getOffset().x == 2 && vector.getOffset().y == 0;
    }
}