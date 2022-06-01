public class Converter {
    double stepKm = 0.00075;
    double stepKalorie = 0.05;
    void stepConverter(int allStep){
        double km = allStep * stepKm;
        double kalorie = allStep * stepKalorie;
        System.out.println("За это месяц вы прошли: "+km+"килломертво и сожгли "+kalorie+" килокалорий");
    }
}
