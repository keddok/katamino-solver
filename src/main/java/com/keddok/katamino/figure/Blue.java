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
@Deprecated /// use BlueHorizontal
public class Blue extends Figure {
    private List<Figure> variations = List.of(
            new Figure(Vector.of(UP, 5)),
            new Figure(Vector.of(RIGHT,5)));

    public Blue() {
        super();
    }

    public List<Figure> getVariations() {
        return variations;
    }
}
