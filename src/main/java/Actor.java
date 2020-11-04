import java.util.LinkedHashMap;
import java.util.Map;

public class Actor {
    private final String name;
    private final int age;
    private final Map<Film, String> films;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
        films = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Map<Film, String> getFilms() {
        return films;
    }

    public void add(Film film, String role) {
        films.put(film, role);
    }

    public String toString(Film film) {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", role=" + films.get(film) +
                '}';
    }
}
