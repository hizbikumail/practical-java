package com.course.RestApi.practical.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.course.RestApi.practical.entity.Car;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String>{

}
