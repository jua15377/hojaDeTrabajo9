/**
 * Arbol Binario de Busqueda
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 27/09/2016
 * @version 1.0
 */

/**
 * Arbol binario de busqueda. Esta clase utiliza nodos para formar un arbol balanceado para realizar busquedas.
 * Para programarlo, se utilizo una clase base obtenida del link adjunto abajo. Se modifico, de manera que los nodos
 * trabajen con asociaciones y para que trabajara con genericos.
 * @param <K> Es el tipo de objeto de la llave
 * @param <V> Es el tipo de objeto del valor guardado
 * @link http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 */

public class BinaryTree<K extends Comparable<K>, V> {
    public Node<K,V> root;

    public BinaryTree(){
        this.root = null;
    }

    /**
     * Este metodo busca si una llave se encuentra agregada en el arbol binario. Si si se encuentra, devuelve el valor
     * de la llave.
     * @param key Es el valor que se quiere encontrar
     * @return Devuelve el valor almacenado para esa llave
     */
    public V find(K key){
        Node<K,V> current = root;
        while(current != null){
            int comparation = current.data.compareTo(key);  // Comparar la palabra con la llave de la asociacion en el nodo
            if(comparation == 0){
                return current.data.getValue();
            }else if(comparation > 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return null;
    }

    /**
     * Este metodo se utiliza para agregar nuevos vertices al arbol. Al mismo tiempo, este metodo se asegura de que
     * el arbol quede ordenado.
     * @param key Es el valor de llave a guardar
     * @param value Es el valor que se desea guardar
     */
    public void insert(K key, V value){
        Node<K,V> newNode = new Node<K,V>(key, value);
        if(root==null){
            root = newNode;
            return;
        }

        Node<K,V> current = root;
        Node<K,V> parent = null;
        while(true){
            parent = current;
            int comparation = current.data.compareTo(key);
            if(comparation > 0){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    /**
     * Este metodo recorre el arbol binario en InOrder, desplegando de esa manera todas las asociaciones en orden
     * lexicografico.
     * @param root Es la raiz del arbol binario.
     */
    public void display(Node<K,V> root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data.toString());
            display(root.right);
        }
    }
}

/**
 * Esta clase es la que representa los vertices del arbol. A la vez almacena una referencia a nodos derecho e izquierdo
 * @param <K> Es la llave
 * @param <V> Es el valor
 */
class Node<K extends Comparable<K>,V>{
    Association<K, V> data;
    Node<K,V> left;
    Node<K,V> right;
    public Node(K key, V value){
        this.data = new Association<K, V>(key, value);
        left = null;
        right = null;
    }
}