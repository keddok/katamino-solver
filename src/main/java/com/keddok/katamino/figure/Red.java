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
public class Red extends Figure {
    private List<Figure> variations = List.of(
            new Figure(this.getClass(), Vector.of(RIGHT, 3), Vector.of(UP, 3,1, -1))
    );

    public Red() {
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
