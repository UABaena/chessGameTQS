package chessGameTQS;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Victor
 * clase per automatitzar els test
 *
 */
public class AutomatedTest {
	@Test
	void automatizedTestMovPawn() {
		
		Board b = new Board();
		Piece pawn = new Pawn(2); 
		pawn = b.getSquare(1, 3).getPiece();		
		
		b.resetBoard();
		List<Square> expectedResult = new ArrayList<Square>();
		String path = "./test/chessGameTQS/";
        String fileName = path+"fileMovPawn.txt";    
        String linia = null;
        String[] partes;
        int a,c;
    	String ciertoFalso;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((linia = bufferedReader.readLine()) != null) {
            	partes = linia.split(";");
            	a = Integer.parseInt(partes[0]);
            	c = Integer.parseInt(partes[1]);
            	ciertoFalso = partes[2];
            	
            	expectedResult = pawn.getPossibleMoves(b, a, c);

            	assertEquals(expectedResult.toString(),ciertoFalso);
            }   
            bufferedReader.close();  
            fileReader.close();
        }
        catch(FileNotFoundException ex) {
        	System.out.println("No es pot obrir el fitxer: '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error llegint el fitxer '" + fileName + "'");                  
        }
		
	}
	@Test
	void automatizedTestGameOver() {
		Game game = new Game();
		Board b = new Board();
		Square sq1;
		String path = "./test/chessGameTQS/";
        String fileName = path+"fileGameOver.txt";    
        String linia = null;
        String[] partes;
        int a,c;
    	Boolean ciertoFalso,fin;
    	
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((linia = bufferedReader.readLine()) != null) {
            	partes = linia.split(";");
            	a = Integer.parseInt(partes[0]);
            	c = Integer.parseInt(partes[1]);
            	ciertoFalso = Boolean.parseBoolean(partes[2].toLowerCase());
            	
            	sq1 = new Square(null, a, c);
            	b.setSquare(sq1);
            	b = game.getBoard();

        		fin = game.isFinished();
        		assertEquals(ciertoFalso,fin);


            }   
            bufferedReader.close();  
            fileReader.close();
        }
        catch(FileNotFoundException ex) {
        	System.out.println("No es pot obrir el fitxer: '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error llegint el fitxer '" + fileName + "'");                  
        }
	}
}
