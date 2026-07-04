package ex.Project8;

public class Member {
    private String name;
    private String cpf;
    private int id;
    Book book;
    Loan loan;
    public Member(String cpf, String name, int id) {
        this.cpf = cpf;
        this.name = name;
        this.id = id;
    }

    public void display() {
        System.out.println("Nome: " + getName());
        System.out.println("CPF: " + getCpf());
        System.out.println("Id: " + getId());
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
