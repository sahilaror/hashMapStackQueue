ANS  1
	import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements of Key-pair: ");  
        
        int n = sc.nextInt();

       
        TreeMap<Integer, String> tm = new TreeMap<>();

        System.out.print("Enter the elements in Key and value : ");  
        for(int i=0;i<n;i++){
            int key = sc.nextInt();
            String value = sc.next();
            tm.put(key, value);
        }

        System.out.println("The value of Map is: " + tm);

    }
}

ANS  2
	import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements of Key-pair: ");  
        
        int n = sc.nextInt();

       
        TreeMap<String, Integer> tm = new TreeMap<>();

        System.out.print("Enter the elements in Key and value : ");  
        for(int i=0;i<n;i++){
            int key = sc.nextInt();
            String value = sc.next();
            tm.put(value, key);
        }

        System.out.println("The value of Map is: " + tm);

    }
}

ANS 3
	import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements of array: ");  
        
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements of array: ");  
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> tm = new HashMap<>();
        int answer = 0;
        for(int i=0;i<n;i++){
            if(tm.containsKey(arr[i])){
                System.out.println("Yes");
                answer =1;
                break;
            }
            tm.put(arr[i], 1);
        }

        if(answer == 0)
            System.out.println("No");

    }
}
ANS 4
	import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements of array: ");  
        
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements of array: ");  
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int i=0;i<n;i++){
            tm.put(arr[i], 1);
        }

        System.out.println("Largest Element of Map is : " + tm.lastEntry().getKey());

    }
}

ANS 5
	import java.util.*;
import java.util.Map;
import java.io.*;
  
public class HashMapClass {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the RansomNote String: ");  
        
        String s=sc.nextLine();

        System.out.print("Enter the Magazine String: ");  
        
        String r=sc.nextLine();


        HashMap<Character, Integer> hm1 = new HashMap<>();

        for(int i=0;i<s.length(); i++ ){
            if(hm1.containsKey(s.charAt(i))) {
                hm1.put(s.charAt(i), hm1.get(s.charAt(i))+1);
            }
            else
                hm1.put(s.charAt(i), 1);
        }     

        HashMap<Character, Integer> hm2 = new HashMap<>();

        for(int i=0;i<r.length(); i++ ){
            if(hm2.containsKey(r.charAt(i))) {
                hm2.put(r.charAt(i), hm2.get(r.charAt(i))+1);
            }
            else
                hm2.put(r.charAt(i), 1);
        }     

        

        Integer answer = -1;
        for(Map.Entry<Character, Integer> e: hm1.entrySet()) {

            if(e.getValue() > hm2.get(e.getKey())){

                System.out.println("false");
                answer = 1;
                break;
            }
        }
        if(answer == -1)
            System.out.println("True");

    }
}

 
										ASSIGNNMENT 2

ANS 1
		import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[j] = matrix[i][j] == 1 ? arr[j] + 1 : 0;
            }
            //treating arr[j] as histogram, solving max area problem there and updating the max area
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(arr));
        }
        return maxArea;
    }
    public static int findMaxAreaInHistogram(int[] arr){
        int len = arr.length;
        int maxArea = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        //traversing left to right, finding left limit
        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i] = 0;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }
        //doing empty to stack
        while(!stack.isEmpty())
            stack.pop();
        
        //traversing right to left, find right limit
        for(int i=len-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i] = len - 1;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        //traversing the array , caculating area
        int[] area = new int[len];
        for(int i=0;i<len;i++){
            area[i] = (right[i] - left[i] + 1) * arr[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        return maxArea;
    }
    
	public static void main(String[] args){
        int[][] arr = {{0,1,1,0},{0,1,0,0},{0,0,0,1}};
	    System.out.println("The maximum area is : " + maximalRectangle(arr));
	}
}import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[j] = matrix[i][j] == 1 ? arr[j] + 1 : 0;
            }
            //treating arr[j] as histogram, solving max area problem there and updating the max area
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(arr));
        }
        return maxArea;
    }
    public static int findMaxAreaInHistogram(int[] arr){
        int len = arr.length;
        int maxArea = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        //traversing left to right, finding left limit
        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i] = 0;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }
        //doing empty to stack
        while(!stack.isEmpty())
            stack.pop();
        
        //traversing right to left, find right limit
        for(int i=len-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i] = len - 1;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        //traversing the array , caculating area
        int[] area = new int[len];
        for(int i=0;i<len;i++){
            area[i] = (right[i] - left[i] + 1) * arr[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        return maxArea;
    }
    
	public static void main(String[] args){
        int[][] arr = {{0,1,1,0},{0,1,0,0},{0,0,0,1}};
	    System.out.println("The maximum area is : " + maximalRectangle(arr));
	}
}

