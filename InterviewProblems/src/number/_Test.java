package number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class _Test {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    double[] prices = new double[n];
	    double sum = 0;
	    Set<Integer> missingDays = new TreeSet<Integer>();
	    for(int i = 0;i<n; i++){
	        String[] line = sc.nextLine().split("\t");
	        if(line[2].startsWith("Missing")){
	            prices[i] = -1;
	            missingDays.add(i);
	        }
	        else{
	            prices[i]= Double.valueOf(line[2]);
	            sum+=prices[i];
	        }
	        //System.out.println(str);
	    }
	    
	    double avg = sum/(n-20);
	    for(int day: missingDays){
	        if(prices[day]!=-1){
	            continue;
	        }
	        
	        int left = day;
	        int right = day;
	        double start = avg;
	        double end = avg;
	        while(left>0 && prices[left-1]==-1){
	            left--;
	        }
	        while(right < n-1 && prices[right+1]==-1){
	            right++;
	        }
	        if(left>0){
	            start = prices[left-1];
	        }
	        if(right<n-1){
	            end = prices[right+1];
	        }
	        
	        double step = (start+end)/(right - left +1);
	        for(int i = 0; left + i<=right; i++){
	            prices[left + i]= start+step*(i+1);
	        }       
	        
	    }
	    
	    for(int day: missingDays){
	        System.out.println(prices[day]);
	    }
	    sc.close();
    }
}


