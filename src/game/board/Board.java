package game.board;

import game.board.cell.Cell;

public class Board {

    // 2d array of Cells = 15x15 board
    // mapped Cells[y]][x]
    public static Cell[][] Cells = new Cell[15][15];

    public static String conf[][] = {
         {"_","_","_","d","l","l","l","ld","l","l","l","l","_","_","_"}  //0
        ,{"_","_","_","d","_","_","_","d","_","_","_","u","_","_","_"}  //1
        ,{"_","_","_","d","l","l","l","ld","_","_","_","ud","l","l","_"}  //2
        ,{"_","d","l","l","_","_","_","d","_","_","_","d","_","u","_"}  //3
        ,{"_","d","_","u","l","l","l","ld","l","l","l","l","_","u","_"}  //4
        ,{"_","d","_","_","_","_","_","d","_","_","_","_","_","u","_"}  //5
        ,{"_","d","_","_","_","_","_","d","_","_","_","_","_","u","_"}  //6
        ,{"_","d","_","_","d","l","l","l","_","_","_","_","_","u","_"}  //7
        ,{"_","d","_","_","d","_","_","_","_","_","_","_","_","u","_"}  //8
        ,{"_","d","_","_","d","_","_","_","_","_","_","_","_","u","_"}  //9
        ,{"_","d","d","d","l","_","_","_","_","_","_","_","_","u","l"}  //10
        ,{"_","d","_","_","_","_","_","_","_","_","_","_","_","_","u"}  //11
        ,{"_","d","_","_","r","r","r","d","_","_","_","_","_","_","u"}  //12
        ,{"_","d","_","_","u","_","_","r","r","r","d","_","_","_","u"}  //13
        ,{"_","d","r","r","ur","r","r","r","r","r","r","r","r","r","u"}  //14
    };

    public Board() {
        initialiseCells();
        initPeices(); 
    }

    private void initPeices() {

    }
    private void initialiseCells() 
    {
        for (int i = 0; i < Cells.length - 1; i++)
        {
            for (int j = 0; j < Cells[i].length - 1; j++)
            { 
                System.out.println(String.format("Configureing Cell[%d][%d] with conf %s ",i,j,Board.conf[i][j]));
                Board.Cells[i][j] = new Cell();
                Board.Cells[i][j].setDirections(Board.conf[i][j]);
            }
        }
    }

    public void movePiece() {

    }

    public void displayBoard() {

    }

    public boolean movePiece(Cell[][] startPoint, char direction) 
    {
        return false;
    }




}