package JS.Tennis_News;

import java.io.Console;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static class SearchRequest {
        private String player;

        public String getPlayer() {
            return player;
        }

        public void setPlayer(String player) {
            this.player = player;
        }
    }

    @PostMapping("/search")
    public String search(@RequestBody SearchRequest searchRequest) {
        return "You searched for: " + searchRequest.getPlayer();
    }

}