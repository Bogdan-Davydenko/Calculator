import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Expression ex = new Expression(4,2,'/');



        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int ans = ExpressionReader.read(s).calculate();

        if(s.contains("I")||s.contains("V")||s.contains("X")){
            System.out.println(ArabicToRoman(ans));
        }else{
            System.out.println(ans);
        }
    }

    static private String ArabicToRoman(int a){
        if(a<=0){
            throw new ArithmeticException("Число меньше I");
        }
        StringBuilder ans = new StringBuilder();
        while(a!=0){
            if(a>=10){
                a-=10;
                ans.append('X');
                continue;
            }
            if(a>=9){
                a-=9;
                ans.append("IX");
                continue;
            }
            if(a>=5){
                a-=5;
                ans.append("V");
                continue;
            }
            if(a>=4){
                a-=9;
                ans.append("IV");
                continue;
            }
            if(a>=1){
                a-=9;
                ans.append("I");
                continue;
            }
        }

        return ans.toString();
    }
}
