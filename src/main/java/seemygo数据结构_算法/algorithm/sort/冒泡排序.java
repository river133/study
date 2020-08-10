package seemygo数据结构_算法.algorithm.sort;

import seemygo数据结构_算法.util.Integers;
import seemygo数据结构_算法.util.Times;

public class 冒泡排序 extends Sort{
    public static void main(String[] args) {

//        Integer[] array1 = Integers.random(10000,1,100000);
        //完全升序
//        Integer[] array1 = Integers.ascOrder(1,5);
        //尾部升序
        Integer[] array1 = Integers.tailAscOrder(1,5,3);
        Integers.println(array1);
        Integer[]array2 = Integers.copy(array1);
        Integer[]array3 = Integers.copy(array1);
        //测试冒泡排序 1 性能
        Times.test("bubbleSort1",()->{
            bubbleSort1(array1);
        });
        //测试冒泡排序 2 性能
        Times.test("bubbleSort2",()->{
            bubbleSort2(array2);
        });
        //测试冒泡排序 3 性能
        Times.test("bubbleSort3",()->{
            bubbleSort3(array3);
        });
        //打印
//        Integers.println(array3);
    }
    //冒泡排序1
    static void bubbleSort1(Integer[]array){
        for (int end = array.length-1; end > 0 ; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if(array[begin-1]>array[begin]){
                    int temp = array[begin-1];
                    array[begin-1]=array[begin];
                    array[begin]=temp;
                }
            }
        }
    }
    //冒泡排序 优化2
    static void bubbleSort2(Integer[]array){
        for (int end = array.length-1; end > 0 ; end--) {
            boolean sorted=true;
            for (int begin = 1; begin <= end; begin++) {
                if(array[begin-1]>array[begin]){
                    int temp = array[begin-1];
                    array[begin-1]=array[begin];
                    array[begin]=temp;
                    sorted=false;
                }
            }
            if(sorted)break;
        }
    }
    //冒泡排序 优化3
    static void bubbleSort3(Integer[]array){
        for (int end = array.length-1; end > 0 ; end--) {
            int sortedIndex =1;
            for (int begin = 1; begin <= end; begin++) {
                if(array[begin-1]>array[begin]){
                    int temp = array[begin-1];
                    array[begin-1]=array[begin];
                    array[begin]=temp;
                    sortedIndex=begin;
                }
            }
            end = sortedIndex;
        }
    }

    @Override
    protected void sort() {
        for (int end = array.length-1; end > 0 ; end--) {
            for (int begin = 1; begin <= end; begin++) {
//                if(array[begin] < rray[begin-1]){
                if(cmp(begin,begin-1)<0){
                    swap(begin,begin-1);
                }
            }
        }
    }
}
