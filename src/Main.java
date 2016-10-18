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

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner ingreso = new Scanner(System.in);
        String source = "";
        ArrayList<String> rawDiccionario;
        rawDiccionario = new ArrayList<String>();
        String textoTraducido = "";
        String tipoMapa = "";

        System.out.println("Bienvenido!\nIngrese el tipo de implementacion que desea utilizar: \n\t1) RedBlack\n\t2) TwoThree");
        tipoMapa = ingreso.nextLine();


        Map<String, Association<String, String>> diccionario = MapFactory.getMap(tipoMapa);

        System.out.println("Seleccione el archivo .TXT que contiene el Diccionario\n(presiona ENTER para continuar)");
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
                    rawDiccionario.add(strLine); //agregar cada linea al diccionario
                }

                /* Separar cadenas y hacer asociacion */
                for (int i = 0; i < rawDiccionario.size(); i++) {
                    /*esta seccion fue realizada con la ayuda de Gabriel Brolo y Jose Custodio*/
                    String temp = rawDiccionario.get(i);
                    temp = temp.replaceAll(",", "\t");
                    temp = temp.replaceAll(", ", "\t");
                    temp = temp.replaceAll("; ", "\t");
                    temp = temp.replaceAll(";", "\t");
                    /* Ignora los comentarios del archivo de texto */
                    if (temp.charAt(0) != '#') {
                        String[] part = temp.split("\t");
                        diccionario.put(part[0], new Association<String, String>(part[0], part[1]));
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        }

        /*ABRIR EL TEXTO A TRADUCIR*/
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
            String[] st = textoATraducir.split(" ");

            /* traduce el texto*/

            for (int i =0; i < st.length; i++){

                wIngles = st[i];
                if (diccionario.get(wIngles) != null){
                    textoTraducido = (textoTraducido +" "+ diccionario.get(wIngles).getValue());
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


    }
}