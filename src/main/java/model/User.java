package model;


import lombok.*;

@Builder
@Data
public class User {
    private Integer userId;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private Integer countryId;
}
