package spring.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.pathfinder.enums.LevelsEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
@Setter
@Getter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LevelsEnum level;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(targetEntity = Comment.class, mappedBy = "route")
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class, mappedBy = "route")
    private Set<Picture> pictures;

    @ManyToMany()
    @JoinTable(
            name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_entity_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false)
    )
    private Set<Category> categories;

    public Route() {
        this.comments = new HashSet<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }

}
