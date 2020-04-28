package com.sapient.productcatalogue;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCatalogueApplication {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(ProductCatalogueApplication.class, args);
//		System.out.println("hello");
		AtomicInteger i = new AtomicInteger(0);
		ExecutorService thExecutorService = Executors.newFixedThreadPool(34);
//		new Thread(()->{
//			System.out.println("hello");
//			
//		}).run();
		int j =0;
		while(j<=10) {
			thExecutorService.submit(()->{
				System.out.println(i.incrementAndGet());
			});
			j++;
		}
		
		thExecutorService.shutdown();
		
		List<Integer> list =  new LinkedList<Integer>(Arrays.asList(1,2,3,4));
		
		List<Integer> dlist = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
		
	}

}
