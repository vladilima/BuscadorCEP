import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Digite um CEP para busca: ");
        var CEP = input.nextLine();

        String busca = "https://viacep.com.br/ws/" + CEP + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder()
                .create();

        EnderecoRecord enderecoRecord = gson.fromJson(json, EnderecoRecord.class);

        Endereco endereco = new Endereco(enderecoRecord);
        System.out.println(endereco);

        FileWriter fileWriter = new FileWriter("endereco.json");
        fileWriter.write(json);
        fileWriter.close();

    }
}