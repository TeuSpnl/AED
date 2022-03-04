public class ListaDupla<T> {
    private Element<T> head;

    public class Elemen<T> {

        T data;

        Element<T> next, prev;

        Element (T d, Element<T> n, Element<T> p){
            data = d;
            next = n;
            prev = p;
        }

    }
}
