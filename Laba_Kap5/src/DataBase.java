import java.util.ArrayList;

public class DataBase {
    int cashSize = 1024;
    ArrayList<CompanyAddress> dataBase = new ArrayList<>(cashSize);
    int bitCount;
    final int c = 2;
    final int d = 1;
    

    DataBase(int databaseSize){
        this.cashSize = databaseSize;
        this.bitCount = (int) Math.ceil(Math.log(databaseSize)/Math.log(2));
        dataBase = new ArrayList<>(cashSize);
        clear();
    }
    public void resize(int newDatabaseSize){
        DataBase local = new DataBase(newDatabaseSize);
        for (int i = 0; i < cashSize; i++) {
            CompanyAddress companyAddress = dataBase.get(i);
            if (companyAddress != null) {
                local.add(companyAddress);
            }
        }
        this.dataBase = local.dataBase;
        cashSize = newDatabaseSize;
        bitCount = local.bitCount;
    }
    public void clear() {
        for (int i = 0; i < cashSize; i++) {
            dataBase.add(null);
        }
    }
    public Integer hash(CompanyAddress company){
        long value = (long) Math.pow(company.classToInt(), 2);
        String hex = Long.toBinaryString(value);
        return Integer.parseInt(
                hex.substring(
                        (hex.length() - bitCount) / 2,
                        ((hex.length() - bitCount) / 2) + bitCount
                ), 2);
    }
    public void add(CompanyAddress company) {
        CompanyAddress element = dataBase.get(hash(company));
        if (element == null) {
            dataBase.add(hash(company), company);
        } else {
            collision(element);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (CompanyAddress companyAddress : dataBase) {
            if (companyAddress != null) {
                builder.append("[");
                builder.append(companyAddress);
                builder.append("]\n");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    public int collision(CompanyAddress company){
        long i = (long) Math.pow(company.classToInt(), 2);
        return (int) (hash(company) + c * i + d * i^2);
    }
}