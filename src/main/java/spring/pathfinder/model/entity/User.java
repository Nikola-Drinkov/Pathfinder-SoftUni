package spring.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.pathfinder.enums.LevelsEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column
    private int age;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private LevelsEnum level;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Role> roles;

    @OneToMany(targetEntity = Route.class,mappedBy = "author")
    private Set<Route> routes;

    @OneToMany(targetEntity = Comment.class, mappedBy = "author")
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class, mappedBy = "author")
    private Set<Picture> pictures;

    public User(){
        this.roles = new HashSet<>();
        this.routes = new HashSet<>();
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
    }
}
