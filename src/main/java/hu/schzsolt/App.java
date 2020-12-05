package hu.schzsolt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Run -> Configuration -> Environment Variables
 *  - DB_HOST localhost /127.0.0.1
 *  - DB_PORT 3306
 *  - DB_NAME australian_football
 *  - DB_USER salata
 *  - DB_PASS secret
 */
@Slf4j
@SpringBootApplication
public class App {

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

}
