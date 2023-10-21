public class Ej3_Subproceso {
    public static void main(String[] args) {
        // Si no se le ha enviado ningún argumento, el proceso deberá devolver -1
        if (args.length < 1) {
            System.exit(-1);
        }
        try{
            int i = args.length-1;
            int media = 0;
            while (i > 0) {
                media +=Integer.parseInt(args[i]);
                i++;
            }
            media /= args.length;

            i = args.length-1;
            int cont = 0;
            while (i > 0) {
                if (Integer.parseInt(args[i]) > media) {
                    cont++;
                }
                i--;
            }
            if (cont > (args.length/2)) {
                System.exit(2);
            } else {
                System.exit(3);
            }
        }catch (NumberFormatException nf) {
            int i = 0;
            String cadena = "";
            while (i < args.length) {
                cadena += "Argumento" + i + ": " + (String) args[i] + "\n";
                i++;
            }
            System.out.println(cadena);
            System.exit(1);
        }
        System.exit(0);
    }
}
