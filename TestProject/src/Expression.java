public class Expression{

    private int a;
    private int b;
    private char sign;

    Expression(int a,int b, char sign){
        this.a = a;
        this.b = b;
        this.sign = sign;
    }

    public int calculate(){
        if(sign == '+'){
            return a+b;
        }else if(sign == '-'){
            return a-b;
        }else if(sign == '*'){
            return a*b;
        }else {
            return a / b;
        }
    }
}
