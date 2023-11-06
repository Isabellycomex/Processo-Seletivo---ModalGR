import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Aniversariantes {
    public static void main(String[] args) {
        String arquivoEntrada = "consultores.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;

            Calendar calendar = Calendar.getInstance();
            int mesCorrente = calendar.get(Calendar.MONTH) + 1; 

            String arquivoSaida = "aniversariantes_" + mesCorrente + ".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida));

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");

                if (partes.length >= 3) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataNascimento = sdf.parse(partes[2].trim());

                    calendar.setTime(dataNascimento);
                    int mesNascimento = calendar.get(Calendar.MONTH) + 1;

                    if (mesNascimento == mesCorrente) {
                        writer.write("Nome: " + partes[0].trim() + " | E-mail: " + partes[1].trim() +
                                " | Data de Nascimento: " + partes[2].trim());
                        writer.newLine();
                    }
                } else {
                    System.out.println("Erro: linha invalida no arquivo consultores.txt: " + linha);
                }
            }

            writer.close();

            System.out.println("Arquivo '" + arquivoSaida + "' gerado com os aniversariantes do mes corrente.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
