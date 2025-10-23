package ru.mentee.power.loop;

public class ShapeDrawer {
    public String drawSquare(int size) {
    if (size <=0){
        return "";
    }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int index = 0; index < size; index++) {
                result.append("*");
            }
            if (i < size - 1) {
                result.append('\n');
            }
        }
        return result.toString();
    }

    public String drawEmptySquare(int size) {
        if (size <=0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    result.append('*');
                } else {
                    result.append(' ');
                }
            }
            if (i < size - 1) {
                result.append('\n');
            }
        }
        return result.toString();
    }

    public String drawTriangle(int height) {
        if (height <=0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                    result.append("*");
                }
                if (i < height - 1){
                    result.append("\n");
                }
            }
            return result.toString();
        }


    public String drawRhombus(int size) {
        if (size <=0){
            return "";
        }
        if (size % 2 == 0) {
            size = size + 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int mid = size / 2;
                int distance = Math.abs(mid - i);
                int leftBound = distance;
                int rightBound = size - distance - 1;
                if (j >= leftBound && j <= rightBound) {
                    result.append('*');
                } else {
                    result.append(' ');
                }
            }
            if (i < size - 1) {
                result.append('\n');
            }
        }
            return result.toString();
        }


        public void printShape (String shape){
            System.out.println(shape);
        }

        public static void main (String[]args){
            ShapeDrawer drawer = new ShapeDrawer();

            System.out.println("Квадрат 5x5:");
            drawer.printShape(drawer.drawSquare(5));

            System.out.println("\nПустой квадрат 5x5:");
            drawer.printShape(drawer.drawEmptySquare(5));

            System.out.println("\nТреугольник высотой 5:");
            drawer.printShape(drawer.drawTriangle(5));

        System.out.println("\nРомб размером 5:");
        drawer.printShape(drawer.drawRhombus(5));
        }
    }





