package com.example.steamprocessing.controller;

import com.example.steamprocessing.service.KsqlDbService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ksql")
public class KsqlDbController {

    private final KsqlDbService ksqlDbService;

    public KsqlDbController(KsqlDbService ksqlDbService) {
        this.ksqlDbService = ksqlDbService;
    }

    @GetMapping("/query")
    public String query(@RequestParam String sql) {
        return ksqlDbService.executeQuery(sql);
    }
}
