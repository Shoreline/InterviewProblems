package linkedin;

/**
 * PickUpNumbers
 * 
 * Given an array of positive integers and two players. In each turn, one player
 * picks up one number and if the sum of all the picked up numbers is greater
 * than a target number, the player wins. Write a program canIWin() to print the
 * result.
 * 
 */
/*
 * 这个直接按照逻辑写就可以了
 * 
 * 先手胜的情况是
 * 
 * n 轮(先手): 当前的数组中存在一个数使得 Sum > target.
 * 
 * n-1轮(后手): 当前的数组中选任何一个数 X 都不能使得 Sum > target. 但是当后手选完之后存在一个数可使得 Sum > target
 * 
 */
public class AlgoGamePickNumbers {
    class Method2 {
	public boolean canIWin(int[] numberPool, int target) {

	    return dfs(numberPool, target);
	}

	private boolean dfs(int[] numberPool, int target) {
	    if (target < 0) {
		return false;
	    }

	    for (int i = 0; i < numberPool.length && numberPool[i] > 0; i++) {
		if (numberPool[i] > 0) {
		    int num = numberPool[i];
		    if (num >= target) {
			return true;
		    }

		    numberPool[i] = -1;
		    boolean canHeWin = dfs(numberPool, target - num); // other's
		    // turn
		    if(!canHeWin){
			return true;
		    }
		    
		    numberPool[i] = num;
		}
	    }
	    return false;
	}

    }
    
    class Method {
	public boolean canIWin(int[] numberPool, int target) {

	    return dfs(numberPool, target);
	}

	private boolean dfs(int[] numberPool, int target) {
	    if (target < 0) {
		return false;
	    }

	    boolean res = false;
	    for (int i = 0; i < numberPool.length && numberPool[i] > 0; i++) {
		if (numberPool[i] > 0) {
		    int num = numberPool[i];
		    if (num >= target) {
			return true;
		    }

		    numberPool[i] = -1;
		    res = res || !dfs(numberPool, target - num); // other's
								 // turn
		    numberPool[i] = num;
		}
	    }
	    return res;
	}

    }
    
    /*
     * 代码也不长
public class PickUpNumbers {
    public boolean canIWin(int[] numberPool, int target) {
        boolean isEmpty = true;
        for (int data : numberPool)
            if (data > 0) isEmpty = false; 
        if (isEmpty) return false;
        else {
            if (target <= 0) return false;
            for (int data : numberPool)
                if (data > 0 && data >= target) return true;
            boolean canIWinFlag = false;. visit 1point3acres.com for more.
            for (int i = 0; i < numberPool.length && numberPool[i] > 0; ++i) {
                int data = numberPool[i];
                numberPool[i] = -1;
                canIWinFlag = canIWinFlag || !canIWin(numberPool, target - data); // other's turn
                numberPool[i] = data;
            }
            return canIWinFlag;
        }
    }

    public static void main(String[] args) {
        int[] numberPool = {1, 2, 3};. visit 1point3acres.com for more.
        System.out.println(new PickUpNumbers().canIWin(numberPool, 5));
        System.out.println(new PickUpNumbers().canIWin(numberPool, 4));
    }
}


把平局考虑进去的话，代码如下.鏈枃鍘熷垱鑷1point3acres璁哄潧

enum Result {Win, Lose, Draw}
. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
public class PickUpNumbers {
    public static Result canIWin(int[] numberPool, int target) {
        if (target <= 0) return Result.Lose;
        boolean isEmpty = true;
        for (int data : numberPool)
            if (data > 0) isEmpty = false; 
        if (isEmpty) return Result.Draw;
        else {
            for (int data : numberPool)
                if (data >= target) return Result.Win;
            Result drawFlag = Result.Draw;
            for (int i = 0; i < numberPool.length; ++i) {
                if (numberPool[i] > 0) {
                    int data = numberPool[i];
                    numberPool[i] = -1;
                    Result rivalResult = canIWin(numberPool, target - data); // rival's turn
                    if (rivalResult == Result.Win) drawFlag = rivalResult;. 涓€浜-涓夊垎-鍦帮紝鐙鍙戝竷
                    if (rivalResult == Result.Lose) return Result.Win;. From 1point 3acres bbs
                    numberPool[i] = data;
                }
            }
            if (drawFlag == Result.Draw) return Result.Draw;
            return Result.Lose; // whatever number i choose, rival wins
        }
    }

    public static void main(String[] args) {
        int[] numberPool = {1, 2, 3};
        System.out.println(PickUpNumbers.canIWin(numberPool, 5));
        System.out.println(PickUpNumbers.canIWin(numberPool, 4));.
        System.out.println(PickUpNumbers.canIWin(numberPool, 8));
    }
} 


稍微调整了一下楼主的代码.
enum Result {Win, Lose, Draw};

  Result canIWinsub(vector<int> numberPool, int target)
  {
          if(target<=0) return Lose;
          for(int i=0;i<numberPool.size();i++)
          {
                  if(numberPool==-1) continue;
                  int data=numberPool;
                  numberPool=-1;
                  if(canIWinsub(numberPool,target-data)==Lose)
                          return Win;
                  numberPool=data;
          }
          return Lose;
  }

  Result canIWin(vector<int> numberPool, int target)
  {
          int sum=0;
          for(int i=0;i<numberPool.size();i++)
                  sum+=numberPool;
          if(sum<target)
                  return Draw;
          return canIWinsub(numberPool,  target);


  }

     */
}