package ex.Project8;


import java.util.Scanner;

/*
Programa nos estágios iniciais. (6/9) Cases completos. Devidos Consertos
necessários indicados abaixo no programa!
Pograma completo! (9/9) Cases completos! Sem nenhum erro!
*/

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        Library lib = new Library();
        int id = 0;
        while(true) {
            // User Menu
            System.out.println("1- Registrar Membro");
            System.out.println("2- Registar Livro");
            System.out.println("3- Fazer Empréstimo");
            System.out.println("4- Fazer devolução");
            System.out.println("5- Mostrar Livros");
            System.out.println("6- Mostrar Membros");
            System.out.println("7- Empréstimos atrasados");
            System.out.println("8- Histórico de Empréstimos");
            System.out.println("9- Emprestimos feito por membro");
            System.out.println("|------Digite 0 para sair!------|");
            System.out.print("Informe: ");
            int optionUser = scan.nextInt();
            scan.nextLine();
            switch (optionUser) {
                case 1:
                    // Simple Member register with to easy search(fix soon)
                    id++;
                    System.out.println("|---Registo de membro----|");
                    System.out.print("Nome: ");
                    String name = scan.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scan.nextLine();
                    lib.registerMember(new Member(cpf, name, id));
                    break;
                case 2:
                    // Simple Book register
                    System.out.println("|-----Registro Livro-----|");
                    System.out.print("Titulo: ");
                    String title = scan.nextLine();
                    System.out.print("Autor: ");
                    String author = scan.nextLine();
                    System.out.println("Numero de copias que deseja adicionar: ");
                    int initialCopies = scan.nextInt();
                    lib.registerBook(new Book(author, initialCopies, title));
                    scan.nextLine();
                    break;
                case 3:
                    // Loan originator system with verifications for more security.

                    if(lib.getMembers().isEmpty()) {
                        System.out.println("Não há membros ainda, cadastre primeiro!");
                        break;
                    }
                    // Fixed with id for search.
                    // Added 2 verification if exists or not members and books registered
                    if(lib.getBooks().isEmpty()) {
                        System.out.println("Não há livros cadastrados, cadastre primerio!");
                        break;
                    }
                    System.out.println("|----Digite o id do membro que fara o empréstimo----|");
                    System.out.print("Id: ");
                    int idForLoan = scan.nextInt();
                    // Verification if user exists or not
                    Member memberRegisterLoan = lib.searchMember(idForLoan);
                    if (memberRegisterLoan == null) {
                        System.out.println("Membro não encontrado, tente novamente!");
                        break;
                    }
                    System.out.println("____Membro encontrado!____");
                    memberRegisterLoan.display();
                    System.out.println("|--------------------------|");
                    scan.nextLine();
                    System.out.print("Confirme(sim/não): ");
                    String confirmMemberForLoan = scan.nextLine();
                    if(confirmMemberForLoan.equalsIgnoreCase("nao") || confirmMemberForLoan.equalsIgnoreCase("não")) {
                        System.out.println("Procure novamente!");
                        break;
                    }
                    System.out.println("|----------------------------|");
                    System.out.println("Qual livro ira fazer o empréstimo?");
                    System.out.print("Informe(Titulo ou Autor): ");
                    String titleOrAuthorForLoan = scan.nextLine();
                    Book book = lib.searchBook(titleOrAuthorForLoan);
                    if(book == null) {
                        System.out.println("Livro não encontrado, tente novamente!");
                        break;
                    }
                    System.out.println("____Livro encontrado!____");
                    book.display();
                    System.out.println("|------------------------|");
                    System.out.print("Confirme(sim/não): ");
                    String confirmationBook = scan.nextLine();
                    if(confirmationBook.equalsIgnoreCase("nao") || confirmationBook.equalsIgnoreCase("não")) {
                        System.out.print("Procure novamente!");
                        break;
                    }
                    lib.registerLoan(idForLoan, book);
                    break;
                case 4:
                    // Devolution system
                    if (lib.getMembers().isEmpty()) {
                        System.out.println("Não há membros cadastrados, cadastre primeiro!");
                        break;
                    }
                    if(lib.getBooks().isEmpty()) {
                        System.out.println("Não há livros cadastrados, cadastre primerio!");
                        break;
                    }
                    System.out.println("|----Digie o id do membro que fara a Devolução-----|");
                    System.out.print("Id: ");
                    // Same user verification
                    // Fixed verification with usind id than name
                    int idForDevolution = scan.nextInt();
                    Member memberDevolutionBook = lib.searchMember(idForDevolution);
                    if (memberDevolutionBook == null) {
                        System.out.println("Membro não encontrado, tente novamente!");
                        break;
                    }
                    System.out.println("_____Membro encontrado!_____");
                    memberDevolutionBook.display();
                    System.out.println("|---------------------------|");
                    scan.nextLine();
                    System.out.print("Confirme(sim/não): ");
                    String confirmMemberForDevolution = scan.nextLine();
                    if(confirmMemberForDevolution.equalsIgnoreCase("nao") || confirmMemberForDevolution.equalsIgnoreCase("não")) {
                        System.out.println("Procure novamente!");
                        break;
                    }
                    System.out.println("|----------------------|");
                    System.out.println("Qual livro deseja fazer devolução?");
                    System.out.print("Informe(titulo/autor): ");
                    String bookForDevolution = scan.nextLine();
                    Book bookDevolution = lib.searchBook(bookForDevolution);
                    if (bookDevolution == null) {
                        System.out.println("Livro não encontrado, tente novamente!");
                        break;
                    }
                    System.out.println("|---------Livro encontrado!----------|");
                    bookDevolution.display();
                    System.out.println("|-------------------------|");
                    System.out.println("Confirme(sim/não): ");
                    String confirmBookForDevolution = scan.nextLine();
                    if(confirmBookForDevolution.equalsIgnoreCase("nao") || confirmBookForDevolution.equalsIgnoreCase("não")) {
                        System.out.println("Procure novamente!");
                        break;
                    }
                    System.out.println("|-----------------------|");
                    lib.devolution(idForDevolution, bookDevolution);
                    break;
                case 5:
                    if(lib.getBooks().isEmpty()) {
                        System.out.println("Não há livros cadastrados ainda, cadastre primeiro!");
                        break;
                    }
                    lib.displayBooks();
                    break;
                case 6:
                    if(lib.getMembers().isEmpty()) {
                        System.out.println("Não há membros cadastrados ainda, cadastre primeiro!");
                        break;
                    }
                    System.out.println("|________Membros_______|");
                    lib.displayMembers();
                    break;
                case 7:
                    if(lib.getLoans().isEmpty()) {
                        System.out.println("Não há empréstimos feitos, faça primeiro!");
                        break;
                    }
                    for(int i = 0; i < lib.getLoans().size(); i++) {
                        if(!lib.getLoans().get(i).isLate()) {
                            System.out.println("Não há empréstimos atrasados ainda!");
                            break;
                        }
                    }
                    System.out.println("|-----------------------|");
                    lib.displayLateLoans();
                    break;
                case 8:
                    if(lib.getLoans().isEmpty()) {
                        System.out.println("Não há empréstimos realizados, faça um primeiro!");
                        break;
                    }
                    System.out.println("|--------Empréstimos---------|");
                    lib.displayHistoricLoans();
                    break;
                case 9:
                    if(lib.getLoans().isEmpty()) {
                        System.out.println("Não há empréstimos feitos ainda, faça primeiro!");
                        break;
                    }
                    System.out.println("|______Digite o Id do membro que deseja ver os empréstimos!______|");
                    System.out.print("Informe Id: ");
                    int idForSeeLoans = scan.nextInt();
                    Member memberSeeLoan = lib.searchMember(idForSeeLoans);
                    if(memberSeeLoan == null) {
                        System.out.println("Membro não encontrado!");
                        break;
                    }
                    System.out.print("|________Membro Encontrado!______|");
                    memberSeeLoan.display();
                    System.out.println("|-----------------------|");
                    scan.nextLine();
                    System.out.print("Confirme(sim/não): ");
                    String confrimMemberSeeLoan = scan.nextLine();
                    if(confrimMemberSeeLoan.equalsIgnoreCase("nao") || confrimMemberSeeLoan.equalsIgnoreCase("não")) {
                        System.out.println("Procure novamente!");
                        System.out.println("|-----------------------|");
                        break;
                    }
                    boolean found = false;
                    for(Loan loan : lib.getLoans()) {
                        if(loan.getMember().getId() == idForSeeLoans) {
                            loan.display();
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Membro não possui empréstimos!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo!");
                    return;
            }
        }
    }
}
