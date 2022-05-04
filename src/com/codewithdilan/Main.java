package com.codewithdilan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface LambdaMedian{
    double findMedian(List<Double> sortedList);
}

public class Main {

    public static double normalMin(List<Double> inputList){
        double minValue = inputList.get(0);
        for(int i=1; i< inputList.size(); i++){
            if(inputList.get(i) < minValue){
                minValue = inputList.get(i);
            }
        }
        return minValue;
    }

    public static double normalMax(List<Double> inputList){
        double maxValue = inputList.get(0);
        for(int i=1; i< inputList.size(); i++){
            if(inputList.get(i) > maxValue){
                maxValue = inputList.get(i);
            }
        }
        return maxValue;
    }

    public static double normalAvg(List<Double> inputList){
        double total = 0;
        for(int i=0; i< inputList.size(); i++){
            total = total + inputList.get(i);
        }
        double average = total / inputList.size();
        return average;
    }

    public static double normalMedian(List<Double> sortedList){
        double median = sortedList.get(0);
        if (sortedList.size() % 2 == 0){
            median = (sortedList.get(sortedList.size()/2) + sortedList.get(sortedList.size()/2 - 1)) / 2;
        }else{
            median = sortedList.get(sortedList.size()/2);
        }
        return median;
    }

    public static void main(String[] args) {
        List<Double> number = Arrays.asList(17.64, 55.56, 36.93, 55.96, 20.23, 41.74, 1.8, 95.97, 81.89, 36.16, 34.41, 87.9, 13.74, 11.15);

        Double lambdaMin = number.stream().mapToDouble(v -> v).min().orElse(Double.NaN);
        Double lambdaMax = number.stream().mapToDouble(v -> v).max().orElse(Double.NaN);
        Double lambdaAvg = number.stream().mapToDouble(v -> v).average().orElse(Double.NaN);

        LambdaMedian lambdaMedian = (sortedList)->{
            double median = sortedList.get(0);
            if (sortedList.size() % 2 == 0){
                median = (sortedList.get(sortedList.size()/2) + sortedList.get(sortedList.size()/2 - 1)) / 2;
            }else{
                median = sortedList.get(sortedList.size()/2);
            }
            return median;
        };

        //Calculating Min value
        long startTimeNormalMin = System.nanoTime();
        System.out.println("Minimum value calculated using normal method: "+ normalMin(number));
        long stopTimeNormalMin = System.nanoTime();
        long executionTimeNormalMin = stopTimeNormalMin - startTimeNormalMin;
        System.out.println("(Execution Time: "+ executionTimeNormalMin+ " nanoseconds)");

        long startTimeLambdaMin = System.nanoTime();
        System.out.println("Minimum calculated using Lambda expressions: "+ lambdaMin);
        long stopTimeLambdaMin = System.nanoTime();
        long executionTimeLambdaMin = stopTimeLambdaMin - startTimeLambdaMin;
        System.out.println("(Execution Time: "+executionTimeLambdaMin+" nanoseconds)");

        float percentDiffMin = ((float)(executionTimeNormalMin-executionTimeLambdaMin) / (float)(executionTimeNormalMin+executionTimeLambdaMin)) * 200;
        System.out.println("********** Percent Difference: " + percentDiffMin + "% **********\n");

        //Calculating Max value
        long startTimeNormalMax = System.nanoTime();
        System.out.println("Maximum value calculated using normal method: "+ normalMax(number));
        long stopTimeNormalMax = System.nanoTime();
        long executionTimeNormalMax = stopTimeNormalMax - startTimeNormalMax;
        System.out.println("(Execution Time: "+ executionTimeNormalMax+ " nanoseconds)");

        long startTimeLambdaMax = System.nanoTime();
        System.out.println("Maximum calculated using Lambda expressions: "+ lambdaMax);
        long stopTimeLambdaMax = System.nanoTime();
        long executionTimeLambdaMax = stopTimeLambdaMax - startTimeLambdaMax;
        System.out.println("(Execution Time: "+executionTimeLambdaMax+" nanoseconds)");

        float percentDiffMax = ((float)(executionTimeNormalMax-executionTimeLambdaMax) / (float)(executionTimeNormalMax+executionTimeLambdaMax)) * 200;
        System.out.println("********** Percent Difference: " + percentDiffMax + "% **********\n");

        //Calculating Average
        long startTimeNormalAvg = System.nanoTime();
        System.out.println("Average calculated using normal method: "+ normalAvg(number));
        long stopTimeNormalAvg = System.nanoTime();
        long executionTimeNormalAvg = stopTimeNormalAvg - startTimeNormalAvg;
        System.out.println("(Execution Time: "+ executionTimeNormalAvg+ " nanoseconds)");

        long startTimeLambdaAvg = System.nanoTime();
        System.out.println("Average calculated using Lambda expressions: "+ lambdaAvg);
        long stopTimeLambdaAvg = System.nanoTime();
        long executionTimeLambdaAvg = stopTimeLambdaAvg - startTimeLambdaAvg;
        System.out.println("(Execution Time: "+ executionTimeLambdaAvg +" nanoseconds)");

        float percentDiffAvg = ((float)(executionTimeNormalAvg-executionTimeLambdaAvg) / (float)(executionTimeNormalAvg+executionTimeLambdaAvg)) * 200;
        System.out.println("********** Percent Difference: " + percentDiffAvg + "% **********\n");

        //Calculating Median
        Collections.sort(number);
        long startTimeNormalMedian = System.nanoTime();
        System.out.println("Median calculated using normal method: "+ normalMedian(number));
        long stopTimeNormalMedian = System.nanoTime();
        long executionTimeNormalMedian = stopTimeNormalMedian - startTimeNormalMedian;
        System.out.println("(Execution Time: "+ executionTimeNormalMedian+ " nanoseconds)");

        Collections.sort(number);
        long startTimeLambdaMedian = System.nanoTime();
        System.out.println("Median calculated using Lambda block: "+ lambdaMedian.findMedian(number));
        long stopTimeLambdaMedian = System.nanoTime();
        long executionTimeLambdaMedian = stopTimeLambdaMedian - startTimeLambdaMedian;
        System.out.println("(Execution Time: "+ executionTimeLambdaMedian +" nanoseconds)");

        float percentDiffMedian = ((float)(executionTimeNormalMedian-executionTimeLambdaMedian) / (float)(executionTimeNormalMedian+executionTimeLambdaMedian)) * 200;
        System.out.println("********** Percent Difference: " + percentDiffMedian + "% **********\n");

    }
}
