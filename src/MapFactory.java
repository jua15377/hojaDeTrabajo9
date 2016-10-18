/**
 * Esta clase devuelve un Map en cualquiera de sus dos variedades
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 16/10/2016
 * @version 1.0
 */
public class MapFactory {
    /**
     * Metodo que devuelve un stack tipo map segun lo indicado por el usuario
     * @param map Es el tipo de map que se desea
     * @return Devuelve un map
     */
    static <K extends Comparable<K>,V> Map<K,V> getMap(String map) {
        if (map.equalsIgnoreCase("RedBlack")) {
            return new MapRedBlackBST<K,V>();
        } else if (map.equalsIgnoreCase("TwoThree")){
            return new MapTwoThreeTree<K, V>();
        }
        return null;
    }
}
