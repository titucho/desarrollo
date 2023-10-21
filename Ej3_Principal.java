import java.io.*;

public class Ej3_Principal {
    public static void main(String[] args) throws IOException {
        File directorio = new File( ".\\out\\production\\adivinaNumeros");
        ProcessBuilder pb = new ProcessBuilder("java", "adivinaNumeros.Ej3_Subproceso", "2", "5", "hola");

        pb.directory(directorio);
        Process p = pb.start();

        try{
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) !=null){
                System.out.println("ERROR >" + liner);

            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        //COMPROBACION DE la salida del programa
        int exitVal;
        try{
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
            switch (exitVal) {
                case(0):
                    System.out.println("FINAL CORRECTO...");
                    break;
                case(-1):
                    System.out.println("NO SE HAN ENVIADO PARAMETROS...");
                    break;
                case(1):
                    System.out.println("EXISTEN PARAMETROS NO NUMERICOS...");
                    break;
                case(2):
                    System.out.println("MAS DE LA MITAD DE LOS ARGUMENTOS ES SUPERIOR A LA MEDIA ARITMÉTICA");
                    break;
                case(3):
                    System.out.println("MENOS DE LA MITAD DE LOS ARGUMENTOS ES SUPERIOR A LA MEDIA ARITMETICA...");
                    break;
            }
            try{
                BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String liner;
                while ((liner = is.readLine()) != null) {
                    System.out.println(liner);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
