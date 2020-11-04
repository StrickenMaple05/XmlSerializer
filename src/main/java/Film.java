import java.util.HashMap;
import java.util.Map;

/**
 * film
 */
public class Film {

    /**
     * title
     */
    private String title;

    /**
     * description
     */
    private String description;

    /**
     * actors
     */
    private final Map<String, Actor> actors;

    public Film() {
        actors = new HashMap<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    /**
     * adds an actor and his role in this film
     * @param actor actor
     * @param role role
     */
    public void add(Actor actor, String role) {
        actor.add(this, role);
        actors.put(role, actor);
    }

    @Override
    public String toString() {
        String actorsInfo = "";
        for (String role : actors.keySet()) {
            actorsInfo = actorsInfo.concat(actors.get(role).toString(this));
        }
        return "Film{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + actorsInfo +
                '}';
    }
}
