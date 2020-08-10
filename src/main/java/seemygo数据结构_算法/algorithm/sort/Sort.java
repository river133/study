//排序父类
package seemygo数据结构_算法.algorithm.sort;
public abstract class Sort<E extends Comparable<E>> {
    protected E[]array;
    private int cmpCount;//比较次数
    private int swapCount;//交换次数
    public void sort(E[]array){
        if(array==null|| array.length < 2)return;
        this.array=array;
        sort();
    }
    protected abstract void sort();
    //返回值==0，代表相等

    /**
     * 返回值=0，代表相等
     * 返回值<0，array[i1] < array[i2]
     * 返回值>0，array[i1] > array[i2]
     */
    protected int cmp(int i1,int i2){
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }
    protected int cmp(E v1,E v2){
        cmpCount++;
        return v1.compareTo(v2);
    }
    //交换
    protected void swap(int i1,int i2){
        swapCount++;
        E tmp=array[i1];
        array[i1]=array[i2];
        array[i2]=tmp;
    }
    //是否稳定排序
    private boolean isStable(){
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i]=new Student(i*10,10);
        }
//            {0,10},{10,10},{20,10},
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i-1].score;
            if(score != prevScore+10)return false;
        }
        return true;
    }
}
