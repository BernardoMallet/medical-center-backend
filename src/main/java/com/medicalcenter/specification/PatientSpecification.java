package com.medicalcenter.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.medicalcenter.dto.filter.PatientFilterDTO;
import com.medicalcenter.entity.Patient;
import com.medicalcenter.util.StringUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PatientSpecification extends BaseSpecification implements Specification<Patient> {

	private static final long serialVersionUID = 1L;

	private PatientFilterDTO filter;

	@Override
	public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtil.checkIfIsBlankOrEmptyOrNull(this.filter.getCpf())) {
			predicates.add(criteriaBuilder.equal(root.get("cpf"), this.filter.getCpf()));
		}

		if (!StringUtil.checkIfIsBlankOrEmptyOrNull(this.filter.getName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")),
					"%" + this.filter.getName().toUpperCase() + "%"));
		}

		if (!StringUtil.checkIfIsBlankOrEmptyOrNull(this.filter.getDoctorName())) {
			predicates.add(criteriaBuilder.equal(root.get("doctor").get("name"), this.filter.getName()));
		}

		if (predicates.size() == 0)
			return super.andTogether(predicates, criteriaBuilder);

		return super.orTogether(predicates, criteriaBuilder);
	}

}
