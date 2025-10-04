package variables;


public class ConstantsAndScope {
    static final double PI = 3.14159;

    public static void main(String[] args) {
        someMethod();
        String name = "ILIA";
        final String SECOND_NAME = "IUKIN";
        {
            int block = 1;
            String blockS = "Inside block";
            System.out.println(blockS);
        }
//        System.out.println(blockS);   вызывает ошибку компиляции из-за того что вызывается вне блока
        System.out.println(name);
        System.out.println(SECOND_NAME);
        System.out.println(PI);

    }

    public static void someMethod() {
        String methodString = "Method String";
        int methodInt = 5;
        final String SECOND_NAME = "ARTEM";
        System.out.println(methodInt);
        System.out.println(methodString);
        System.out.println(SECOND_NAME);
    }
}


