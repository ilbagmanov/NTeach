package model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Theme {
    private Integer themeId;
    private String theme;
}
