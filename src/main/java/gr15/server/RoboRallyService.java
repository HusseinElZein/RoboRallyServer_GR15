package gr15.server;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class RoboRallyService implements IRoboRallyService {
    ArrayList<Server> servers = new ArrayList<>();
    private int id = 0;

    @Override
    public Server findServerById(String serverId){
        for (Server server : servers) {
            if (Objects.equals(server.getGameId(), serverId)) {
                return server;
            }
        }
        return null;
    }

    @Override
    public void updateGame(String id, String gameState) {
        Server server = findServerById(id);
        server.setStateOfGame(gameState);
    }

    @Override
    public String getGameState(String serverId) {
        return (findServerById(serverId).getGameState());
    }

    @Override
    public String hostServer() {
        servers.add(new Server(id));
        String newServerId = String.valueOf(id);
        id++;
        return newServerId;
    }
}