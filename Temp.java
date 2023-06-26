class Solution {
    public int romanToInt(String s) {
        int num = 0, result = 0, prev = 0;
        for(int i = s.length() -1; i >= 0; i--){
            switch (s.charAt(i)){
                case 'M' -> num = 1000;
                case 'D' -> num = 500;
                case 'C' -> num = 100;
                case 'L' -> num = 50;
                case 'X' -> num = 10;
                case 'V' -> num = 5;
                case 'I' -> num = 1;
            }
            if(num < prev){
                result -= num;
            }
            else{
                result += num;
            }

            prev = num;
        }
        return result;
    }

}