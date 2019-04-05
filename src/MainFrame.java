import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    
	    
	    JPanel grid = new JPanel();
	    JButton[][] buttonsGrid = new JButton[8][8];
	    
	    //had to add this constructor to be able to call the clicked function
	    final Tour tour = new Tour(buttonsGrid);
	    
	    grid.setLayout(new GridLayout(8, 8));
	    
	    for (int i=0; i < 8; i++) 
	    {
	        for (int j=0; j < 8; j++) 
	        {
	        	
	        	buttonsGrid[i][j] = new JButton();
	        	//declare final temp vars to be able to pass them in the action listener
	        	final int tempI = i;
	        	final int tempJ = j;
	        	
	        	buttonsGrid[i][j].setOpaque(true);
	        	buttonsGrid[i][j].setText("");
	        	
	        	buttonsGrid[i][j].addActionListener((ActionEvent aActionEvent) -> {
	        		tour.clicked(tempI,tempJ);
	        	  } );
	        	
	        	grid.add(buttonsGrid[i][j]);
	        	
	        }
	    }
	   
	    frame.add(grid);
	    frame.setSize(600,600);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
