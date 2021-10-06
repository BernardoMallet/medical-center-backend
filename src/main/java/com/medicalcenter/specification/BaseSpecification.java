package com.medicalcenter.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

public class BaseSpecification {

	public boolean isNotBlank(String str){
		if("".equalsIgnoreCase(str) || str == null){
			return false;
		}else{
			return true;
		}
	}
	
	public Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb){
		return cb.and(predicates.toArray(new Predicate[0]));
	}
	
	public Predicate orTogether(List<Predicate> predicates, CriteriaBuilder cb){
		return cb.or(predicates.toArray(new Predicate[0]));
	}
}
