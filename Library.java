package ex.Project8;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books;
    private final ArrayList<Member> members;
    private final ArrayList<Loan> loans;
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public Member searchMember(int id) {
        for(Member m : members) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public Book searchBook(String query) {
        for(Book b : books) {
            if(b.getTitle().equalsIgnoreCase(query) || b.getAuthor().equalsIgnoreCase(query)) {
                return b;
            }
        }
        return null;
    }


    public void displayBooks() {
        int index = 0;
        for(Book b : books) {
            index++;
            System.out.printf("_____Livro(%d)_____%n", index);
            System.out.println("Titulo: " + b.getTitle());
            System.out.println("Autor: " + b.getAuthor());
            System.out.println("Copias disponiveis: " + b.getCopiesAvailable());
        }
    }

    public void registerLoan(int memberId, Book book) {
        Member member = null;
        for(Member m : members) {
            if(m.getId() == memberId) {
                member = m;
                break;
            }
        }
        Loan loan = new Loan(member, book);
        loans.add(loan);
        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        System.out.println("Empréstimo registrado");
    }

    public void devolution(int memberId, Book book) {
        Member member = null;
        for(Loan loan : loans) {
            if(loan.getMember().getId() == memberId && loan.getBook() == book
            && !loan.isReturned()) {
                loan.setReturned(true);
                book.setCopiesAvailable(book.getCopiesAvailable() + 1);
                System.out.println("Devolução Registrada!");
                return;
            }
        }
        System.out.println("Empréstimo não encontrado!");
    }

    public void displayBorrowedBooks() {

    }

    public void displayHistoricLoans() {
        for(Loan l : loans) {
            System.out.println("|-----------------------|");
            l.display();
        }
    }

    public void displayLateLoans() {
        for(Loan loan : loans) {
            if(loan.isLate()) {
                loan.display();
            }
        }
    }

    public void displayMembers() {
        int index = 0;
        for(Member m : members) {
            index++;
            System.out.printf("_____Membro (%d)____", index);
            System.out.println("Nome: " + m.getName());
            System.out.println("CPF: " + m.getCpf());
            System.out.println("Id: " + m.getId());

        }
    }

    public void registerMember(Member member) {
        members.add(member);
    }
    public void registerBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
