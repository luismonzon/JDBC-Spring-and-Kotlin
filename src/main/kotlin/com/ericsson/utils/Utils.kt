package com.ericsson.utils

 class Utils {
       companion object {

           val linea: String = "select date(from_unixtime(clock)) as fecha, count(value) as valor\n" +
                   "  from history_uint a, items b\n" +
                   "  where \n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "  and a.itemid = b.itemid\n" +
                   "  and a.itemid in (28443)\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "  order by clock desc;"

           val opcional: String = "select date(from_unixtime(clock)) as fecha, count(value) as valor\n" +
                   "  from history_uint a, items b\n" +
                   "  where \n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "  and a.itemid = b.itemid\n" +
                   "  and a.itemid in (28446)\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "  order by clock desc;"

           val ordenesPorDia: String = "select date(from_unixtime(clock)) as fecha, max(value) valor\n" +
                   "\n" +
                   "  from history_uint a, items b\n" +
                   "\n" +
                   "  where\n" +
                   "\n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "\n" +
                   "  and a.itemid = b.itemid\n" +
                   "\n" +
                   "  and a.itemid in (24590)\n" +
                   "\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "\n" +
                   "  order by clock desc;"
           val ordenesCompletadas: String = "select date(from_unixtime(clock)) as fecha, max(value) as valor\n" +
                   "\n" +
                   "  from history_uint a, items b\n" +
                   "\n" +
                   "  where\n" +
                   "\n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "\n" +
                   "  and a.itemid = b.itemid\n" +
                   "\n" +
                   "  and a.itemid in (28577)\n" +
                   "\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "\n" +
                   "  order by clock desc;"

           val ordenesStuckDia: String = "select date(from_unixtime(clock)) as fecha, max(value) as valor\n" +
                   "\n" +
                   "  from history_uint a, items b\n" +
                   "\n" +
                   "  where\n" +
                   "\n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "\n" +
                   "  and a.itemid = b.itemid\n" +
                   "\n" +
                   "  and a.itemid in (28580)\n" +
                   "\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "\n" +
                   "  order by clock desc;"

           val ordenesConError: String = "select date(from_unixtime(clock)) as fecha, max(value) as valor\n" +
                   "\n" +
                   "  from history_uint a, items b\n" +
                   "\n" +
                   "  where\n" +
                   "\n" +
                   "  from_unixtime(clock)>='2018-01-01' and from_unixtime(clock)<'2018-01-31'\n" +
                   "\n" +
                   "  and a.itemid = b.itemid\n" +
                   "\n" +
                   "  and a.itemid in (24627)\n" +
                   "\n" +
                   "  group by date(from_unixtime(clock))\n" +
                   "\n" +
                   "  order by clock desc;"
       }
}