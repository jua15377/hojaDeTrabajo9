import static org.junit.Assert.*;

/**
 * Created by Eric on 27/09/2016.
 */
public class BinaryTreeTest {
    /**
     * Esta prueba asegura que se puede encontrar un dato que ha sido recien ingresado.
     * Cabe destacar que el metodo find devuelve el valor de una llave si lo encuentra.
     * @throws Exception
     */
    @org.junit.Test
    public void find() throws Exception {
        BinaryTree<String, String> dic = new BinaryTree<String, String>();
        String pruebaK = "PruebaK";
        String pruebaV = "PruebaV";

        dic.insert(pruebaK, pruebaV);  // Insertar dato

        assertEquals(dic.find(pruebaK), pruebaV);  // Comprobar que se puede encontrar
    }

    /**
     * Esta prueba asegura que se inserta correctamente un dato al arbol binario.
     * Además, asegura que se encuentre ordenado.
     * @throws Exception
     */
    @org.junit.Test
    public void insert() throws Exception {
        BinaryTree<String, String> dic = new BinaryTree<String, String>();

        dic.insert("Llave", "Valor");
        assertEquals(dic.find("Llave"), dic.root.data.getValue());  // Buscar directamente el valor de la raiz

        dic.insert("Momia", "Mommy");
        String s1, s2;
        s1 = dic.root.data.getKey();
        s2 = dic.root.right.data.getKey();

        boolean resultado = (s1.compareTo(s2) < 0);
        assertEquals(true, resultado);


    }

}