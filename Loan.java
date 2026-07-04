package ex.Project8;

import java.time.LocalDate;

public class Loan {
    private Member member;
    private Book book;
    private final int LOAN_TERM = 7;
    private LocalDate loanDate;
    private boolean returned;
    // Complete this class
    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.loanDate = LocalDate.now();
        this.returned = false;
    }

    public void display() {
        System.out.println("Nome do membro: " + this.member.getName());
        System.out.println("CPF: " + this.member.getCpf());
        System.out.println("Livro: " + this.book.getTitle());
        System.out.println("Data do empréstimo: " + loanDate);
        System.out.println("Prazo maximo: " + getLOAN_TERM() + "dias");
        System.out.println("Devolvido: " + (returned ? "sim" : "não") );
    }
    public boolean isLate() {
        if(returned) return false;
        LocalDate dueDate = loanDate.plusDays(getLOAN_TERM());
        return LocalDate.now().isAfter(dueDate);
    }

    public boolean isReturned() {
       return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getLOAN_TERM() {
        return LOAN_TERM;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
