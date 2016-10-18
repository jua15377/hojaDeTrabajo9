import java.util.Set;

/**
 * Associations establish a link between a key and a value.  
 * An associative array or map is a structure that allows a disjoint
 * set of keys to become associated with an arbitrary set of values.  
 * The convenience of an associative array is that the values used to 
 * index the elements need not be comparable and their range need not 
 * be known ahead of time.  Furthermore, there is no upper bound on 
 * the size of the structure.  It is able to maintain an arbitrary number 
 * of different pieces of information simultaneously.  Maps are sometimes 
 * called dictionaries because of the uniqueness of the association of
 * words and definitions in a household dictionary.  
 * <P>
 * Example Usage:
 * <P>
 * To create a dictionary by reading a collection of words and 
 * definitions from System.in we could use the following!
 * <P> 
 * <pre>
 * public static void main (String[] argv){
 *      ReadStream r = new ReadStream();
 *      String word, def;
 *      System.out.println("Enter a word: ");
 *      while(!r.eof()){
 *          word = r.readLine();
 *          System.out.println("Enter a definition: ");
 *          def = r.readLine();
 *          System.out.println("Enter a word: ");
 *      }
 *      System.out.println(dict);
 * }
 * </pre>
 */
public interface Map<K,V>
{
    /**
     * @post returns the number of entries in the map
     */
    public int size();

    /**
     * @post returns true iff this map does not contain any entries
     */
    public boolean isEmpty();

    /**
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public V get(K k);

    /**
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public V put(K k, V v);


    /**
     * @pre other is non-null
     * @post returns true iff maps this and other are entry-wise equal
     */
    public boolean equals(Object other);
    
    /**
     * @post returns a hash code associated with this structure
     */
    public int hashCode();
}
