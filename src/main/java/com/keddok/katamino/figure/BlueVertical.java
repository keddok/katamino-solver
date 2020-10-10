package com.keddok.katamino.figure;

import com.keddok.katamino.Figure;
import com.keddok.katamino.Vector;

import java.util.List;

import static com.keddok.katamino.Vector.Direction.UP;

/**
 * @author keddok
 * @since 03.10.2020
 */
@Deprecated /// use BlueHorizontal
public class BlueVertical extends Figure {
    private List<Figure> variations = List.of(
            new Figure(Vector.of(UP, 5)));

    public BlueVertical() {
        super();
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
