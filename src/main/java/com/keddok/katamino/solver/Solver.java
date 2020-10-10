package com.keddok.katamino.solver;

import com.keddok.katamino.Field;
import com.keddok.katamino.Figure;
import com.keddok.katamino.figure.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author keddok
 * @since 26.09.2020
 */
public class Solver {
    public static void main(String[] args) {
        Field field = new Field(12);
        Stack<Figure> solution = Solver.solveRecursive(field,
                new LinkedList<>(List.of(new Grey(), new Yellow(), new Pink(),
                        new Purple(), new Green(), new Brown(),
                        new Orange(), new BlueHorizontal(), new LightBlue(),
                        new Red(), new LightGreen(), new Aquamarine())));
        System.out.print(solution);
    }

    /// todo optimization: use multithreading
    /// todo validate primary input: field width should be the same as figures list size
    static Stack<Figure> solveRecursive(Field field, List<Figure> remainingFigures) {
        ListIterator<Figure> iterator = remainingFigures.listIterator();
        while (iterator.hasNext()) {
            Figure currentFigure = iterator.next();
            List<Figure> matchedFigures = field.tryFigure(currentFigure);
            /// remove figure from list of remaining figures
            iterator.remove();
            for (Figure matchedFigure : matchedFigures) {
                /// last figure matched, solution found
                if (remainingFigures.size() == 0) {
                    Stack<Figure> solution = new Stack<>();
                    solution.push(matchedFigure);
                    return solution;
                }

                /// put used figure on field
                field.put(matchedFigure);

                /// find next figure and stack solution
                Stack<Figure> solution = solveRecursive(field, new LinkedList<>(remainingFigures));
                if (solution != null) {
                    solution.push(matchedFigure);
                    return solution;
                } else {
                    field.take(matchedFigure);
                }
            }
            iterator.add(currentFigure);
            /// todo loop can be endless if there is no solution, fix this
        }

        return null;
    }
}
