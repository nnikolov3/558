public class Homework1_3 {

        public static void main(String[] args) {
                double den1 = 2;
                double num1 = 5; 
                Rational rat1;
                rat1 = new Rational(num1,den1);
                double sumRat1 = rat1.sum();
                System.out.println(rat1.toString());
                System.out.println(sumRat1);
        }

}

