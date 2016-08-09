import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 10.07.2016.
 */
public class ArrayInversions {
    private static long nInversions = 0;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String num;
        while ((num = reader.readLine()) != null) {
            //System.out.println(num);
            arr.add(Integer.parseInt(num));
        }
        nInversions = 0;
        System.out.println(arr.get(3));
        System.out.println(mergeSort(arr));
        System.out.println(nInversions);
    }

    private static List<Integer> mergeSort(List<Integer> aList) {
        if (aList.size() == 1) {
            return aList;
        }
        List<Integer> leftAList = new ArrayList<Integer>();
        List<Integer> rightAList = new ArrayList<Integer>();
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        leftAList = mergeSort(aList.subList(0, aList.size()/2));
        rightAList = mergeSort(aList.subList(aList.size()/2, aList.size()));
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < leftAList.size() && rightIndex < rightAList.size()) {
            if (leftAList.get(leftIndex) <= rightAList.get(rightIndex)) {
                sortedList.add(leftAList.get(leftIndex));
                leftIndex++;
            }
            else {
                sortedList.add(rightAList.get(rightIndex));
                rightIndex++;
                nInversions += leftAList.size() - leftIndex;
                if (leftAList.size() - leftIndex < 0) {
                    System.out.println(leftAList + ", " + leftIndex);
                }
            }
        }
        while (leftIndex < leftAList.size()) {
            sortedList.add(leftAList.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < rightAList.size()) {
            sortedList.add(rightAList.get(rightIndex));
            rightIndex++;
        }
        return sortedList;
    }
}
