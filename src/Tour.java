import java.awt.*;
import javax.swing.*;

public class Tour 
{
	private JButton[][] buttons;
	private int currentRow;							
	private int currentCol;							
	private int counter;							
	private final int[] xMoves = { 2, 1, -1 , -2, -2, -1, 1 , 2 };
	private final int[] yMoves = { -1, -2, -2, -1, 1, 2,  2, 1 };
	
	//constructor to set the grid
	Tour(JButton[][] buttonGrid) {
		buttons = buttonGrid;
	}
	
	//click function to initialize the starting point x,y
	public void clicked(int i, int j)
	{
	   clear();
	   
	   currentRow = i;
       currentCol = j;
       buttons[currentRow][currentCol].setText(counter +" Initial Position"); 
       buttons[currentRow][currentCol].setBackground(Color.green);
       
       //moves the knight
       while(moveKnight(currentRow, currentCol));
       
       buttons[currentRow][currentCol].setText(counter + " Last Position");
       buttons[currentRow][currentCol].setBackground(Color.red);
       //buttons[currentRow][currentCol].setBorderPainted(true);
    }
	 
	
	//move knight function
	public boolean moveKnight(final int x, final int y )
	{
		boolean foundValid = false;
		
		for (int i = 0; i < 8 && !foundValid; i++) 
		{
			int tempX = x;
			int tempY = y;
				 
			 tempX += xMoves[i];
			 tempY += yMoves[i];
			 
			 if(isValidMove(tempX, tempY))
			 {
			     counter++;
			     buttons[tempX][tempY].setText(counter + "");

			     foundValid = true;
			     currentRow = tempX;
			     currentCol = tempY;     			     
			 }
		}

		return foundValid;
	}
	
	
	
	//a function to check is the move is in side the border and the button isnt visited yet
	public boolean isValidMove(int i, int j)
	{
		//make sure inside the board
		if (i < 0 || i >= 8) return false;
		if (j < 0 || j >= 8) return false;
		
		//avoid visited squares
		if (!buttons[i][j].getText().contentEquals("")) return false;

		return true;		
	}
	
	
	
	//a function to clear the grid and the counter
	private void clear() 
	{
		counter = 0;
		for (int x = 0; x < 8; x++) 
		{
			for (int y = 0; y < 8; y++)
			{
				buttons[x][y].setText("");
				buttons[x][y].setBackground(new JButton().getBackground());
			} 	
		}
					
	}
	
}
