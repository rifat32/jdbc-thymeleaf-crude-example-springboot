package com.example.jdbcexample.net.codejava;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public class SalesDao {
    private JdbcTemplate jdbcTemplate;

    public SalesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sale>  list(){
        String sql = "select * from sales";
       List<Sale> listSale = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
        return listSale;
    }
    public void save(Sale sale) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sales").usingColumns("item","quantit","amount");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
        insertActor.execute(param);
    }
    public Sale get(int id) {
        String sql = "SELECT * FROM sales WHERE id = ?";
        Object[] args = {id};
       Sale sale = jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Sale.class));

return sale;
    }
    public void update(Sale sale) {
        System.out.println(sale);
        String sql = "UPDATE sales SET item=:item, quantit=:quantit, amount=:amount WHERE id=:id" ;
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }
    public void delete(int id) {
        String sql = "DELETE  FROM sales WHERE id = ?";
        jdbcTemplate.update(sql,id);

    }
}
