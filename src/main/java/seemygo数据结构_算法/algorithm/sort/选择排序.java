package seemygo数据结构_算法.algorithm.sort;

import seemygo数据结构_算法.util.Assert;
import seemygo数据结构_算法.util.Integers;

/**
 * @outhor river
 * @date 2020/7/1 - 18:11
 */
public class 选择排序 extends Sort{
    public static void main(String[] args) {

        Integer[] array = Integers.random(43,1,111);
        selectinonSort(array);
        Assert.test(Integers.isAscOrder(array));

    }
    //选择排序
    static void selectinonSort(Integer[] array){
        for (int end = array.length-1; end > 0 ; end --) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end ; begin++) {
                //>= 稳定
                if(array[maxIndex] <= array[begin] ){
                    maxIndex=begin;
                }
            }
            //交换
            int tmp = array[maxIndex];
            array[maxIndex]=array[end];
            array[end]=tmp;
        }

    }
    //选择排序
    @Override
    protected void sort() {
        for (int end = array.length-1; end > 0 ; end --) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end ; begin++) {
                //>= 稳定
//                if(array[maxIndex] <= array[begin] ){
                if(cmp(maxIndex,begin)<=0 ){
                    maxIndex=begin;
                }
            }
            swap(maxIndex,end);//交换
        }
    }
}
