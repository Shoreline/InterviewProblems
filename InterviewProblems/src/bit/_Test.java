package bit;

import java.util.ArrayList;
import java.util.List;

public class _Test {

    public static void main(String[] args) {
	System.out.println(2^5);
	System.out.println();
	System.out.println(new _Test().grayCode(2));
    }
    
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n<0){
            return res;
        }
        res.add(0);
        if(n==0){
            return res;
        }
        res.add(1);
        for(int i =2; i<=n; i++){
            for(int j = res.size()-1; j>=0; j--){
                int a = res.get(j);
                int b = i-1;
                int c = 2^b;
        	res.add(a+c);
            }
        }
        return res;
    }
}

