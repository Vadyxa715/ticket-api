package com.example.testparttwo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/trails", produces = "application/json; charset=utf-8")//ручная установка родировки для swagger3
public class TrailController {
}
