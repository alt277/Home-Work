package ru.gbyte.bracket;
                         /*  написать программу проверки скобочной последовательности:
                             программа (либо в консоли, либо в методе) принимает строку,
                             состоящую из скобочной последовательности (скобки только круглые).
                             Если скобочная последовательность правильная, в консоль выводится ok  */
public class Bracket {
    private String input;
    private boolean flag;
    public Bracket(String in ){
        input = in;
        flag=true;
    }
    public void check (){
        int size = input.length ();
        Stack st = new Stack( size );

        for ( int i = 0; i < input.length (); i ++){

            char ch = input.charAt ( i );
            switch (ch){

                case '(':
                    st.push (ch);
                    break;
                case ')':
                    if (! st.isEmpty ()){
                        char chr = st.pop ();

                    } else {
                        System.out.println ( "Not OK. Error: missing left bracket "  );
                        flag=false;
                    }
                    break;
                default:
                    break;
            }
        }

        if (! st . isEmpty ()){
            System.out.println("Not OK. Error: missing right bracket " );
            flag=false;
        }
        if(flag){
            System.out.println("Everything is OK");
        }

    }
}