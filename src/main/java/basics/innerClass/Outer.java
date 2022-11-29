package basics.innerClass;

/**
 * @author qinglin_wu
 * @description TODO
 * @date 2022/11/29 21:15
 * @name Outer
 */
public class Outer {
    private String describe;
    public Outer(String describe){
        this.describe = describe;
    }
    public Outer(){

    }

    public void setDescribe(String describe){
        this.describe = describe;
    }

    class Inner{

        public String toString(){
            return describe;
        }

        public String obtainOutputDescribe(){
            return describe;
        }
    }

    Inner obtainInner(){
        return new Inner();
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        Inner inner = outer.obtainInner();

        Outer outer1 = new Outer("hello,nice to meet you");
        Sequence sequence = new Sequence(14);
        sequence.add(outer1.obtainInner().obtainOutputDescribe());
        sequence.add("厄瓜多尔 VS 塞内加尔");
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.printf(selector.current()+" ---> ");
            selector.next();
        }
    }
}
