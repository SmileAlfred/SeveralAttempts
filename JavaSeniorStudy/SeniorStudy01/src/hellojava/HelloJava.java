package hellojava;

public class HelloJava {
    public static void main(String[] args) {
        String test = "1 2 3 4 5 6 7";
        power(test);
    }

    public long power (String input) {
        // write code here
        String[] test = input.split(" ");
        long  sum = 0 ;
        for(int i=5 ; i > -1 ; i --){
            long result = Integer.parseLong(test[i]);
            for(int j = 1; j <Integer.parseLong(test[i+1]); j ++){
                result *=Integer.parseInt(test[i]) ;
            }
            sum += result;
        }
        System.out.println(sum);
        return sum;
    }
}
