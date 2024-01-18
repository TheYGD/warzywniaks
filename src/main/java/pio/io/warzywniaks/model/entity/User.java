package pio.io.warzywniaks.model.entity;


import jakarta.persistence.*;
import lombok.*;
import pio.io.warzywniaks.model.constant.Role;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Role role;
}
