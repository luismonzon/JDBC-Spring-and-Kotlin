package com.ericsson.service

import com.ericsson.model.Respuesta
import com.ericsson.repository.ReportDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.xml.ws.Response
@Service("reportService")
class ReportService{

    fun getReport(type: Long): ResponseEntity<Respuesta>{
        return ResponseEntity.ok(Respuesta("OK","00",""))
    }
}