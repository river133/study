package java高并发编程.c_026;

public class T {
    public static void main(String[] args) {
        for (int i = 1; i <20 ; i++) {

            if(isPrime(i)){
                System.out.print(i+"_");
            }
//        System.out.println(isPrime(i)+"_"+i);
        }
    }
    static boolean isPrime(int num){
        for (int i = 2; i <=num/2; i++) {
            if(num%i==0)return false;
        }
        return true;
    }
}
