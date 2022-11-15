package com.comdata.automobile.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comdata.automobile.model.Automobile;

public interface AutomobileRepository extends PagingAndSortingRepository<Automobile, UUID> {

}
