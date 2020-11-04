public class Xml {

    public static final String oldXml =
            "<films>\n" +
                    "   <film>\n" +
                    "       <title>Фильм 1</title>\n" +
                    "       <description>Описание 1</description>\n" +
                    "       <actors>\n" +
                    "           <actor name=\"Актер 1\" age=\"30\" role=\"Роль 1\"/>\n" +
                    "           <actor name=\"Актер 2\" age=\"23\" role=\"Роль 2\"/>\n" +
                    "           <actor name=\"Актер 3\" age=\"40\" role=\"Роль 3\"/>\n" +
                    "       </actors>\n" +
                    "   </film>\n" +
                    "   <film>\n" +
                    "       <title>Фильм 2</title>\n" +
                    "       <description>Описание 2</description>\n" +
                    "       <actors>\n" +
                    "           <actor name=\"Актер 4\" age=\"70\" role=\"Роль 4\"/>\n" +
                    "           <actor name=\"Актер 2\" age=\"23\" role=\"Роль 5\"/>\n" +
                    "           <actor name=\"Актер 3\" age=\"40\" role=\"Роль 6\"/>\n" +
                    "       </actors>\n" +
                    "   </film>\n" +
                    "</films>";

    public static final String newXml =
            "<actors>\n" +
                    "   <actor>\n" +
                    "       <name>Актер 1</name>\n" +
                    "       <age>30</age>\n" +
                    "       <films>\n" +
                    "           <film title=\"Фильм 1\" role=\"Роль 1\"/>\n" +
                    "       </films>\n" +
                    "   </actor>\n" +
                    "   <actor>\n" +
                    "       <name>Актер 2</name>\n" +
                    "       <age>23</age>\n" +
                    "       <films>\n" +
                    "           <film title=\"Фильм 1\" role=\"Роль 2\"/>\n" +
                    "           <film title=\"Фильм 2\" role=\"Роль 5\"/>\n" +
                    "       </films>\n" +
                    "   </actor>\n" +
                    "   <actor>\n" +
                    "       <name>Актер 3</name>\n" +
                    "       <age>40</age>\n" +
                    "       <films>\n" +
                    "           <film title=\"Фильм 1\" role=\"Роль 3\"/>\n" +
                    "           <film title=\"Фильм 2\" role=\"Роль 6\"/>\n" +
                    "       </films>\n" +
                    "   </actor>\n" +
                    "   <actor>\n" +
                    "       <name>Актер 4</name>\n" +
                    "       <age>70</age>\n" +
                    "       <films>\n" +
                    "           <film title=\"Фильм 2\" role=\"Роль 4\"/>\n" +
                    "       </films>\n" +
                    "   </actor>\n" +
                    "</actors>";
}
