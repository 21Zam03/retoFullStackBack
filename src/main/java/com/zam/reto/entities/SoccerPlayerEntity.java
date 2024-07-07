package com.zam.reto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity(name = "SoccerPlayer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoccerPlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soccer_player_id")
    private Integer soccerPlayerId;

    @Column(name = "soccer_player_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    private Date birthdate;

    private String features;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

}
