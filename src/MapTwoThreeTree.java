/**
 * Clase principal,
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 16/10/2016
 * @version 1.0
 */
public class MapTwoThreeTree<K extends Comparable<K>, V> implements Map<K, V> {
    private TwoThreeTree<K,V> data;

    public MapTwoThreeTree() {
        data = new TwoThreeTree<K, V>();
    }

    /**
     * @post returns the number of entries in the map
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * @post returns true iff this map does not contain any entries
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * @param k
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    @Override
    public V get(K k) {
        return data.get(k);
    }

    /**
     * @param k
     * @param v
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    @Override
    public V put(K k, V v) {
        data.put(k,v);
        return null;
    }

}
