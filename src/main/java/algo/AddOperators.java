package main.java.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddOperators {
	public AddOperators() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> addOperators(String num, int target) {
        int len = num.length();
        List<String> results = new ArrayList<String>();
        addOperatorsHelper2(num, target, 0, "", 0, 0, results);
        return results;
    }
    
    public void addOperatorsHelper(String num, int target, List<String> results, int start){
        if(equalsToTarget(num, target)){
            results.add(num);
        }
        
        for(int i = start; i < num.length() - 1; i ++){

            String s = num.substring(0, i + 1) + "+" + num.substring(i + 1);
            addOperatorsHelper(s, target, results, i + 2);
            
            s = num.substring(0, i + 1) + "-" + num.substring(i + 1);
            addOperatorsHelper(s, target, results, i + 2);
            
            s = num.substring(0, i + 1) + "*" + num.substring(i + 1);
            addOperatorsHelper(s, target, results, i + 2);
        }
    }
    
    public boolean equalsToTarget(String num, int target){
        LinkedList<Long> nums = new LinkedList<Long>();
        LinkedList<Character> ops = new LinkedList<Character>();
        long number = 0;
        for(int i = 0; i < num.length(); i ++){
            char c = num.charAt(i);
            if(c != '+' && c != '-' && c != '*'){
                if(number == 0 && c =='0' && i != num.length() - 1 && num.charAt(i + 1) != '+' &&
                num.charAt(i + 1) != '-' && num.charAt(i + 1) != '*')
                    return false;
                number = number * 10 + c -'0';
            }else{
                if(!ops.isEmpty() && ops.get(ops.size() - 1) == '*'){
                    ops.remove(ops.size() - 1);
                    long multi = nums.remove(nums.size() - 1);
                    number = multi * number;
                }
                nums.add(number);
                ops.add(c);
                number = 0;
            }
        }
        
        if(!ops.isEmpty() && ops.get(ops.size() - 1) == '*'){
            ops.remove(ops.size() - 1);
            long multi = nums.remove(nums.size() - 1);
            number = multi * number;
        }
        nums.add(number);        
        
        
        int numsSize = nums.size();
        number = nums.get(0);
        for(int i = 0; i < numsSize - 1; i ++){
            char c = ops.get(i);
            if(c == '+'){
                number = number + nums.get(i + 1);
            }else{
                number = number - nums.get(i + 1);
            }
        }
        
        if(number == target)
            return true;
        else
            return false;
        
    }
    
    public void addOperatorsHelper2(String num, int target, int start, String path, long eval, long multi, List<String> results){
        if(start == num.length() && eval == target){
            results.add(path);
        }
        
        for(int i = start + 1; i <= num.length(); i ++){
            if(num.charAt(start) == '0' && i != start + 1){
                break;
            }
            String currStr = num.substring(start, i);
            long currNum = Long.parseLong(currStr);
            if(start == 0){
                addOperatorsHelper2(num, target, i, currStr, currNum, currNum, results);
            }else{    
                addOperatorsHelper2(num, target, i, path + '+' + currStr, eval + currNum, currNum, results);
                addOperatorsHelper2(num, target, i, path + '-' + currStr, eval - currNum, -currNum, results);
                addOperatorsHelper2(num, target, i, path + '*' + currStr, eval - multi + multi * currNum, multi *currNum, results);
            }
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOperators t = new AddOperators();
		List<String> r = t.addOperators("123", 6);
		for(int i = 0; i < r.size(); i ++){
			System.out.println(r.get(i));
		}

	}

}
