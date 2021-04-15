package model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer articleId;
    private String comment;
    private Timestamp date;
}
