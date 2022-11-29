package basics.innerClass;

/**
 * @author qinglin_wu
 * @description 内部类的对象只能在与其外围类的对象相关联的情况下才能被创建
 *                  ：构建内部类对象时，需要一个指向其外围类对象的引用（若编译器访问不到这个引用会报错）
 *  1、在外部类中提供内部类的可供访问的方法行为
 *  2、以【外部类.内部类】定义变量
 *  3、以外部类提供的访问初始化了的内部类的方法给变量赋值
 * @date 2022/11/29 20:35
 * @name Parcel2
 */
public class Parcel2 {
    // inner class : Contents
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    // inner class: Destination
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public Destination to(String s){
        return new Destination(s);
    }
    public Contents contents(){
        return new Contents();
    }
    public void ship(String dest){
        Contents c = contents();
        Destination d = to(dest);
        System.out.printf("output : "+d.readLabel());
    }

    public static void main(String[] args){
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");

        Parcel2 q = new Parcel2();
        // defining references to inner classes
        Contents c = q.contents();
        Destination d = q.to("Borneo");
    }
}
