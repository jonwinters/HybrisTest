package pw.jonwinters.hybris;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class BaseRepository {

    enum Product{
        A,B,C;
        public static Product getProduct(String productName){
            return valueOf(productName);
        }
    }
    private String name;
    private int productA;
    private int productB;
    private int productC;

    private int distance;
    private int priority;

    public BaseRepository(String name, int productA, int productB, int productC, int distance, int priority) {
        this.name = name;
        this.productA = productA;
        this.productB = productB;
        this.productC = productC;
        this.distance = distance;
        this.priority = priority;
    }

    public int getProductNumberByName(String name){

        switch (Product.getProduct(name)){
            case A : return this.getProductA();
            case B : return this.getProductB();
            case C : return this.getProductC();
            default: return -1 ;
        }
    }

    public void setProductNumberByName(String name,int number){
        switch(Product.getProduct(name)){
            case A : this.setProductA(number);break;
            case B : this.setProductB(number);break;
            case C : this.setProductC(number);break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductA() {
        return productA;
    }

    public void setProductA(int productA) {
        this.productA = productA;
    }

    public int getProductB() {
        return productB;
    }

    public void setProductB(int productB) {
        this.productB = productB;
    }

    public int getProductC() {
        return productC;
    }

    public void setProductC(int productC) {
        this.productC = productC;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "BaseRepository{" +
                "name='" + name + '\'' +
                ", productA=" + productA +
                ", productB=" + productB +
                ", productC=" + productC +
                ", distance=" + distance +
                ", priority=" + priority +
                '}';
    }
}
