package basics.innerClass;

/**
 * @author qinglin_wu
 * @description
 *   当生成一个内部类的对象时，此对象与制造它的外围对象之间就有了一种联系，
 *      1：因此内部类对象能够访问其外围对象的所有成员，而不需要任何特殊条件。
 *      2：内部类还拥有其外围类的所有元素的访问权，包括外围私有元素
 * @date 2022/11/29 21:20
 * @name Sequence
 *  example：以一个顺序存储的数据结构为例，使用内部类实现顺序存储结构的【结束判断条件、遍历下一个元素、返回当前元素】
 *  衍生场景：可以使用内部类为外部类封装多个独立的功能，在实现其每个独立功能时，需要用到外部类的属性
 */
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if (next < items.length){
            items[next++] = x;
        }
    }

    /**
     * 使用内部类访问外围元素
     * 【迭代器模式的思维模式】
     */
    private class SequenceSelector implements Selector{
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args){
        Sequence sequence = new Sequence(10);
        for (int i=0;i<10;i++){
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.printf(selector.current()+" ---> ");
            selector.next();
        }
    }
}

interface Selector{
    boolean end();
    Object current();
    void next();
}