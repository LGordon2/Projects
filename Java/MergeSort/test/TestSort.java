import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static com.lewgordon.Sort.bubbleSort;
import static com.lewgordon.Sort.mergeSort;
import static org.junit.Assert.assertTrue;

/**
 * Created by lew on 10/5/14.
 */
public class TestSort {
    Logger log = Logger.getLogger(TestSort.class.getName());

    private List<Integer> list;

    @Before
    public void setupData(){
        Random rand = new Random();
        list = listFactory(rand.nextInt(100));
        log.info("List: " + prettyPrint(list));
    }

    @Test
    public void testMergeSort(){
        list = mergeSort(list);
    }

    @Test
    public void testBubbleSort(){
        list = bubbleSort(list);
    }

    @After
    public void verifyListIsSorted(){
        log.info("Sorted List: " + prettyPrint(list));
        assertTrue("List is not sorted.", verifySorted(list));
    }

    private static <E> String prettyPrint(List<E> list) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        for(int i=0; i<list.size(); i++){
            builder.append(list.get(i));
            if(i<list.size()-1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private static List<Integer> listFactory(int numberOfElements){
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>(numberOfElements);
        for(int i=0; i<numberOfElements; i++){
            list.add(rand.nextInt(100));
        }
        return list;
    }

    private static <T extends Comparable<T>> boolean verifySorted(List<T> list){
        if(list.size() <= 1){
            return true;
        }

        for(int i=0;i<list.size()-2;i++){
            if(list.get(i).compareTo(list.get(i+1)) > 0){
                return false;
            }
        }
        return true;
    }
}
