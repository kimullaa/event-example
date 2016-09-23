package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ver4.2以前の書き方
 */
@Component
@Slf4j
public class BeforeSpring42Listener implements ApplicationListener<SlotStartEvent> {

    @Override
    public void onApplicationEvent(SlotStartEvent event) {
        log.info("before ver4.2 listen : " + event.getRotation());
    }
}
