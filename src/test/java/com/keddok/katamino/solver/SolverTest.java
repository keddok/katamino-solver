package com.keddok.katamino.solver;

import com.keddok.katamino.Field;
import com.keddok.katamino.Figure;
import com.keddok.katamino.figure.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author keddok
 * @since 04.10.2020
 */
public class SolverTest {

    @org.junit.Test
    public void testSolveRecursive5Palok() {
        Field field = new Field(5);
        Figure palka = new Blue();
        Stack<Figure> solution = Solver.solveRecursive(field, new LinkedList<>(List.of(palka, palka, palka, palka, palka)));
        System.out.print(solution);

        assert solution != null && solution.size() == 5; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive5Palok2() {
        Field field = new Field(5);
        Figure palka = new BlueVertical();
        Stack<Figure> solution = Solver.solveRecursive(field, new LinkedList<>(List.of(palka, palka, palka, palka, palka)));
        System.out.print(solution);

        assert solution != null && solution.size() == 5; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive5Palok3() {
        Field field = new Field(5);
        Figure palka = new BlueHorizontal();
        Stack<Figure> solution = Solver.solveRecursive(field, new LinkedList<>(List.of(palka, palka, palka, palka, palka)));
        System.out.print(solution);

        assert solution != null && solution.size() == 5; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive10Palok() {
        Field field = new Field(10);
        Figure palkaVertical = new BlueVertical();
        Figure palkaHorizontal = new BlueHorizontal();
        Stack<Figure> solution = Solver.solveRecursive(field,
                new LinkedList<>(List.of(palkaVertical, palkaVertical, palkaVertical, palkaVertical, palkaVertical,
                        palkaHorizontal, palkaHorizontal, palkaHorizontal, palkaHorizontal, palkaHorizontal)));
        System.out.print(solution);

        assert solution != null && solution.size() == 10; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive5x3() {
        Field field = new Field(3);
        Stack<Figure> solution = Solver.solveRecursive(field,
                new LinkedList<>(List.of(new Grey(), new Yellow(), new Pink())));
        System.out.print(solution);

        assert solution != null && solution.size() == 3; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive5x6() {
        Field field = new Field(6);
        Stack<Figure> solution = Solver.solveRecursive(field,
                new LinkedList<>(List.of(new Grey(), new Yellow(), new Pink(),
                        new Purple(), new Green(), new Brown())));
        System.out.print(solution);

        assert solution != null && solution.size() == 6; /// todo check that solution fills all field
    }

    @org.junit.Test
    public void testSolveRecursive5x12() {
        Field field = new Field(12);
        Stack<Figure> solution = Solver.solveRecursive(field,
                new LinkedList<>(List.of(new Grey(), new Yellow(), new Pink(),
                        new Purple(), new Green(), new Brown(),
                        new Orange(), new BlueHorizontal(), new LightBlue(),
                        new Red(), new LightGreen(), new Aquamarine())));
        System.out.print(solution);

        assert solution != null && solution.size() == 12; /// todo check that solution fills all field
    }
}
