import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
import java.util.*;

/**
 * Clase principal,
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 21/09/2016
 * @version .0
 */

public class MainAnterior {
    public static void main(String[] args) throws IOException {
        Scanner ingreso = new Scanner(System.in);
        String source = "";
        ArrayList<String> diccionario;
        diccionario = new ArrayList<String>();
        BinaryTree<String, String> dic  = new BinaryTree<String, String>();
        String textoTraducido = "";

        System.out.println("Bienvenido!\nSeleccione el archivo .TXT que contiene el Diccionario\n(presiona ENTER para continuar)");
        ingreso.nextLine();
        /*
         codigo tomado de :
         http://stackoverflow.com/questions/7494478/jfilechooser-from-a-command-line-program-and-popping-up-underneath-all-windows
         */
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle("Seleccione su archivo");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                /*Lee el archivo y obtiene la cadena*/
                FileInputStream fstream = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    diccionario.add(strLine); //agregar cada linea al diccionario
                }

                /* Separar cadenas y hacer asociacion */
                for (int i = 0; i < diccionario.size(); i++) {
                    String temp = diccionario.get(i).substring(1, diccionario.get(i).length() - 1);
                    String[] partes = temp.split(", ");
                    dic.insert(partes[0],partes[1]);
                }
            } catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        }

        /*abrir el texto*/
        System.out.println("Seleccione el archivo .TXT que contiene el texto a traducir\n(presiona ENTER para continuar)");
        ingreso.nextLine();
        JFileChooser chooser2 = new JFileChooser(System.getProperty("java.class.path"));
        chooser2.setDialogTitle("Seleccione su archivo");
        chooser2.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal2 = chooser2.showOpenDialog(null);
        if(returnVal2 == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner inputFile2 = new Scanner(new File(chooser2.getSelectedFile().getAbsolutePath()));
                source = chooser2.getSelectedFile().getAbsolutePath();
            }
            catch (FileNotFoundException e) {
                System.out.println("No se sseleciono ningun archivo");

            }
        }


        try
        {
            BufferedReader datos = new BufferedReader(new FileReader(source));  // Abre documento para su lectura
            String rawText = datos.readLine();  // Lee la unica linea y la guarda como string
            /*en caso de punto al final*/
            rawText = rawText.substring(0, rawText.length()-1);
            String textoATraducir = rawText.toLowerCase();
            datos.close();  // Se finaliza el lector
            System.out.println("El texto Originas es: \n" + textoATraducir);
            String wIngles, wEspanol;
            StringTokenizer st = new StringTokenizer (textoATraducir);

            /* traduce el texto*/
            while (st.hasMoreTokens())
            {
                wIngles = st.nextToken();
                wEspanol = dic.find(wIngles);
                if (wEspanol != null){
                    textoTraducido = (textoTraducido +" "+ wEspanol);
                }
                else{
                    textoTraducido = (textoTraducido + " *"+wIngles+"*");
                }

            }
            /*Dando formato a salida*/
            System.out.println("El texto traducido es: \n");
            textoTraducido = textoTraducido + ".";
            System.out.println(textoTraducido);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Archivo no valido!!!");
        }
        System.out.println("\nSi la palabra se encuentra entre  asteriscos (**), no existe en el diccionario\n");
        System.out.println("Palabras dentro del diccionario utlizado (inOrder): \n");
        dic.display(dic.root);


    }
}