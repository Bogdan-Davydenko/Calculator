public class ExpressionReader{
    static Expression read(String ex){
        //"23 + 22"
        boolean f=false;
        int a=0;
        int b=0;
        int c=0;
        StringBuilder RomeA = new StringBuilder();
        String RomeB = "";
        char sign = '=';
        for(int i=0;i<ex.length();i++) {

            if (ex.charAt(i) >= '0' && ex.charAt(i) <= '9') {
                a *= 10;
                a += ex.charAt(i) - '0';
            }else if(ex.charAt(i) == 'I' || ex.charAt(i)== 'V' || ex.charAt(i) == 'X'){
                RomeA.append(ex.charAt(i));
            }else if (ex.charAt(i) == ' ') {
                c++;
                if (c == 2) {
                    RomeB = RomeA.toString();
                    RomeA = new StringBuilder();
                    b = a;
                    a = 0;
                }
            } else if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '/' || ex.charAt(i) == '*') {
                if(f){
                    throw new RuntimeException("Неверный ввод.");
                }
                f=true;
                sign = ex.charAt(i);
            }else{
                throw new RuntimeException("Неверный ввод.");
            }
        }

        if((!RomeA.toString().equals("")||!RomeB.equals(""))&&a>0||b>0){
            throw new ArithmeticException("Попытка использовать римские и арабские числа одновременно.");
        }

        if(a==0&&b==0){
            a=RomeNum(RomeA.toString());
            b=RomeNum(RomeB);
        }

        if(a>10||b>10||a<0||b<0){
            throw new ArithmeticException("Число не принадлежит итервалу [0;10].");
        }

        if(sign=='='){
            throw new ArithmeticException("Неверный символ выражения.");
        }

        return new Expression(b,a,sign);
    }

    private static int RomeNum(String s){
        if(s.equals("I")){
            return 1;
        }else if(s.equals("II")){
            return 2;
        }else if(s.equals("III")){
            return 3;
        }else if(s.equals("IV")){
            return 4;
        }else if(s.equals("V")){
            return 5;
        }else if(s.equals("VI")){
            return 6;
        }else if(s.equals("VII")){
            return 7;
        }else if(s.equals("VIII")){
            return 8;
        }else if(s.equals("IX")){
            return 9;
        }else if(s.equals("X")){
            return 10;
        }else{
            throw new ArithmeticException("Число не принадлежит итервалу [0;10].");
        }
    }

}
/// 12 + 2