import java.util.Scanner;
import java.util.HashMap;
        public class StepTracker {
    int purpose = 10000;
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    public StepTracker(){
        for(int i=0;i<12;i++){
            monthToData.put(i, new MonthData());
        }
    }
    void changePurpose(){
        int a = scanner.nextInt();
        if(a<=0){
            System.out.println("Цель по количеству шагов должна быть больше 0");
        }else{
            purpose = a;
            System.out.println("Теперь цель по количесту шагов составляет " + a + " шагов.");
        }
    }
    void statistics (){
        System.out.println("Введите номер месяца, за который хотите вывести статистику: 1) Январь 2)Февраль 3) Март" +
                " 4) Апрель 5) Май 6) Июнь 7) Июль 8) Август 9) Сентрябрь 10) Октябрь 11) Ноябрь 12) Декабрь");
        int month = scanner.nextInt();
        for(int i=0;i<30;i++){
            System.out.println("За "+(i+1)+" день. Шагов: " + monthToData.get(month).stepDay[i]);
        }
        int allStepMonth = 0;
        for(int j=0;j<30;j++){
            allStepMonth += monthToData.get(month).stepDay[j];
        }
        System.out.println("Общее количество шагов за месяц: "+allStepMonth);
        int maxStep = 0;
        int dayMaxStep = 0;
        for(int k=0;k<30;k++){
            if(maxStep<monthToData.get(month).stepDay[k]){
                maxStep = monthToData.get(month).stepDay[k];
                dayMaxStep = k;
            }
        }
        System.out.println("Максимальное количество шагов было в "+dayMaxStep+" день. Было: "+maxStep+" шагов.");
        System.out.println("Среднее количество шагов за месяц: "+allStepMonth/30);
        converter.stepConverter(allStepMonth);
        int maxSerDayNow = 0;
        int maxSerDayAll = 0;
        for(int p=0;p<30;p++){
            if(monthToData.get(month).stepDay[p]>=purpose){
                maxSerDayNow +=1;
            } else{
                maxSerDayNow = 0;
            }
            if(maxSerDayNow>maxSerDayAll){
                maxSerDayAll = maxSerDayNow;
            }
        }
        System.out.println("Лучшая серия, когда цель по шагам была выполнена или перевыполнена: "+maxSerDayAll+" дней.");
    }
    void changeResult(){
        System.out.println("Введите номер месяца, за который хотите вывести статистику: 1) Январь 2)Февраль 3) Март" +
                " 4) Апрель 5) Май 6) Июнь 7) Июль 8) Август 9) Сентрябрь 10) Октябрь 11) Ноябрь 12) Декабрь");
        int month = scanner.nextInt();
        System.out.println("Введите номер дня (от 1 до 30), за который хотите ввести количество пройденных шагов");
        int day = scanner.nextInt();
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        monthToData.get(month).stepDay[day-1] = step;
        System.out.println("Теперь количество шагов за "+day+" день "+month+"-ого месяца равняется"+" "+
                monthToData.get(month).stepDay[day-1]);
    }
    }
