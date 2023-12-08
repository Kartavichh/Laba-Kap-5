public class Main {
    public static void main(String[] args) {

        DataBase x = new DataBase(32);

        for (int i = 0; i < 64; i++) {
            CompanyAddress a = new CompanyAddress();
            a.country = "Russia";
            a.city = "Moscow";
            a.street = "Arbat";
            a.house = i;
            x.add(a);
        }
        System.out.println(x);
        x.resize(16);
        System.out.println(' ');
        System.out.println(x);
    }
}