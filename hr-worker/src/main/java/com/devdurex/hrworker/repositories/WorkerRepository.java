package com.devdurex.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devdurex.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
