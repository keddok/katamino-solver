package com.keddok.katamino;

import java.util.Arrays;
import java.util.List;

/**
 * @author keddok
 * @since 26.09.2020
 */
public class Figure {
    private final Vector[] vectors;
    public final Class<? extends Figure> parentClass;

    public Figure(Vector... vectors) {
        this.parentClass = Figure.class;
        this.vectors = vectors;
    }

    public Figure(Class<? extends Figure> parentClass, Vector... vectors) {
        this.parentClass = parentClass;
        this.vectors = vectors;
    }

    public Vector[] getVectors() {
        return vectors;
    }

    public List<Figure> getVariations() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Figure{" +
                parentClass.getSimpleName() +
                ", vectors=" + Arrays.toString(vectors) +
                "}\n";
    }
}
