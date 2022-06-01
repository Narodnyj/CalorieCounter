import java.util.Scanner;
public class Counter {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        StepTracker one = new StepTracker();
        while(true) {
            printmenu();
            int input = scanner.nextInt();
            if(input==1){
                one.changeResult();
            }else if(input==2){
                one.statistics();
            }else if(input==3){
                one.changePurpose();
            }else if(input==4){
                System.out.println("Программа завершена. Выход.");
                break;
            } else{
                System.out.println("Этого пункта нет в меню. Выберите снова.");
            }
        }
    }
    private static void printmenu(){
        System.out.println("Выберите нужное действие:");
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Напечатать статистику за определённый месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выход из приложения.");
    }
}
