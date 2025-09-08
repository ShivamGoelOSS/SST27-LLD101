package com.example.imports;
public class CSVProfileImporter implements ProfileImporter{
    NaiveCsvReader LegacyReader=new NaiveCsvReader();
    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = LegacyReader.read(csvFile);

        return LegacyReader(csvFile);
    }
}
