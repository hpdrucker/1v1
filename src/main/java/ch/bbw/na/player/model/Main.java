package ch.bbw.na.player.model;

import ch.bbw.na.player.repository.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main extends Color{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println(ANSI_GREEN+"Starting "+ANSI_RED+"5v5 Proelium "+ANSI_PURPLE+"- The Game"+ANSI_RESET);
        PlayerRepository repository = new PlayerRepository();
        repository.setup();

        System.out.println("All Entities: ");
        for(Entity e: repository.getAllPlayers()) {
            System.out.println(e);
        }
        System.out.println();

        Entity kale = repository.readPlayer(2);
        Entity garen = repository.readPlayer(1);

        boolean p1Turn = true;

        while (true) {
            if (p1Turn) {
                if (garen.getBlock() < Math.random()) {
                    garen.setHp(garen.getHp() - kale.getAa());
                    System.out.println("gaen HP: " + garen.getHp());
                    if (garen.getHp() <= 0) {
                        System.out.println("kale wins");
                        break;
                    }
                } else {
                    System.out.println("garen blocked");
                }
                p1Turn = false;
            } else {
                if (kale.getBlock() < Math.random()) {
                    kale.setHp(kale.getHp() - garen.getAa());
                    System.out.println("kale HP: " + kale.getHp());
                    if (kale.getHp() <= 0) {
                        System.out.println("gaen wins");
                        break;
                    }
                } else {
                    System.out.println("kale blocked");
                }
                p1Turn = true;
            }
        }

        repository.closeup();
    }
}
