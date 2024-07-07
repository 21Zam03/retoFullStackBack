package com.zam.reto.services.impl;

import com.zam.reto.entities.SoccerPlayerEntity;
import com.zam.reto.exceptions.BadRequestException;
import com.zam.reto.exceptions.NotFoundException;
import com.zam.reto.repositories.SoccerPlayerRepository;
import com.zam.reto.services.SoccerPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SoccerPlayerServiceImpl implements SoccerPlayerService {

    @Autowired
    private SoccerPlayerRepository soccerPlayerRepository;

    @Override
    public SoccerPlayerEntity getSoccerPlayer(Integer soccerPlayerId) {
        if(soccerPlayerId != null) {
            SoccerPlayerEntity soccerPlayerEntity = soccerPlayerRepository.findById(soccerPlayerId)
                    .orElseThrow(()-> {
                        log.warn("Soccer player was not found");
                        return new NotFoundException("Soccer player was not found");
                    });
            log.info("Soccer player was obtained with id: {}", soccerPlayerEntity.getSoccerPlayerId());
            return soccerPlayerEntity;
        } else {
            log.warn("Soccer player id is null");
            throw new BadRequestException("Soccer player id is null");
        }
    }

    @Override
    public Page<SoccerPlayerEntity> listSoccerPlayers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SoccerPlayerEntity> soccerPlayerEntityList = soccerPlayerRepository.findAll(pageable);
        if (soccerPlayerEntityList.isEmpty()) {
            log.warn("Soccer player list is empty");
            throw new NotFoundException("Soccer list is empty");
        }
        log.info("Soccer player list was obtained! - {} soccer players in total", soccerPlayerEntityList.getContent().size());
        return soccerPlayerEntityList;
    }

}
