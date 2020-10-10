package com.keddok.katamino.figure;

import com.keddok.katamino.Figure;
import com.keddok.katamino.Vector;

import java.util.List;

import static com.keddok.katamino.Vector.Direction.RIGHT;
import static com.keddok.katamino.Vector.Direction.UP;

/**
 * @author keddok
 * @since 03.10.2020
 */
public class LightGreen extends Figure {
    private List<Figure> variations = List.of(
            new Figure(this.getClass(), Vector.of(UP, 2), Vector.of(UP, 2,1, 1), Vector.of(RIGHT, 1, 2, 2)),
            new Figure(this.getClass(), Vector.of(RIGHT, 2), Vector.of(RIGHT, 2,1, -1), Vector.of(UP, 1, 2, -2)),
            new Figure(this.getClass(), Vector.of(RIGHT, 2), Vector.of(RIGHT, 2,1, 1), Vector.of(UP, 1, 2, 2)),
            new Figure(this.getClass(), Vector.of(UP, 2), Vector.of(UP, 2,1, -1), Vector.of(RIGHT, 1, 2, -1))
    );

    public LightGreen() {
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
