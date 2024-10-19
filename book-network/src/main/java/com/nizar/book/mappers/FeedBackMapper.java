package com.nizar.book.mappers;

import com.nizar.book.dao.entities.Book;
import com.nizar.book.dao.entities.FeedBack;
import com.nizar.book.dtos.FeedBackRequest;
import com.nizar.book.dtos.FeedBackResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedBackMapper {
    public FeedBack toFeedBack(FeedBackRequest request) {
        return FeedBack.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .isShareable(false) // Not required and has no impact :: just to satisfy lombok
                        .isArchived(false) // Not required and has no impact :: just to satisfy lombok
                        .build()
                )
                .build();
    }

    public FeedBackResponse toFeedBackResponse(FeedBack feedback, Integer id) {
        return FeedBackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
