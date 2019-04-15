import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static int[][] align(String g1, String g2){
		int[][] T = new int[g1.length() + 1][g2.length() + 1];
		T[0][0] = 0;
		//populate column and row of graph along the origin
		for(int i = 1; i <= g1.length(); i++){
			T[i][0] = T[i-1][0] + (-1); // -1 because delta(x,-) = -1
		}
		for(int j = 1; j <= g2.length(); j++){
			T[0][j] = T[0][j-1] + (-1); // -1 because delta(-,x) = -1
		}
		
		//populate rest of graph by taking the max of the nodes above, to the upper left and to the right of the current node
		for(int i = 1; i <= g1.length(); i++){
			for(int j = 1; j <= g2.length(); j++){
				char c1 = g1.charAt(i-1);
				char c2 = g2.charAt(j-1);
				int score = c1 == c2 ? 2 : -2; //delta(x,y) is 2 if x=y, -2 if x!=y
				T[i][j] = Math.max(T[i-1][j-1] + score, Math.max(T[i-1][j] + (-1), T[i][j-1] + (-1)));
			}
		}
		return T;
	}
	
	static void printSol(int[][] T, int i, int j, String g1, String g2){
		ArrayList<Character> sol1 = new ArrayList<Character>();
		ArrayList<Character> sol2 = new ArrayList<Character>();
		
		// populate sol1 and sol2 with appropriate matches based on maximized results from T
		while(i > 0 || j > 0){
			if(i == 0){
				sol1.add('-');
				sol2.add(g2.charAt(j - 1));
				j--;
			}
			else if (j == 0){
				sol2.add('-');
				sol1.add(g1.charAt(i - 1));
				i--;
			}
			else{
				char c1 = g1.charAt(i - 1);
				char c2 = g2.charAt(j - 1);
				int score = c1 == c2 ? 2 : -2;
				
				int val1 = T[i-1][j-1] + score;
				int val2 = T[i-1][j] + (-1);
				int val3 = T[i][j-1] + (-1);
				
				int best = 1; // represents the 'index' of best scoring match for switch statement
				int best_val = val1;
						
				if(val2 > best_val){
					best = 2;
					best_val = val2;
				}
				
				if(val3 > best_val){
					best = 3;
					best_val = val3;
				}
				
				switch(best){
					case 1:
						sol1.add(g1.charAt(i - 1));
						sol2.add(g2.charAt(j - 1));
						i--;
						j--;
						break;
					case 2:
						sol1.add(g1.charAt(i - 1));
						sol2.add('-');
						i--;
						break;
					case 3:
						sol1.add('-');
						sol2.add(g2.charAt(j - 1));
						j--;
						break;
				}
			}
		}
		
		Collections.reverse(sol1);
		Collections.reverse(sol2);
		// print g1 alignment
		for(int k = 0; k < sol1.size(); k++){
			System.out.print(sol1.get(k));
		}
		System.out.println();
		// print g2 alignment
		for(int k = 0; k < sol2.size(); k++){
			System.out.print(sol2.get(k));
		}
		
	}
	
    public static void main(String args[] ) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 4096);
        
    	String g1 = br.readLine();
        String g2 = br.readLine();

    	int[][] T = align(g1, g2);
    
    	
    	System.out.println();
    	System.out.println(T[g1.length()][g2.length()]);
    	printSol(T, g1.length(), g2.length(), g1, g2);
    	
    }
}