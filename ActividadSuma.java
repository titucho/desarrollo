import java.io.*;

public class ActividadSuma {
    public static void main(String[] args) throws IOException {

        File directorio = new File(".\\out\\production\\adivinaNumeros");
        ProcessBuilder pb = new ProcessBuilder("java", "Actividades.Sumar");
        pb.directory(directorio);

        //se ejecuta el proceso
        Process p = pb.start();

        // escritura -- envia entrada
        OutputStream os = p.getOutputStream();

        os.write("10\n".getBytes());
        os.write("15\n".getBytes());
        os.flush();

        //lectura -- obtiene la salida
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1)
            System.out.print((char) c);
        is.close();

        //COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) !=null)
                System.out.println("ERROR >" + liner);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
