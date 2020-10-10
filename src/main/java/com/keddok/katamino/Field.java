package com.keddok.katamino;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author keddok
 * @since 26.09.2020
 */
public class Field {
    private final static int HEIGHT = 5;
    private final int width;
    private final State state;

    public Field(int width) {
        this.width = width;
        this.state = new State(width);
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return width;
    }

    public List<Figure> tryFigure(Figure figure) {
        List<Figure> matchedFigures = new ArrayList<>(8); /// todo optimization: reuse same array

        for (Figure figureVariation : figure.getVariations()) {
            if (state.isCellsAvailable(figureVariation.getVectors())) {
                matchedFigures.add(figureVariation);
            }
        }

        return matchedFigures;
    }

    public void put(Figure figure) {
        state.fillCells(figure.getVectors());
    }

    public void take(Figure figure) {
        state.cleanCells(figure.getVectors());
    }

    public static class State {
        private boolean[][] cellFilled;
        private XY nextAvailableCell;
        private int width;
        Stack<XY> previousAvailableCells = new Stack<>();

        State(int width) {
            this.width = width;
            this.cellFilled = new boolean[width][HEIGHT];
            this.nextAvailableCell = new XY(0, 0);
        }

        boolean isCellsAvailable(Vector... vectors) {
            XY startingCell = nextAvailableCell;
            for (Vector vector : vectors) {
                if (!isCellsAvailable(startingCell, vector))
                    return false;
            }

            return true;
        }

        boolean isCellsAvailable(XY startingCell, Vector vector) {
            if (!isInField(startingCell, vector))
                return false;

            for (XY cell : vector.getCells()) {
                int fullX = startingCell.x + cell.x;
                int fullY = startingCell.y + cell.y;
                if (cellFilled[fullX][fullY])
                    return false;
            }

            return true;
        }

        private boolean isInField(XY startingCell, Vector vector) {
            /// check if start and end points are within field boundaries
            /// todo optimization: calc second condition only if length>1
            return isInField(startingCell.x + vector.x, startingCell.y + vector.y)
                    && isInField(startingCell.x + vector.x + vector.getOffset().x, startingCell.y + vector.y + vector.getOffset().y);
        }

        private boolean isInField(int fullX, int fullY) {
            return fullX >= 0 && fullY >= 0 && fullX < width && fullY < 5;
        }

        private void fillCells(Vector[] vectors) {
            for (Vector vector : vectors)
                updateCells(true, vector.getCells());

            findNextAvailableCell();
        }

        private void cleanCells(Vector[] vectors) {
            revertNextAvailableCell();

            for (Vector vector : vectors)
                updateCells(false, vector.getCells());
        }

        private void updateCells(boolean filled, List<XY> xys) {
            for (XY xy : xys)
                cellFilled[nextAvailableCell.x + xy.x][nextAvailableCell.y + xy.y] = filled;
        }

        void findNextAvailableCell() {
            for (int x = nextAvailableCell.x; x < width; x++)
                for (int y = x > nextAvailableCell.x ? 0 : nextAvailableCell.y + 1; y < 5; y++)
                    if (!cellFilled[x][y]) {
                        previousAvailableCells.push(nextAvailableCell);
                        nextAvailableCell = new XY(x, y);

                        return;
                    }
        }

        void revertNextAvailableCell() {
            nextAvailableCell = previousAvailableCells.pop();
        }
    }
}
