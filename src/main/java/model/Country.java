package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {
    private Integer countryId;
    private String country;
}
