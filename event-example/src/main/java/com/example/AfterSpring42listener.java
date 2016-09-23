package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * ver4.2以降の書き方(@EventListener)
 * ver4.3以降の書き方(@EventListener(condition= ...))
 */
@Component
@Slf4j
public class AfterSpring42listener {

    @EventListener
    @Async
    public void processExecuteStartEvent(SlotStartEvent event) {
        log.info("after ver4.2 listen : " + event.getRotation());
    }

    /**
     * 戻り値にApplicationEventを指定すると、
     * 連鎖してイベントを発生させることができる
     */
    @EventListener(condition = "#event.rotation.id == 2")
    @Async
    public FeverEvent conditionOn2(SlotStartEvent event) {
        log.info("fever event start");
        return new FeverEvent(event, event.getRotation());
    }

    @EventListener
    @Async
    public void processContextClosedEvent(ContextClosedEvent event) {
        log.info("good bye");
    }

    @EventListener
    @Async
    public void processFeverEvent(FeverEvent event) {
        log.info("fever! " + event.getRotation());
    }
}
