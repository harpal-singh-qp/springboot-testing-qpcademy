package com.example.training.springboottesting.app;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * CreatedBy Harpal Singh at 12/9/21
 */
public class TestCsv {


    //inpt

    @Test
    void cteateCsv() throws IOException {
        File file = new File("book_new.csv");
        FileWriter out = new FileWriter(file);
        CSVPrinter printer = new CSVPrinter(out,
                CSVFormat.Builder.create()
                        .setHeader(SmsLogHeaderEnum.getHeaders())
                        .setTrim(true)
                        .build());
        printer.printRecords();

        List<SmsLog> log = new ArrayList();
        log.add(new SmsLog());
        List<String> lines = log.stream().map(this::getResultString).collect(Collectors.toList());

        lines.stream().forEach(line ->{
            String[] split = line.split(",");
            try {
                printer.printRecord(split);
                printer.flush();;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        printer.close();

    }

    private String getResultString(SmsLog smsLog) {
      return  new StringBuilder().append("1,").append("harpal.rtu@gmail.com,").append(Instant.now().toString()+",")
                .append("100.11,")
                .append("Harpla,")
                .append("visible,")
                .append(" CORE Survey").toString();
    }

}

class SmsLog{

}

 enum SmsLogHeaderEnum {
     NA("\\x23"),
     EMAIL_ADDRESS("Email Address"),
     TIMESTAMP("Timestamp"),
     PRICE("Price"),
     TO("To"),
     STATUS("Status"),
     TYPE("Type");

    private final String header;

    SmsLogHeaderEnum(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public static List<SmsLogHeaderEnum> getAll() {
        return Arrays.asList(values());
    }

    public static String[] getHeaders() {
        return getAll()
                .stream()
                .map(SmsLogHeaderEnum::getHeader)
                .toArray(String[]::new);
    }


}