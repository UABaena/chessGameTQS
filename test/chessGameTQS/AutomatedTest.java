package chessGameTQS;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
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
		//movs del rey del jugador 1
		
		
		b.resetBoard();
		List<Square> expectedResult = new ArrayList<Square>();
		// The name of the file to open.
		String path = "./test/chessGameTQS/";
        String fileName = path+"fileMovPawn.txt";    
        // This will reference one line at a time
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
            	
            
            	
            	try
            	{
            		assertEquals(expectedResult.toString(),ciertoFalso);
            	} catch (Throwable t){
            		System.out.println("Error: " + t);
            	}
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
