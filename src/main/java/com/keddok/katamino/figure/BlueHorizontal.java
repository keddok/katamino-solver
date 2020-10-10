package com.keddok.katamino.figure;

import com.keddok.katamino.Figure;
import com.keddok.katamino.Vector;

import java.util.List;

import static com.keddok.katamino.Vector.Direction.RIGHT;

/**
 * @author keddok
 * @since 03.10.2020
 */
public class BlueHorizontal extends Figure {
    private List<Figure> variations = List.of(
            new Figure(this.getClass(), Vector.of(RIGHT, 5)));

    public BlueHorizontal() {
        super();
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
