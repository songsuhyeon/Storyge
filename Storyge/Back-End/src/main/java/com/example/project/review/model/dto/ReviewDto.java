package com.example.project.review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    Long ReviewId;
    Long userId;
    Long diaryId;
    String reviewContent;
    LocalDateTime createdAt;

}
