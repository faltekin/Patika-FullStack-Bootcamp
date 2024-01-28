import java.util.*;
public class Book implements Comparable<Book>{

    private String name;
    private int pageNumber;
    private String authorName;
    private String publishDate;

    public Book(java.lang.String name, int pageNumber, java.lang.String authorName, java.lang.String publishDate) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public java.lang.String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(java.lang.String authorName) {
        this.authorName = authorName;
    }

    public java.lang.String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(java.lang.String publishDate) {
        this.publishDate = publishDate;
    }

    @java.lang.Override
    public int compareTo(Book book) {

        if (this.pageNumber > book.pageNumber) {
            return 1;
        } else if (this.pageNumber == book.pageNumber) {
            return 0;
        } else {
            return -1;
        }
    }
}
