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
public class Brown extends Figure {
    private List<Figure> variations = List.of(
            new Figure(this.getClass(), Vector.of(RIGHT, 4), Vector.of(UP, 1,1, 1)),
            new Figure(this.getClass(), Vector.of(UP,4), Vector.of(RIGHT,1,1,2)),
            new Figure(this.getClass(), Vector.of(RIGHT,4), Vector.of(UP,1,2,-1)),
            new Figure(this.getClass(), Vector.of(RIGHT,1), Vector.of(UP,4,1,-1)),
            new Figure(this.getClass(), Vector.of(RIGHT,4), Vector.of(UP,1,1,-1)),
            new Figure(this.getClass(), Vector.of(RIGHT,1), Vector.of(UP,4,1,-2)),
            new Figure(this.getClass(), Vector.of(RIGHT,4), Vector.of(UP,1,2,1)),
            new Figure(this.getClass(), Vector.of(UP,4), Vector.of(RIGHT,1,1,1))
    );

    public Brown() {
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