ANS 2
		import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']'){
                stack.push(ch);
            }else{
                //get the sub string
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                //remove the '[' character
                stack.pop();
                //get the number
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = (stack.pop() - '0') * base + k;
                    base *= 10;
                }
                //put back the substring in stack k times
                while(k-- > 0){
                    for(int i=sb.length()-1; i>=0; i--){
                        stack.push(sb.charAt(i));
                    }
                }
            }
        }
        char[] result = new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
            result[i] = stack.pop();
        return new String(result);
    }
	public static void main(String[] args){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Enter a string: ");  
        String str= sc.nextLine(); 
        System.out.println("The decoded string is : " + decodeString(str));
	}
}

	
ANS 3	
		import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
   public static int calPoints(String[] ops) {
    int sum = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0; i < ops.length; i++)
    {
        if(ops[i].equals("+"))
        {
            int temp1 = stack.pop();
            int temp2 = stack.pop();
            int temp_sum = temp1 + temp2;
            sum += temp_sum;
            stack.push(temp2);
            stack.push(temp1);
            stack.push(temp_sum);
        }
        else if(ops[i].equals("D"))
        {
            int temp = stack.pop();
            int temp_d = 2 * temp;
            sum += temp_d;
            stack.push(temp);
            stack.push(temp_d);
        }
        else if(ops[i].equals("C"))
        {
            int cancel = stack.pop();
            sum -= cancel;
        }
        else
        {
            int temp = Integer.parseInt(ops[i]);
            sum += temp;
            stack.push(temp);   
        }
        }
        return sum;
    }
	public static void main(String[] args){
        String []str = {"5" , "2" , "C" , "D" , "+"};
        System.out.println("The score is : " + calPoints(str));
	}
}

ANS 4
	import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int[] asteroidCollision(int[] a) {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<a.length; i++){
            list.add(a[i]);
            int j=list.size()-1;

            // This is the condition for collision
            while(j>0 && (list.get(j)<0 && list.get(j-1)>=0)){
                int first = list.remove(list.size()-1);
                int second = list.remove(list.size()-1);
                int third;
                if(Math.abs(first)==Math.abs(second)){
                    //If both have same value then both will destory
                    j=j-2;
                    continue;
                }else if(Math.abs(first)>Math.abs(second)){
                    //If first have greater value then 2nd will destory
                    j--;
                    list.add(first);
                }else{
                    //If 2nd have greater value then 1st will destory
                    j--;
                    list.add(second);
                }
            }
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
        
    }
	public static void main(String[] args){
        int []a = {5,10,-5};
        System.out.println("The desired output is : ");
        
        int []arr = asteroidCollision(a);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
	}
}

ANS 5		
		import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
   public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int []nge = new int [n]; 
        for(int i=0;i<n;i++)nge[i] = 0;

        Stack<Integer>st = new Stack();
        
		
        for(int i = n-1; i>=0; --i){
           
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
				
           
            if(!st.empty())
                nge[i] = st.peek()-i; // distance between next greater and current
           
            st.push(i);
        }
        return nge;
    }
	public static void main(String[] args){
        int []a = {60 , 45 , 34 , 65 , 38 , 79 , 80};
        System.out.println("The desired output is : ");
        
        int []arr = dailyTemperatures(a);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
	}
}