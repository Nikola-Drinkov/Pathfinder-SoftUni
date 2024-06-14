package spring.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pictures")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(optional = false)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

}
