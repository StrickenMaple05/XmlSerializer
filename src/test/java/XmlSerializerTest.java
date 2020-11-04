import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class XmlSerializerTest {

    @Test
    public void test() {
        Serializer serializer = new Serializer();
        Assertions.assertEquals(Xml.newXml, serializer.reserialize(Xml.oldXml));
    }
}
