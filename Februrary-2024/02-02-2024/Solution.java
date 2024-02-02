import java.util.ArrayList;
import java.util.List;

class Solution {
    private int getCount(int temp) {
        int count = 0;
        while(temp > 0) {
            count++;
            temp = temp / 10;
        }
        return count;
    }
    private int getNumber(int temp) {
        int number = 0;
        int count = getCount(temp);
        for(int i=1;i<=count;i++) {
            number = number * 10 + i;
        }
        return number;
    }
    private int getAddOn(int temp) {
        int number = 0;
        int count = getCount(temp);
        for(int i=1;i<=count;i++) {
            number = number * 10 + 1;
        }
        return number;
    }

    private boolean checkNumber(int number) {
        int a = number % 10;
        number = number / 10;
        while(number > 0) {
            if(--a != number % 10) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int number = getNumber(low);
        
        while(number <= high) {
            if(number >= low && checkNumber(number)) {
                result.add(number);
                number = number + getAddOn(number); 
            }
            else if(number > high) {
                break;
            } 
            else {
                if(getCount(number) >= 9) {
                    break;
                }
                if(!checkNumber(number))
                number = getNumber((number-1) * 10);
                else
                number = number + getAddOn(number); 

            }
        }
        return result;
    }
}