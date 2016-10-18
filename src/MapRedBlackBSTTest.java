import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que prueba la clase de RedBlackTree implementado con la interfaz Map
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 16/10/2016
 * @version 1.0
 */
public class MapRedBlackBSTTest {
    @Test
    public void get() throws Exception {
        MapRedBlackBST<String, String> data = new MapRedBlackBST<String, String>();

        data.put("Insertar", "Insertado");

        assertEquals("Insertado", data.get("Insertar"));
    }

    @Test
    public void put() throws Exception {
        MapRedBlackBST<String, String> data = new MapRedBlackBST<String, String>();

        // Demostrar que no había nada antes
        assertNull(data.get("Nulo"));

        // Ingresar datos
        data.put("Prueba1", "Correcto1");
        data.put("Prueba2", "Correcto2");

        // Corroborar que se esten ingresados con put()
        assertEquals("Correcto1", data.get("Prueba1"));
        assertEquals("Correcto2", data.get("Prueba2"));

    }

}