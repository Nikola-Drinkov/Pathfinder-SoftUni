package spring.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.pathfinder.enums.RolesEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RolesEnum name;

    @ManyToMany(targetEntity = User.class, mappedBy = "roles")
    private Set<User> users;

    public Role(){
        this.users = new HashSet<>();
    }
}
