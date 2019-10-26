/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	import java.io.*;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.*;
	import java.text.*;
	import java.util.ArrayList;
	
public class SudokuGenerator {
    public static final int n = 3;
	public Writer fileOut;
	private Integer[] cell;
	private Integer[][] block1,block2,block3,block4,block5,block6,block7,block8,block9,block10,block11,block12;
	private Integer[][] block0_0,block0_1,block0_2,block1_0,block1_1,block1_2,block2_0,block2_1,block2_2;
	private Integer[][] sudoku;
	private Integer[][] flag;
	private ArrayList<Integer[][]> a;
	private ArrayList<Integer[][]> targetList;	
	
	public SudokuGenerator() {
		
	}

	public Integer[] generateCell() {
		
		cell = new Integer[9];
		 
        int k = 3;
		int m = 0;
      
        for (int i = 0; i < 3; i++) 
        { 
            int temp = k; 
  
            while (temp < 3) 
            { 
                cell[m] = temp; 
                temp++; 
				m++;
            } 

            for (int j = 0; j < k; j++) {
                cell[m] = j; 
				m++;
			}
            k--; 
        } 
		
		return cell;
	}
	
	public void generateLatinSquare(Integer[] cell) {
		
		block1 = new Integer[3][3];
		block2 = new Integer[3][3];
		block3 = new Integer[3][3];
		block4 = new Integer[3][3];
		block5 = new Integer[3][3];
		block6 = new Integer[3][3];
		block7 = new Integer[3][3];
		block8 = new Integer[3][3];
		block9 = new Integer[3][3];
		block10 = new Integer[3][3];
		block11 = new Integer[3][3];
		block12 = new Integer[3][3];
		
		a = new ArrayList<Integer[][]>();
		
		Integer temp;
		int m=0;
		
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				block1[i][j] = cell[m];
				m++;
			}
		}
		
		for(int j=0 ; j<n ; j++){
			temp = block1[1][j];
			block1[1][j] = block1[2][j];
			block1[2][j] = temp;
		}		
		
		for(int j=0;j<n;j++){
			block2[0][j] = block1[0][j];
			block2[1][j] = block1[2][j];
			block2[2][j] = block1[1][j];
		}
		
		for(int i=0;i<n;i++){
			block9[i][0] = block1[i][2];
			block9[i][1] = block1[i][1];
			block9[i][2] = block1[i][0];
		}
		
		for(int j=0;j<n;j++){
			block5[0][j] = block9[2][j];
			block5[1][j] = block9[1][j];
			block5[2][j] = block9[0][j];
		}
		
		for(int j=0;j<n;j++){
			block3[0][j] = block5[1][j];
			block3[1][j] = block5[0][j];
			block3[2][j] = block5[2][j];
		}
		
		for(int j=0;j<n;j++){
			block4[0][j] = block3[0][j];
			block4[1][j] = block3[2][j];
			block4[2][j] = block3[1][j];
		}
		
		for(int j=0;j<n;j++){
			block6[0][j] = block5[0][j];
			block6[1][j] = block5[2][j];
			block6[2][j] = block5[1][j];
		}
		for(int j=0;j<n;j++){
			block7[0][j] = block1[1][j];
			block7[1][j] = block1[0][j];
			block7[2][j] = block1[2][j];    
		}
		
		for(int j=0;j<n;j++){
			block8[0][j] = block7[0][j];
			block8[1][j] = block7[2][j];
			block8[2][j] = block7[1][j];
		}
		
		for(int j=0;j<n;j++){
			block10[0][j] = block8[0][j];
			block10[1][j] = block8[2][j];
			block10[2][j] = block8[1][j];
		}
		
		for(int j=0;j<n;j++){
			block11[0][j] = block7[2][j];
			block11[1][j] = block7[1][j];
			block11[2][j] = block7[0][j];
		}
		
		for(int j=0;j<n;j++){
			block12[0][j] = block11[0][j];
			block12[1][j] = block11[2][j];
			block12[2][j] = block11[1][j];
		}
		
		a.add(block1);
		a.add(block2);
		a.add(block3);
		a.add(block4);
		a.add(block5);
		a.add(block6);
		a.add(block7);
		a.add(block8);
		a.add(block9);
		a.add(block10);
		a.add(block11);
		a.add(block12);

	}
	
	public ArrayList<Integer[][]> selectRandomElements(ArrayList<Integer[][]> list)
	{
		Collections.shuffle(list);
		targetList = new ArrayList<Integer[][]>();
		for (int j = 0; j < 9; j++) {
			targetList.add(list.get(j)); 
		}

		return targetList;
	}
	
	public void generateBlock(ArrayList<Integer[][]> targetList) {
		
		block0_0 = new Integer[3][3];
		block0_1 = new Integer[3][3];
		block0_2 = new Integer[3][3];
		block1_0 = new Integer[3][3];
		block1_1 = new Integer[3][3];
		block1_2 = new Integer[3][3];
		block2_0 = new Integer[3][3];
		block2_1 = new Integer[3][3];
		block2_2 = new Integer[3][3];
				
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block0_0[i][j] = a.get(0)[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block0_1[i][j] = a.get(1)[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block0_2[i][j] = a.get(2)[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block1_0[i][j] = a.get(3)[i][j];
				// System.out.print(block1_0[i][j] + " ");
			}
			// System.out.println();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block1_1[i][j] = a.get(4)[i][j];
				// System.out.print(block1_1[i][j] + " ");
			}
			// System.out.println();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block1_2[i][j] = a.get(5)[i][j];
				// System.out.print(block1_2[i][j] + " ");
			}
			// System.out.println();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block2_0[i][j] = a.get(6)[i][j];
				// System.out.print(block2_0[i][j] + " ");
			}
			// System.out.println();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block2_1[i][j] = a.get(7)[i][j];
				// System.out.print(block2_1[i][j] + " ");
			}
			// System.out.println();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block2_2[i][j] = a.get(8)[i][j];
				// System.out.print(block2_2[i][j] + " ");
			}
			// System.out.println();
		}
		
	}
	
	public void generateSudoku(Integer[][] block1, Integer[][] block2,  Integer[][] block3, Integer[][] block4,
							Integer[][] block5, Integer[][] block6,Integer[][] block7,Integer[][] block8,Integer[][] block9) {
		sudoku = new Integer[9][9];
		flag = new Integer[9][9];
		int i = 0;
		int j = 0;
		
		for (i=0 ; i<3 ; i++) {
			for (j=0 ; j<9 ; j++) {
				if (j<3) {
					sudoku[i][j] = block0_0[i][j];  
                    flag[i][j] = 2;  
				}
				else if (j>=3 && j<6) {
					sudoku[i][j] = block0_1[i][j%3];
                    flag[i][j] = 1;
				}
				else {
					sudoku[i][j] = block0_2[i][j%3];;
                    flag[i][j] = 0;
				}
			}			
		}
		
		for (i=3 ; i<6 ; i++) {
			for (j=0 ; j<9 ; j++) {
				if (j<3) {
					sudoku[i][j] = block1_0[i%3][j];  
                    flag[i][j] = 1;  
				}
				else if (j>=3 && j<6) {
					sudoku[i][j] = block1_1[i%3][j%3];
                    flag[i][j] = 0;
				}
				else {
					sudoku[i][j] = block1_2[i%3][j%3];;
                    flag[i][j] = 2;
				}
			}			
		}
		
		for (i=6 ; i<9 ; i++) {
			for (j=0 ; j<9 ; j++) {
				if (j<3) {
					sudoku[i][j] = block2_0[i%3][j];  
                    flag[i][j] = 0;  
				}
				else if (j>=3 && j<6) {
					sudoku[i][j] = block2_1[i%3][j%3];
                    flag[i][j] = 2;
				}
				else {
					sudoku[i][j] = block2_2[i%3][j%3];;
                    flag[i][j] = 1;
				}
			}			
		}
	}

	
	public void writePuzzle(Integer[][]flag, Integer[][]sudoku, String output_name) {
		Integer temp;
		int count = 0;
		
		try {
			fileOut = new FileWriter(output_name);
			for(int i=0 ; i<9 ; i++){
				for(int j=0 ; j<9 ; j++){
					if(flag[i][j]==2){
					   sudoku[i][j] = 2*3+sudoku[i][j]+1; 
					}
					else if(flag[i][j]==1){
						sudoku[i][j] = 1*3+sudoku[i][j]+1;
					}
					else{
						sudoku[i][j] = 0*3+sudoku[i][j]+1;
					}
					// System.out.print(sudoku[i][j] + " ");
				}
				// System.out.println();
			}
			
			for(int j=0 ; j<9 ; j++){
				temp = sudoku[1][j];
				sudoku[1][j] = sudoku[3][j];
				sudoku[3][j] = temp;
				//-----------------
				temp = sudoku[2][j];
				sudoku[2][j] = sudoku[6][j];
				sudoku[6][j] = temp;
				//-----------------
				temp=sudoku[5][j];
				sudoku[5][j] = sudoku[7][j];
				sudoku[7][j] = temp;
			}
			
			for (int i=0 ; i<9 ; i++){
                for(int j=0 ; j<9 ; j++){
                    fileOut.write(sudoku[i][j] + " ");
                }
                fileOut.write("\r\n");
            }
			
			fileOut.close();			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void makeHoles(int number_blanks, Integer[][]sudoku, String output_name)
	{
		double remainingSquares = 81;
		double remainingHoles = (double)number_blanks;
			
		try {
			fileOut = new FileWriter(output_name);
			
			for(int i=0 ; i<9 ; i++) {
				for(int j=0 ; j<9 ; j++)
				{
					double holeChance = remainingHoles/remainingSquares;
					if(Math.random() <= holeChance)
					{
						sudoku[i][j] = 0;
						remainingHoles--;
					}
					remainingSquares--;
				}
			}
			
			for (int i=0 ; i<9 ; i++){
                for(int j=0 ; j<9 ; j++){
                    fileOut.write(sudoku[i][j] + " ");
                }
                fileOut.write("\r\n");
            }
			
			fileOut.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		SudokuGenerator sg = new SudokuGenerator();
		sg.generateCell();
		sg.generateLatinSquare(sg.cell);
		sg.selectRandomElements(sg.a);
		sg.generateBlock(sg.targetList);
		sg.generateSudoku(sg.block0_0,sg.block0_1,sg.block0_2,sg.block1_0,sg.block1_1,sg.block1_2,sg.block2_0,sg.block2_1,sg.block2_2);
		sg.writePuzzle(sg.flag,sg.sudoku,args[0]);		
		sg.makeHoles(Integer.parseInt(args[2]),sg.sudoku,args[1]);
	}
}
