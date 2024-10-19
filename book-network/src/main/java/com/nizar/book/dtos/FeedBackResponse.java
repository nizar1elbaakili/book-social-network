package com.nizar.book.dtos;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBackResponse {

    private Double note;

    private String comment;

    private boolean ownFeedback;
}
