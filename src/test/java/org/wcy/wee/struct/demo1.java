package org.wcy.wee.struct;

public class demo1 {

	public static void main(String[] args) {
		
		//System.out.println(sum(1,100));
		
//		int rs = strlen("abcde");
//		System.out.println(rs);
		
		hanoi(5, 'a', 'b', 'c');
		
	}
	
	public static void hanoi(int n, char a, char b, char c) { //a为初始塔，b为中间塔，c为目标塔  
        if (n == 1){    
            System.out.println("n=" + n + " " + a + "-->" + c);    
        }  
        else{    
            /*递归的调用*/    
            hanoi(n-1,a,c,b);    
            System.out.println("n=" + n + " " + a + "-->" + c);    
            hanoi(n-1,b,a,c);    
        }
    }
	
	public static int strlen(String str) {
		char[] charArray = str.toCharArray();
		int count = 0;
		for(char c : charArray) {
			count ++;
		}
		return count;
	}
	
	public static int fn(int n) {
		int result = 0;
		if(n == 1) {
			result = 1;
		} else if(n > 1){
			result = n + fn(n-1);
		}
		return result;
	}
	
	public static int sum(int i, int n) {
		return (i+n)* n / 2;
	}
}
