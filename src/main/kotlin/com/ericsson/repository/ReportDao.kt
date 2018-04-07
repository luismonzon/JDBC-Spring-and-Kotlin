package com.ericsson.repository

import com.ericsson.model.Report
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.sql.DataSource
import java.sql.SQLException
import java.sql.ResultSet


@Service("reportDao")
class ReportDao @Autowired constructor(private var datasource: DataSource, private var jdbcTemplate: JdbcTemplate){

    private  val linea: String = "select date(from_unixtime(clock)) as fecha, count(value) as value\n" +
            "  from history_uint a, items b\n" +
            "  where \n" +
            "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
            "  and a.itemid = b.itemid\n" +
            "  and a.itemid in (28443)\n" +
            "  group by date(from_unixtime(clock))\n" +
            "  order by clock desc;"

    private val opcional: String = "select date(from_unixtime(clock)) as fecha, count(value) as value\n" +
            "  from history_uint a, items b\n" +
            "  where \n" +
            "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
            "  and a.itemid = b.itemid\n" +
            "  and a.itemid in (28446)\n" +
            "  group by date(from_unixtime(clock))\n" +
            "  order by clock desc;"

    @PostConstruct
    fun postConstruct() {
        jdbcTemplate = JdbcTemplate(datasource)

    }

    fun loadAll(type: String): List<Report> {
        var sql = "";
        if(type.equals("opcional"))
            sql = this.opcional;
        else if (type.equals("linea"))
            sql = this.linea;
        return jdbcTemplate.query(sql) { resultSet, i -> toReport(resultSet) }
    }

    @Throws(SQLException::class)
    private fun toReport(resultSet: ResultSet): Report {
        val report = Report(resultSet.getString("fecha"), resultSet.getLong("value"))
        return report
    }
}