package dates;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class Examples {

    public static void main(String[] args) {

        // es una porquería
        Date ahora = new Date();


        LocalDateTime l =LocalDateTime.now();
        System.out.println(l);


        System.out.println(l.atZone(ZoneId.of("Europe/Madrid")));
        System.out.println(l.atZone(ZoneId.of("Europe/London")));

        //ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(l.atZone(ZoneId.of("America/Argentina/Buenos_Aires")));
        // sin time zone
        LocalDate sydney = LocalDate.now(ZoneId.of("Australia/Sydney"));
        System.out.println(sydney);
        // cone time zone
        ZonedDateTime esBa = l.atZone(ZoneId.of("America/Argentina/Buenos_Aires"));
        //time scaled
        Instant plus25= esBa.toInstant().plus(25, ChronoUnit.MINUTES);
        Period p = Period.between(sydney, LocalDate.now());
        System.out.print(p.getDays()+" ");
        System.out.print(p.getMonths()+" ");
        System.out.println(p.get(ChronoUnit.DAYS));
        System.out.println(p);

        l.plusDays(2);  //wither  builder

        //Curso.builder().nombre("Java").año(2020).build(); internamte setea variables de clase temporales para construirlo al final
        //new Curso().withNomre("Java").withAño(2020);  internamtne hace new

        System.out.println(plus25);


    }


}
