package com.zam.reto.services;

import com.zam.reto.entities.SoccerPlayerEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SoccerPlayerService {

    public SoccerPlayerEntity getSoccerPlayer(Integer soccerPlayerId);
    public Page<SoccerPlayerEntity> listSoccerPlayers(int page, int size);

}
