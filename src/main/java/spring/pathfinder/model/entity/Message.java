package spring.pathfinder.model.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_time",nullable = false, columnDefinition = "DATETIME")
    private Instant dateTime;

    @Column(name = "text_content",columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipient_id",nullable = false)
    private User recipient;
}
