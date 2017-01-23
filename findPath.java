/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static final boolean debug = true;
	public static boolean findPath(int[][] path, int currNode, int B, ArrayList<Integer> routeAB, int n){
		boolean result = false;
	//	if(routeAB.length() == n && (currNode != B)){
	//		return false;
	//	}
		if(routeAB.size() < n) {
			//parse routes of currNode
			System.out.println("Current node = "+String.valueOf(currNode+1));
			for(int i = 0; i < n; i++){
				System.out.println("\t checking node "+String.valueOf(i));
				//if there is a path between currnode and i and i is not in route of A and B already
				if(path[currNode][i] == 1 && !routeAB.contains(i+1)){
					routeAB.add(i+1);
					if(i == B){
						if (debug) System.out.println("Found destination "+String.valueOf(B+1));
						System.out.print("Found Route = ");
						System.out.println(routeAB);
						return true;
					}else{
						result = findPath(path, i, B, routeAB, n);
						if(result) {
							System.out.println("Next Node = "+String.valueOf(i+1));
							return true;}
						else{
							routeAB.remove(i+1);
						}}}}
		}
		return result;
	}
	public static boolean checkPath(){
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int nR = sc.nextInt();
		//read input graph
		System.out.println("Reading input");
		int[][] path = new int[n][n];
		while(nR != 0){
			path[sc.nextInt()-1][sc.nextInt()-1] = 1;
			nR--;
		}
		
		//read source and destination
		int A = sc.nextInt();
		int B = sc.nextInt();
		ArrayList<Integer> routeAB = new ArrayList<Integer>();
		
		//check if path exists between A and B
		routeAB.add(A);
		boolean hasPath = findPath(path, A-1, B-1, routeAB, n);
		
		return hasPath;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println(checkPath());
	}
}