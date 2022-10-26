class Library{
    String[] books;
    int no_of_books = 0;

    Library(){
        this.books = new String[100];
        this.no_of_books = 0;
    }
    void addBook(String book){
        this.books[no_of_books] = book;
        no_of_books++;
        System.out.println(book+" Has been added!!");
    }

    void showAvailableBooks(){
        
        System.out.println(" Available Books are:");
        for(String book : this.books){
            if(book == null){
                continue;
            }
            System.out.println("-->"+book);
        }
    }

    void issueBook(String book){
        for(int i=0;i<this.books.length;i++){
            if(this.books[i]==book){
                System.out.println("Book has been issued");
                this.books[i]= null;
                return;
            }
        }
        System.out.println("Sorry! Book not found");
    }

    void returnBook(String book){
        addBook(book);
    }
}


public class library_system {
    public static void main(String[] args) {
        Library cb = new Library();
        cb.addBook("Harry Potter");
        cb.addBook("Lord Of the rings");
        cb.addBook("Let us c++");
        cb.addBook("Java the complete reference");
        cb.addBook("Psychology of money");
        cb.showAvailableBooks();
        cb.issueBook("Harry Potter");
        cb.showAvailableBooks();
    }
}
