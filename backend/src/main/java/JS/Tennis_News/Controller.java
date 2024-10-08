package JS.Tennis_News;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
    private PlayerService playerService;
	
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
    
    public void createTable(){
    	playerService.createTable();
    	try {
			Document doc = Jsoup.connect("https://www.espn.com/tennis/rankings").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36").get();
			for(int i = 26; i<= 175; i++) {
				playerService.insertPlayer(doc.getElementsByClass("AnchorLink").get(i).text(),doc.getElementsByClass("AnchorLink").get(i).attr("href"));
			}
		} catch (IOException e) {
			e.printStackTrace(); 
		}
    }

    @PostMapping("/search")
    public String search(@RequestBody SearchRequest searchRequest) {
    	createTable();
    	String test = null;
        return test;
    }

}