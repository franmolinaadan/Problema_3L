import java.io.*;
import java.util.Scanner;

public class Problema {

    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("/home/usuario/IdeaProjects/Problema/mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));


            String linea = null;
            String clave=null;
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduce la clave de cifrado");
            clave=sc.nextLine();
            clave=clave.toUpperCase();
            linea=br.readLine();
            linea=linea.toUpperCase();
            char [] salida=new char[linea.length()];

            /* Lectura y validación  de clave */



            for (int i=0;i<linea.length();i++) {
                if (clave.length()<linea.length()){
                    int resto;
                    resto=linea.length()-clave.length();
                    for (int ii=0;ii<resto;ii++){
                        clave=clave+clave.charAt(ii);
                    }
                }
                int aux = linea.charAt(i)-64;
                int auxC = clave.charAt(i)-64;
                aux=auxC+aux+63;


                salida [i]= (char) aux;

            }
            System.out.println(salida);
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}


