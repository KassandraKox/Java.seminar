/* Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/
package Seminar;

import java.util.Objects;


public class task21 {
    public static void main(String[] args) {
        StringBuilder request = new StringBuilder("SELECT * FROM students WHERE ");
        String filtersString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String[] res = filtersString.replace("{\"", "")
                .replace("\":\"", " ")
                .replace("\", \"", " ")
                .replace("\"}", "").split(" ");
        for (int i = 0; i < res.length; i += 2) {
            if (i + 2 != res.length && i != 0) {
                request.append(" AND ");
            }
            if (!Objects.equals(res[i + 1], "null")) {
                request.append(res[i]).append(" = ").append("'").append(res[i + 1]).append("'");
            }
        }
        request.append(";");
        System.out.println(request);
    }
}