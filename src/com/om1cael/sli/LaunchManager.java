package com.om1cael.sli;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.om1cael.sli.models.Launch;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LaunchManager {
    private final URI apiEndpoint = URI.create("https://ll.thespacedevs.com/2.3.0/launches/upcoming/?format=json&mode=list&limit=5");

    public CompletableFuture<List<Launch>> mapJSONToLaunches() {
        return this.fetchAPI().thenApply(this::getLaunchList);
    }

    private List<Launch> getLaunchList(String response) {
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).
                create();

        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        Type launchListType = new TypeToken<List<Launch>>(){}.getType();
        return gson.fromJson(jsonArray, launchListType);
    }

    private CompletableFuture<String> fetchAPI() {
        final int CONNECTION_TIMEOUT = 10;

        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(apiEndpoint)
                    .timeout(Duration.ofSeconds(CONNECTION_TIMEOUT))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
            return futureResponse.thenApply(HttpResponse::body);
        } catch (Exception e) {
            System.out.println("Could not create a HTTP client. Exiting the program...");
            throw new RuntimeException(e.getMessage());
        }
    }
}
