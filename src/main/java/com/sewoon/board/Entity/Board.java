package com.sewoon.board.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@Getter @Setter
@Entity
@Table(name = "board2")
public class Board implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @ColumnDefault(value = "0")
    @Column(nullable = false)
    private int hits;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private String delete_yn;

    @JsonIgnore
    @Column(nullable = true, length = 150)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date update_date;

    @PrePersist
    protected void onCreate() {
        create_date = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        update_date = Timestamp.valueOf(LocalDateTime.now());
    }


}
