package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CSVProfileImporter implements ProfileImporter{
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CSVProfileImporter(NaiveCsvReader reader, ProfileService service) {
        this.reader = Objects.requireNonNull(reader, "reader");
        this.service = Objects.requireNonNull(service, "service");
    }

    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile");
        List<String[]> rows = reader.read(csvFile);
        int imported = 0;
        for (String[] r : rows) {
            String id = r.length > 0 ? r[0].trim() : "";
            String email = r.length > 1 ? r[1].trim() : "";
            String displayName = r.length > 2 ? r[2].trim() : "";

            if (id.isEmpty() || email.isEmpty() || !email.contains("@")) {
                System.out.println("Skipping invalid row: id/email invalid");
                continue;
            }
            try {
                service.createProfile(id, email, displayName);
                imported++;
            } catch (RuntimeException e) {
                System.out.println("Skipping row due to error: " + e.getMessage());
            }
        }
        return imported;
    }
}
