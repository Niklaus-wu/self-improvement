package basics.innerClass;

/**
 * @description
 *      1、把内部类当作外部类的一个属性、行为
 * @author qinglin_wu
 * @date 2022/11/28 22:59
 */
public class Parcel1 {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    // using inner classes looks just like
    // using any other class,within Parcel1
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.printf("external class output: "+d.readLabel());
    }
    public static void main(String[] args){
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
