package ex.Project8;

public class Book {
    private String title;
    private String author;
    private int copiesAvailable;

    public Book(String author, int copiesAvailable, String title) {
        this.author = author;
        this.copiesAvailable = copiesAvailable;
        this.title = title;
    }

    public void display(){
        System.out.println("Titulo: " + getTitle());
        System.out.println("Autor: " + getAuthor());
        System.out.println("Cópias disponiveis: " + getCopiesAvailable());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
