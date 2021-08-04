package com.course2go.model.board;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.course2go.model.comment.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Integer bid;
    private String boardWriterUid;
    private String boardTitle;
    private Integer boardLike;
    private Integer boardStar;
    private Integer boardTid;
    private boolean	boardType;
    private LocalDateTime boardTime;
}