package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FitleringController {
	// Static Filtering
//	@GetMapping("/filtering")
//	public SomeBean retrieveSomeBean() {
//		return new SomeBean("value1", "value2", "value3");
//	}

	// Dynamic Filtering
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filterProvider);
		return mapping;
	}

	// Static
//	@GetMapping("/filtering-list")
//	public List<SomeBean> retrieveSomeBeans() {
//		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));
//	}

	// Dynamic
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveSomeBeansDynamic() {
		List<SomeBean> beans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value11", "value22", "value33"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(beans);
		mapping.setFilters(filterProvider);

		return mapping;
	}
}
