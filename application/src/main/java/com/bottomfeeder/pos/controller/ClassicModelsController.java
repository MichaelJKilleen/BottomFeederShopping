package com.bottomfeeder.pos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bottomfeeder.pos.service.MyService;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classicmodels")
public class ClassicModelsController {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(getClass());

    public ClassicModelsController() {
        LOGGER.debug("Boom!!!");

    }

}