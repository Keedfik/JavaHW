import java.util.Scanner;

public class HW1 {
    /*
    1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    2) Вывести все простые числа от 1 до 1000
    3) Реализовать простой калькулятор
    4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
    например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, 
    что его нет.

    */
    public static void main(String[] args) {
        /* 
        // ------- 1 -------
        Scanner in = new Scanner(System.in);
        System.out.println("Input number");
        int num = in.nextInt();
        int sum = 0;  
        int fact = 1;
        if(num >0){
            for(int i=1; i<=num; i++){
                sum += i;
                fact *= i;
            }
            System.out.println("Sum of numbers from 1 to "+num+" = "+sum);
            System.out.println(num+"! = "+fact);
        }else{
            for(int i=1; i>=num; i--){
                sum += i;
            }
            System.out.println("Sum of numbers from 1 to "+num+" = "+sum);
            System.out.println("Factorial doesn't exist");
        }
        // ------- 1 -------
        */
        // ------- 2 -------
        for (int i = 2; i <= 1000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
                if(flag){
                    System.out.println(i);
                }
            }
        }
        // ------- 2 -------
    }
    
