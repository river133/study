package seemygo数据结构_算法.algorithm.sort;
public class 堆排序<E extends Comparable<E>> extends Sort<E>{
    private int heapSize;
    @Override
    protected void sort() {
        //原地建堆,下滤
        heapSize = array.length;
        for (int i = (heapSize >> 1)-1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1){
            //交换堆顶和队尾元素
            swap(0,--heapSize);
            //对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }
    }
    //下滤
    private void siftDown(int index){
        E element = array[index];
        int half = heapSize>>1;//叶子节点计算公式
        //必须保证index位置是非叶子节点
        while (index < half){

            //默认为左子节点
            int childIndex = (index<<1) + 1;
            E child = array[childIndex];

            //右子节点
            int rightIndex = childIndex+1;

            //选出左右子节点最大的那个
            if(rightIndex < heapSize && cmp(array[rightIndex],child)>0){
                child = array[childIndex = rightIndex];
            }
            if(cmp(element,child) >= 0)break;

            array[index]=child; //将子节点存放到index位置
            index=childIndex;
        }
        array[index]=element;
    }

}
