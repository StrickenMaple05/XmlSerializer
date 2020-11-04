import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Serializer {

    private Set<Actor> actors;

    public Serializer() {
        actors = new LinkedHashSet<>();
    }

    /**
     * deserializes xml to actors set
     * @param xml xml
     */
    public void deserialize(String xml) {

        actors = new LinkedHashSet<>();

        Pattern filmPattern = Pattern.compile("<film>(.+?)</film>");
        Pattern actorPattern = Pattern.compile("<actor name=\"(.+?)\" age=\"(.+?)\" role=\"(.+?)\"/>");
        List<Pattern> fieldsPatterns = new ArrayList<>();

        for (Field field : Film.class.getDeclaredFields()) {
            String name = field.getName();
            fieldsPatterns.add(Pattern.compile(
                    String.format("<(%s)>(.+?)</%s>", name, name)
            ));
        }
        String modifiedXml = xml.replaceAll("\n( )+","");
        Matcher filmMatcher = filmPattern.matcher(modifiedXml);
        while (filmMatcher.find()) {

            Film film = new Film();

            for (Pattern fieldPattern : fieldsPatterns) {
                Matcher fieldMatcher = fieldPattern.matcher(
                        filmMatcher.group(1));
                if (!fieldMatcher.find()) {
                    continue;
                }
                String fieldName = fieldMatcher.group(1);
                String fieldValue = fieldMatcher.group(2);

                switch (fieldName) {
                    case "title" -> film.setTitle(fieldValue);
                    case "description" -> film.setDescription(fieldValue);
                    case "actors" -> {
                        Matcher actorMatcher = actorPattern.matcher(fieldValue);
                        while (actorMatcher.find()) {
                            String name = actorMatcher.group(1);
                            int age = Integer.parseInt(actorMatcher.group(2));
                            String role = actorMatcher.group(3);

                            boolean created = false;
                            for (Actor actor : actors) {
                                if (actor.getName().equals(name) &&
                                        actor.getAge() == age) {
                                    actor.add(film, role);
                                    film.add(actor, role);
                                    created = true;
                                    break;
                                }
                            }
                            if (!created) {
                                Actor actor = new Actor(name, age);
                                actors.add(actor);
                                film.add(actor, role);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * serializes actors set into xml
     * @return xml
     */
    public String serialize() {
        StringBuilder xml = new StringBuilder();
        xml.append("<actors>\n");
        for (Actor actor : actors) {
            xml.append(String.format(
                    "   <actor>\n" +
                    "       <name>%s</name>\n"+
                    "       <age>%d</age>\n" +
                    "       <films>\n",
                    actor.getName(),
                    actor.getAge())
            );
            for (Map.Entry<Film, String> film : actor.getFilms().entrySet()) {
                xml.append(String.format(
                        "           <film title=\"%s\" role=\"%s\"/>\n",
                        film.getKey().getTitle(),
                        film.getValue()));
            }
            xml.append(
                    "       </films>\n" +
                    "   </actor>\n" );
        }
        xml.append("</actors>");
        return xml.toString();
    }

    /**
     * deserializes xml to actors set and serializes it to another xml
     * @param xml xml
     * @return new xml
     */
    public String reserialize(String xml) {
        deserialize(xml);
        return serialize();
    }
}
