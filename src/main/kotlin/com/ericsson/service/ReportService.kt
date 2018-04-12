package com.ericsson.service

import com.ericsson.model.Report
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.sql.DataSource
import java.sql.SQLException
import java.sql.ResultSet
import com.ericsson.utils.Utils

@Service("reportService")
class ReportService @Autowired constructor(private var datasource: DataSource, private var jdbcTemplate: JdbcTemplate){



    @PostConstruct
    fun postConstruct() {
        jdbcTemplate = JdbcTemplate(datasource)

    }

    fun loadAll(type: String): List<Report> {
        var sql = "";
        if(type.equals("opcional"))
            sql = Utils.opcional
        else if (type.equals("linea"))
            sql = Utils.linea
        else if (type.equals("ordenesPorDia"))
            sql = Utils.ordenesPorDia
        else if (type.equals("ordenesCompletadas"))
            sql = Utils.ordenesCompletadas
        else if (type.equals("ordenesStuckDia"))
            sql = Utils.ordenesStuckDia
        else if (type.equals("ordenesConError"))
            sql = Utils.ordenesConError

        return jdbcTemplate.query(sql) { resultSet, i -> toReport(resultSet) }
    }

    @Throws(SQLException::class)
    private fun toReport(resultSet: ResultSet): Report {
        val report = Report(resultSet.getString("fecha"), resultSet.getLong("valor"))
        return report
    }
}