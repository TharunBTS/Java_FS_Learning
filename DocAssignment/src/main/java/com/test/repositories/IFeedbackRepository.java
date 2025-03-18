package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Feedback;


@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer>{

}
