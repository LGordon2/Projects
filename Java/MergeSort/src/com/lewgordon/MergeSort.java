package com.lewgordon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lew on 10/3/14.
 */
public class MergeSort {
    public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list){
        if(list.size() <= 1){
            return list;
        }
        List<T> list1 = mergeSort(list.subList(0, list.size()/2));
        List<T> list2 = mergeSort(list.subList(list.size()/2, list.size()));
        return merge(list1, list2);
    }

    private static <T extends Comparable<? super T>> List<T> merge(List<T> list1, List<T> list2){
        List<T> newList = new ArrayList<T>();
        int i=0, j=0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i).compareTo(list2.get(j)) < 0)
                newList.add(list1.get(i++));
            else
                newList.add(list2.get(j++));
        }

        while(i < list1.size())
            newList.add(list1.get(i++));

        while(j < list2.size())
            newList.add(list2.get(j++));

        return newList;
    }
}
