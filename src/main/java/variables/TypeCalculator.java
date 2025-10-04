package variables;

public class TypeCalculator {
    public static void main(String[] args) {
        byte byteR = 100;
        short shortR = 3;
        int intR = 1;
        long longL = 1000L;
        float floatF = 3.14f;
        double doubleD = 2.5;

        // byte (100) + int (1) = 101(int)
        // long(1000L) * double(2.5) = 2500L (long)
        // float(3.14f) + int(1) = 4.14f(float)
        // short(3) + int(1) = 4 (int)
    }
}
