package com.algaworks.ifood.infrastructure.repository;

import com.algaworks.ifood.domain.model.Restaurante;
import com.algaworks.ifood.domain.repository.RestauranteRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    /*
    Refactor -> extract interface -> escolher metodo -> dar à classe implementada
     */

    @PersistenceContext
    private EntityManager manager;

//    @Override
//    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
//
//        var jpql = "from Restaurante where nome like :nome "
//                + "and taxaFrete between :taxaInicial and :taxaFinal";
//
//        return manager.createQuery(jpql, Restaurante.class)
//                .setParameter("nome", "%" + nome + "%")
//                .setParameter("taxaInicial", taxaFreteInicial)
//                .setParameter("taxaFinal", taxaFreteFinal)
//                .getResultList();
//    }

    //T11 - O problema é que as atribuições dos parâmetros são fixas, assim se não
    // for feito qualquer filtro, não irá compilar


//    -------------------------------------------------------------------------------------------------------



//    @Override
//    public List<Restaurante> find(String nome,
//                                  BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
//
//        StringBuilder jpql = new StringBuilder();
//        jpql.append("from Restaurante where 0 = 0 ");
//
//        HashMap<String, Object> parametros = new HashMap<String, Object>();
//
//        if (StringUtils.hasLength(nome)) {
//            jpql.append("and nome like :nome ");
//            parametros.put("nome", "%" + nome + "%");
//        }
//
//        if (taxaFreteInicial != null) {
//            jpql.append("and taxaFrete >= :taxaInicial ");
//            parametros.put("taxaInicial", taxaFreteInicial);
//        }
//
//        if (taxaFreteFinal != null) {
//            jpql.append("and taxaFrete <= :taxaFinal ");
//            parametros.put("taxaFinal", taxaFreteFinal);
//        }
//
//        TypedQuery<Restaurante> query = manager
//                .createQuery(jpql.toString(), Restaurante.class);
//
//        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
//
//        return query.getResultList();
//    }

    // T12 - as atribuições dos parâmetros são dinâmicas, o que possibilita usar filtro ou não



//    -------------------------------------------------------------------------------------------------------



    @Override
    public List<Restaurante> find(String nome,
                                  BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery criteria = builder.createQuery(Restaurante.class);
        Root root = criteria.from(Restaurante.class);

        ArrayList<Predicate> predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (taxaFreteInicial != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }

        if (taxaFreteFinal != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery query = manager.createQuery(criteria);
        return query.getResultList();
    }

    // T13 - criteria é uma api do Jpa para criação de queries de forma programática.
}


