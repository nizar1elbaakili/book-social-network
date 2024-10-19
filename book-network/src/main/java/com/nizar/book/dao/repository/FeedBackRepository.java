package com.nizar.book.dao.repository;

import com.nizar.book.dao.entities.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeedBackRepository extends JpaRepository<FeedBack,Integer> {
    @Query("""
            SELECT feedBack
            FROM FeedBack  feedBack
            WHERE feedBack.book.id = :bookId
""")
    Page<FeedBack> findAllByBookId(@Param("bookId") Integer bookId, Pageable pageable);
}
