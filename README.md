# Katamino solver

This small application used to solve the Katamino(https://en.gigamic.com/game/katamino) puzzle.

## Build
Use maven 3+ and java 11+ to build this app with command:
`mvn clean package -DskipTests=true`
Output will be generated to `target` subdirectory.

## Run
By default solver prints the solution of full puzzle with all 12 figures.
Run it with command:
`java -jar solver.jar`

## Input/output format
Solver takes as input:
1. Field width.
2. List of figures.

Solution prints figures in reverse order. First take the last figure in stack then the previous one and so on.
It is important to put figures from solution one by one in the first free available place on the katamino field.
First free field is the most left and then most bottom.

Each figure described by name(color) and list of vector objects.
Vector string representation contains:
1) vector start point coordinates relative to current available cell in field and
2) vector offset - end of vector relative to vector start point.
