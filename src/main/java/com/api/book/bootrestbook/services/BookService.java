package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    
    // private static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(1, "First Book", "Author One"));
    //     list.add(new Book(2, "Second Book", "Author Two"));
    //     list.add(new Book(3, "Third Book", "Author Three"));
    // }
    
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id){
        Book book=null;
        try{
            // book=list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
        // list.add(b);
        Book result=this.bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid){
        // list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        this.bookRepository.deleteById(bid);
    }

    public void updateBook(Book book,int bookId){
        // list=list.stream().map(b->{
        //     if(b.getId()==bookId){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        this.bookRepository.save(book);
    }

}
