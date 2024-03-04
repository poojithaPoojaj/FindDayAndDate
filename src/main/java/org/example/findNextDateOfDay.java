package org.example;

import java.util.HashMap;

public class findNextDateOfDay {
    static HashMap<Integer,Integer> monthDays=new HashMap<>();
    public static int getCenturyCode(int year){
        int[] centuryCode={4,2,0,6};
        int basicCentury=17;
        int yearValue=year/100;
        int difference=Math.abs(yearValue-basicCentury);
        return centuryCode[difference%4];
    }
    public static void findNextDateOfDay(int date,int month,int year){
        monthDays.put(1,31);
        monthDays.put(2,28);
        monthDays.put(3,31);
        monthDays.put(4,30);
        monthDays.put(5,31);
        monthDays.put(6,30);
        monthDays.put(7,31);
        monthDays.put(8,31);
        monthDays.put(9,30);
        monthDays.put(10,31);
        monthDays.put(11,30);
        monthDays.put(12,31);

        boolean isLeapYear=year%100==0?year%400==0:year%4==0;
        if (isLeapYear) {
            monthDays.put(2,29);
        }

        int totalDays=monthDays.get(month);
        if(date+7<=totalDays){
            System.out.println(date+7+" "+month+" "+year);
            return;
        }
        else if(date+7>totalDays && month!=12){
            System.out.println(7-(totalDays-date)+" "+month+1+" "+year);
            return;
        }
        else{
            System.out.println(7-(totalDays-date)+" "+1+" "+(year+1));
            return;
        }
    }
    public static String findDayOfDate(int date,int month,int year){


        int[] monthCode={1,4,4,0,2,5,0,3,6,1,4,6};
        String[] dayCode={"sat","sun","mon","tue","wed","thu","fri"};

        boolean isLeapYear=year%100==0?year%400==0:year%4==0;
        int centuryCode=getCenturyCode(year);
        int lastTwoDigitsOfYear=year%100;

        int totalValue=date+monthCode[month-1]+centuryCode+lastTwoDigitsOfYear+(lastTwoDigitsOfYear/4);
        int finalValue=totalValue%7;
        if(isLeapYear && month<=2)
            finalValue=finalValue-1;

        return dayCode[finalValue];
    }

    public static void main(String[] args) {
        System.out.println( findDayOfDate(4,3,2024));
       findNextDateOfDay(4,3,2024);
    }
}