package eps.werkzeuge;

//: net/mindview/util/Tuple.java
// Tuple library using type argument inference.
// aus dem Buch B. Eckel: Thinking in Java
// Uebersetzung und Auswahl: U. Heuer

/**
 * Ein Tupel
 * 
 * @version 02.2008
 */
public class Tupel {
    public static <A, B> ZweiTupel<A, B> tupel(A a, B b) {
        return new ZweiTupel<A, B>(a, b);
    }

    public static <A, B, C> DreiTupel<A, B, C> tupel(A a, B b, C c) {
        return new DreiTupel<A, B, C>(a, b, c);
    }
}
