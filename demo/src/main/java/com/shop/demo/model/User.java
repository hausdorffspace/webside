package com.shop.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "password")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String surname;

    private String login;

    private String password;

    @Transient
    private String passwordConfirm;

    //TODO this is a prototype
    /*@Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private Byte[] photo;*/

    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_Role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id")
    )
    private Set<Role> roles;


}
