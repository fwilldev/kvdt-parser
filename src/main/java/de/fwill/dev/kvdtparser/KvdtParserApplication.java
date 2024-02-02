package de.fwill.dev.kvdtparser;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public class KvdtParserApplication {

    public static void main(String[] args) {
        Arrays.stream(args).forEach(ConParser::parse);
    }
}
