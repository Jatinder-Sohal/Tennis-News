package JS.Tennis_News;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class PlayerService {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS players (" +
                     "id SERIAL PRIMARY KEY, " +
                     "name VARCHAR(100), " +
                     "url VARCHAR(100))";

        jdbcTemplate.execute(sql);
    }
	
	 public void insertPlayer(String name, String url) {
	        String sql = "INSERT INTO players (name, url) VALUES (?, ?)";
	        jdbcTemplate.update(sql, name, url);
	 }
}
