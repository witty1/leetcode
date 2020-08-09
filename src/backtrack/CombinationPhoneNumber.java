package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/9
 * @Time: 8:43
 * @Description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
@SuppressWarnings("all")
public class CombinationPhoneNumber {
    List<String> list = new ArrayList<>();
    Map<String,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return list;
        }
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

            generate("",0,digits);


        return list;
    }

    public void generate(String s,int index,String digits) {
        if (index==digits.length()){
            list.add(s);
            return;
        }
        String c = String.valueOf(digits.charAt(index));
        String str = map.get(c);
        for (int i=0;i<str.length();i++){
            generate(s+str.charAt(i),index+1,digits);
        }
    }
}
