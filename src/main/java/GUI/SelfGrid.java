package GUI;

import GUI.BattleGrid;
import GUI.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

/**
 Represents the player's own grid
 */

public class SelfGrid extends BattleGrid {
    private boolean isSelfGridListener = true;
    private final int NUMBER_OF_SHIP = 5;
    private final int count = 0;
    private final String name;
    private Point firstPoint = new Point(0,0);
    private Point secondNextPoint = new Point(0,0);
    private Point thirdNextPoint = new Point(0,0);
    private JPanel thePanel = new JPanel();

    public SelfGrid(String name) {
        super();
        this.name = name;
    }

    public void getJpanel(Point newPoint){
        thePanel = this.getComponentAt(newPoint);
    }
    public void getComp2(Point newPoint){
        JPanel secondNextCell = this.getComponentAt(newPoint);
    }
    public void getComp3(Point newPoint){
        JPanel thirdNextCell = this.getComponentAt(newPoint);
    }
    @Override
    protected JPanel getCell()
    {
        JPanel firstCell = new JPanel();
        firstCell.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        firstCell.setPreferredSize(new Dimension(40, 40)); // 20 x 20
        firstCell.setBackground(Color.black);

        firstCell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isSelfGridListener) {
                    firstPoint = firstCell.getLocation();
                    double xPos = (firstPoint.getX()/20+1);
                    int x = (int) xPos;
                    double yPos = (firstPoint.getY()/20+1);
                    int y = (int) yPos;

                    double xPos2 = (firstPoint.getX()/20+2);
                    int x2 = (int) xPos2;
                    double yPos2 = (firstPoint.getY()/20+1);
                    int y2 = (int) yPos2;

                    double xPos3 = (firstPoint.getX()/20+3);
                    int x3 = (int) xPos3;
                    double yPos3 = (firstPoint.getY()/20+1);
                    int y3 = (int) yPos3;

                    System.out.print(name);
                    System.out.print("\nLocation (X: " + x + " Y: " + y + ")\n");

                    secondNextPoint = new Point((int)(firstPoint.getX()+20),(int)(firstPoint.getY()));
                    thirdNextPoint = new Point((int)(firstPoint.getX()+40),(int)(firstPoint.getY()));
                    Coordinate a = new Coordinate(x,y);
                    Coordinate b = new Coordinate(x2,y2);
                    Coordinate c = new Coordinate(x3,y3);

                    getComp2(secondNextPoint);
                    getComp3(thirdNextPoint);
                }
            }
        });
        return firstCell;
    }

    public void setSelfGridListener (boolean selfGridListener){
        this.isSelfGridListener = selfGridListener;
    }

    public void draw(){

        int[][] temp=null;
        if(name.equals("Player1")){
            //temp = battleShip.getPlayer1Data().getSelfData();
        }
        else if(name.equals("Player2")){
            //temp = battleShip.getPlayer2Data().getSelfData();
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if(temp[i][j]==1){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.CYAN);
                }
               if(temp[i][j]==0){
                   int x = numberToPanel(i);
                   int y = numberToPanel(j);
                   System.out.println("\ninside black "+x +"      "+ y);

                   Point p = new Point(Math.abs(x),Math.abs(y));
                   getJpanel(p);

                   thePanel.setBackground(Color.BLACK);

                }
            }
        }
    }
    public int numberToPanel(int s){
        return (s-1)*20;
    }

    public boolean getSelfGridListener() {
        return isSelfGridListener;
    }
    public String getGridType(){
        return "selfGrid";
    }
}