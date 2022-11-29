package basics.innerClass;

/**
 * @author qinglin_wu
 * @description TODO
 * @date 2022/11/29 21:15
 * @name Outer
 */
public class Outer {

    class Inner{

    }

    Inner obtainInner(){
        return new Inner();
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        Inner inner = outer.obtainInner();
    }
}
