package model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Article {
    private Integer articleId;
    private Integer userId;
    private Integer themeId;
    private String topic;
    private String text;
    private Timestamp date;
}
