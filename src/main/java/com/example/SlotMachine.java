package com.example;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
@Data
@Slf4j
public class SlotMachine {
    private final ApplicationEventPublisher publisher;

    public void execute() {
        LongStream.rangeClosed(1, 3).forEach(i -> {
            log.info(">>>-------------------------");
            this.publisher.publishEvent(new SlotStartEvent(this, new Rotation(i)));
            log.info("<<<-------------------------");
        });
    }
}
