package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
   
    public  AtomicInteger inc = new AtomicInteger();
 
    public  void increase() {
		inc.getAndIncrement();
    }
 
    public static void main(String[] args) throws Exception{
        
        String regEx = "df";  
        String s = "count000dfdfsdffaaaa1";  
        Pattern pat = Pattern.compile(regEx);  
        Matcher mat = pat.matcher(s);  
        while(mat.find()){
           System.out.println(mat.group());
        }
    }
}