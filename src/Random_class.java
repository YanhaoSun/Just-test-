import java.util.Random;


public class Random_class
{
    public static void main(String[] args) {
        Random a = new Random();//instance of random class
        int upperbound = 6;//产生随机数的最大上限

        int int_rand = a.nextInt(upperbound)+1;
        String ha = String.valueOf(int_rand);
        System.out.println("ha = "+ha);
        double double_rand = a.nextDouble();
        float float_rand = a.nextFloat();

        System.out.println("Random integer value from 1 to " + (upperbound) + " : "+ int_rand);
        /*System.out.println("Random float value between 0.0 and 1.0 : "+float_rand);
        System.out.println("Random double value between 0.0 and 1.0 : "+double_rand);*/
    }
}
