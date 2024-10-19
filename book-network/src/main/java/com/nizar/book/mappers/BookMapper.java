package com.nizar.book.mappers;

import com.nizar.book.dao.entities.Book;
import com.nizar.book.dao.entities.BookTransactionHistory;
import com.nizar.book.dtos.BookRequest;
import com.nizar.book.dtos.BookResponse;
import com.nizar.book.dtos.BorrowedBookResponse;
import com.nizar.book.file.FileUtils;
import org.springframework.stereotype.Service;

@Service

public class BookMapper {
    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .isbn(request.isbn())
                .isShareable(request.isShareable())
                .synopsis(request.synopsis())
                .isArchived(false)
                .build();

    }

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .isArchived(book.isArchived())
                .isShareable(book.isShareable())
                .owner(book.getOwner().fullName())
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }


    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory history) {
        return BorrowedBookResponse.builder()
                .id(history.getBook().getId())
                .title(history.getBook().getTitle())
                .authorName(history.getBook().getAuthorName())
                .isbn(history.getBook().getIsbn())
                .rate(history.getBook().getRate())
                .isReturned(history.isReturned())
                .isReturnApproved(history.isReturnApproved())
                .build();
    }
}
