package com.ericsson.controller

import com.ericsson.service.ReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestServiceController @Autowired constructor(private val reportService: ReportService){

    @GetMapping("/report/{type}")
    fun getReport(@PathVariable(value="type")  type:String ) = reportService.loadAll(type);
}