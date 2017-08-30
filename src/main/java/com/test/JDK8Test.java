package com.test;
/**
 * Created by guoyong1 on 2017/8/11.
 */

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.Base64;

public class JDK8Test {

    @Test
    public void test() {
        //Clock
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        //2. 日期 eg. 2017-08-11
        LocalDate date = LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        //3. 时间 eg.11:25:36.940
        LocalTime time = LocalTime.now();
        LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);

        //4.特定时区的日期/时间，
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);

        //5.
        LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }

    @Test
    public void testBase(){
        String text = "1";
        String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
