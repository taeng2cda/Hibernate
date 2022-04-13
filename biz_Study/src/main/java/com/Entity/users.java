package com.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="users")
@Data
@NoArgsConstructor
@DynamicUpdate
public class users {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    public users(String email, String name, String password, Date created_at, Date updated_at) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
