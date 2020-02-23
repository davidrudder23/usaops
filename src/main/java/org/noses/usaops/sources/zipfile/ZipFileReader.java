package org.noses.usaops.sources.zipfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

@Component
public class ZipFileReader {
    private ObjectMapper objectMapper;
    CloseableHttpClient client;

    public ZipFileReader() {
        objectMapper = new ObjectMapper();
        client = HttpClients.createDefault();
    }

    public List<CSVRecord> getCSVRecords(String url, String fileNameRegex) throws URISyntaxException, IOException {

        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();

        HttpResponse response = client.execute(httpGet);

        ZipInputStream zipInputStream = new ZipInputStream(response.getEntity().getContent());

        while (zipInputStream.available()>0) {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry == null) {
                continue;
            }

            if (entry.isDirectory()) {
                continue;
            }

            if (!(isCorrectFile(entry.getName(), fileNameRegex))) {
                continue;
            }

            CSVParser parser = new CSVParser(new InputStreamReader(zipInputStream), CSVFormat.DEFAULT);
            return parser.getRecords();
        }

        return null;
    }

    protected boolean isCorrectFile(String name, String fileNameRegex) {
        if (name.matches(fileNameRegex)) {
            return true;
        }

        return false;
    }
}
