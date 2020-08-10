package seemygo数据结构_算法.algorithm.sort;

public class 插入排序<E extends Comparable<E>> extends Sort<E> {
    //1、挪动优化
    protected void sort1() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur];
            //逆序条件下优化
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
    //2、二分搜索优化
    protected void sort2() {
        for (int begin = 1; begin < array.length; begin++) {
            E v = array[begin];
            int insertIndex = search(begin);//待插入位置
            for (int i = begin; i > insertIndex; i--) {
                array[i]=array[i-1];
            }
            array[insertIndex] = v;
        }
    }
    //3、二分搜索优化
    @Override
    protected void sort(){
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin,search(begin));
        }
    }

    /**
     * 将source位置的元素插入到dest位置
     * @param source
     * @param dest
     */
    private void insert(int source,int dest){
        E v = array[source];
        for (int i = source; i > dest; i--) {
            array[i]=array[i-1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索到 index 位置元素的待插入位置
     已经排好序数组的区间范围是[0,index]
     * @index 待插入位置
     * @return
     */
    private int search(int index) {
        //array[index] 待插入的元素
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index],array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
