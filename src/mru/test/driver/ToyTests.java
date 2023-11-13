package mru.test.driver;
import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToyTests {

	@Test
	void testAnimalToString() {
        Animal animal = new Animal(1234567890, "Lion", "WildToys", 29.99, 50, 5, "Plush", "Medium");
        String expected = "Animal: Lion (Serial Number: 1234567890, Brand: WildToys, Price: 29.99, Available Count: 50, Age Appropriate: 5, Material: Plush, Size: Medium)";
        assertEquals(expected, animal.toString());
    }
	
	@Test
    void testBoardGameToString() {
        BoardGame boardGame = new BoardGame(9876543210L, "Monopoly", "Hasbro", 24.99, 30, 8, "2-6", "John Doe");
        String expected = "Board Game: Monopoly (Serial Number: 9876543210, Brand: Hasbro, Price: 24.99, Available Count: 30, Age Appropriate: 8, Num of Players: 2-6, Author: John Doe)";
        assertEquals(expected, boardGame.toString());
    }
	
	


    @Test
    void testFigureToString() {
        Figure figure = new Figure(1357924680, "Superhero", "ToyCo", 14.99, 20, 6, "Action Figure");
        String expected = "Figure: Superhero (Serial Number: 1357924680, Brand: ToyCo, Price: 14.99, Available Count: 20, Age Appropriate: 6, Classification: Action Figure)";
        assertEquals(expected, figure.toString());
    }
//
    @Test
    void testPuzzleToString() {
        Puzzle puzzle = new Puzzle(2468013579L, "Nature Puzzle", "PuzzleFun", 19.99, 25, 10, "Jigsaw");
        String expected = "Puzzle: Nature Puzzle (Serial Number: 2468013579, Brand: PuzzleFun, Price: 19.99, Available Count: 25, Age Appropriate: 10, Puzzle Type: Jigsaw)";
        assertEquals(expected, puzzle.toString());
    }

}
