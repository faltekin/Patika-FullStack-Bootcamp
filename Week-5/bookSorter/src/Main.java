import java.util.*;
public class Main {
    public static void main(String[] args) {

        Set<Book> bk = new TreeSet<>();

        bk.add(new Book("1984",256,"Fuat","2002"));
        bk.add(new Book("Körlük",124,"Ege","2010"));
        bk.add(new Book("Cesur Yeni Dünya",568,"Ecem","2004"));
        bk.add(new Book("Dune",636,"Selin","2006"));
        bk.add(new Book("Uzayda Piknik",125,"Caner","2009"));

        Set<Book> newTreeSet = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()- o2.getPageNumber();
            }
        });
        newTreeSet.addAll(bk);
        for (Book book : newTreeSet) {
            System.out.println(book.getName() + ", " + book.getPageNumber());
        }




    }
}