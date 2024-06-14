package spring.pathfinder.model.entity;

import jakarta.persistence.*;
import spring.pathfinder.enums.CategoryEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryEnum name;

    @ManyToMany(targetEntity = Route.class, mappedBy = "categories")
    private Set<Route> routes;

    public Category() {
        this.routes = new HashSet<>();
    }
}
