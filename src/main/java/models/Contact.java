package models;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor

public class Contact {
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;



}
