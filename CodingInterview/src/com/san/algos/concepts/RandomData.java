package com.san.algos.concepts;
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
// test
/*
Design a data structure to hold objects with a corresponding integer weight. It should support:

- Obtain an object randomly with probability equal to (weight of the element) / (sum of the weights).
- Set an object-weight pair. If the object is already in the structure, its weight will be updated. Otherwise, the object will be inserted and set to its weight. If the weight is zero, the object can be removed.


GOOG - 1000 - 20%
MSFT - 4000 - 80%


https://www.hackerrank.com/environment/sample-problem/java
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RandomData
{
    private class Data{
        String key;
        double value;
        double returnTimes;
        
        
        public String toString(){
            return key + " : "  + value;
        }
    }
    private int requestCount;
    private Map<String, Data> objects;
    private double sum;
    private List<Data> objectList;
    private int requestTimes;
    public RandomData(int times){
        objects = new HashMap<String, Data>();
        sum = 0;
        requestTimes = times;
        
    }
    
    public void parseInfo(String key, int value)
    {
        
        if( value == 0){
            objects.remove(key);
            Data prev = (Data )objects.get(key);
            sum -= prev.value;
            
        }else{
            sum += value;
            Data d = new Data();
            d.key = key;
            d.value = value;
            //d.returnTimes = (int)((value /  sum) * 10);
            objects.put( key, d);
        }
    }
    /**
    public void setProbs()
    {
        for(Map.Entry<String, Data> object : objects.entrySet()){
            Data d = (Data) object.getValue();
            int returnTimes = Math.floor((d.value / sum) * (double)requestCount );
            d.returnTimes = returnTimes;
        }
    }**/
    
    public String getValue()
    {
       // setProbs();
        //requestCount++;
        while(true){
            int rand = (int)( Math.random() * objects.size() );
            List<String> keyList =  new ArrayList<String>(objects.keySet());
            String key = keyList.get(rand);
            Data d = (Data)objects.get(key);
            if(d.returnTimes > 0 ){
                
                d.returnTimes--;
                return d.toString();
            }
        }
    //    return "";
    }
    
    public void setReturnTimes(){
    	for(Map.Entry<String, Data> entry : objects.entrySet()){
    		Data d = (Data)entry.getValue();
    		d.returnTimes =  (d.value/sum ) * 10;
    		objects.put(entry.getKey(), d);
    	}
    }
    public static void main( String args[])
    {
        
        int requestTimes = 5;
        RandomData solution = new RandomData(requestTimes);
        solution.parseInfo("goog", 1000);
        solution.parseInfo("msft", 4000);
        
        solution.setReturnTimes();
        for(int i = 0; i < requestTimes; i++){
            System.out.println(solution.getValue());
        }
        
        
    }    
}
