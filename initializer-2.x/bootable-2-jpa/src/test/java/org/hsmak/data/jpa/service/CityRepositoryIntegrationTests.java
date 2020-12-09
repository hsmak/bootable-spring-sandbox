/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hsmak.data.jpa.service;

import org.hsmak.data.jpa.AppRunner;
import org.hsmak.data.jpa.entity.City;
import org.hsmak.data.jpa.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;

/**
 * Integration tests for {@link CityRepository}.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class CityRepositoryIntegrationTests {

	@Autowired
	CityRepository repository;

	@Test
	public void findsFirstPageOfCities() {

		Page<City> cities = this.repository.findAll(PageRequest.of(0, 10));
		assertThat(cities.getTotalElements()).isGreaterThan(20L);
	}
}
