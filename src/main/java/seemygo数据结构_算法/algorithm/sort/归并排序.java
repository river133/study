package seemygo数据结构_算法.algorithm.sort;
public class 归并排序<E extends Comparable<E>> extends Sort<E> {
    private E[] temp;
    @Override
    protected void sort() {
        temp = (E[])new Comparable[array.length];
        mergeSort(0,array.length-1);
    }
    //对begin - end 范围归并排序
    private void mergeSort(int low,int high){
        //1、安全校验
        if(low >= high) return ;
        int mid = low+(high-low)/2;

        //3、递归：分别对每一组数据进行排序
        mergeSort(low,mid);
        mergeSort(mid+1,high);

        //4、再把两个组中间的数据进行归并
        merge(low,mid,high);

    }
    private void merge(int low,int mid,int high){
        int i=0;
        int p1=low, p2=mid+1;
        //1、比较2个数组每一个位的大小，并将小的放入temp数组中
        while (p1 <= mid && p2 <= high){
            temp[i++] =cmp(array[p1],array[p2]) < 0 ? array[p1++] :array[p2++];
        }

        //2、如有一个数组指针走完，将另外一个数组的参数追加到temp数组中
        while (p1<=mid)  temp[i++] = array[p1++];
        while (p2<=high) temp[i++] = array[p2++];

        //3、将temp数组copy到原数组
        for(int t=0;t<i;t++){
            array[low+t]=temp[t];
        }
    }
}
