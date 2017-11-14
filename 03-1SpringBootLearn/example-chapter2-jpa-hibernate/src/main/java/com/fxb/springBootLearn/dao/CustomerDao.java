package com.fxb.springBootLearn.dao;

import com.fxb.springBootLearn.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 方小白 on 2017/9/13 21:05.
 * @description
 */


@Repository
public interface CustomerDao extends JpaRepository <Customer, String> {
}
