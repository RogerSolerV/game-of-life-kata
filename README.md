# Game Of Life - Kata
![](https://github.com/RogerSolerV/game-of-life-kata/workflows/JavaMavenCI/badge.svg)

## Code guide
Starting class is located in: `com.kognia.test.gameoflife.GameOfLifeRunner`.

It's only in charge of triggering the execution with the right parameters.

`StatusBoardReader` will be in charge of reading the input file and transform it to a `Board<STATUS>`.

Board's are generic, can be of any type, but for our game we will use `Board<STATUS>`, where `STATUS` is a simple enum of 2 options, DEAD or ALIVE, that also helps us to print and read it.

`Board` is an immutable object and must be constructed using its BoardBuilder, having that it's proven Board will never change after its creation.

`Board` class also offers some useful methods like `getNeighbours(x, y)`, that allows us to get all surrounding cells of a given one.

Generation happens in class `StatusBoardGeneration.generate(Board)`, that will trigger a generation event to the given `Board`, returning a completely new one.

Note: Board cells generation happens in parallel using the same thread pool as the application itself, that could be improved if needed passing a dedicated thread pool.

### Assumptions
* From [game-of-life.md](game-of-life.md) I've implemented Milestones 1 and 3. Board grid is infinite, so edges consider cells on the opposite edge to be neighbours.
* Most common Java errors are not handled, rather let them crash the app, since I think they are self-explanatory enough. Of course, they could be handled, and trigger in a much user-friendly way.

## Built With
Check `pom.xml` for all libraries and frameworks used and their versions.
* [Maven](https://maven.apache.org/) - Dependency Management

## Building the project
Go to project path and run Maven command:
```
mvn -q clean package
```

## Running the project
Main in class is located in: `com.kognia.test.gameoflife.GameOfLifeRunner`
```
java -jar target/game-of-life-1.0-SNAPSHOT-shaded.jar board.life 3
```

Expected parameters:
1. `fileName` mandatory. Can be relative or absolute following Java Paths standards.
1. `numberOfGenerations` (to run) optional, default is 1. Only positives values allowed.
