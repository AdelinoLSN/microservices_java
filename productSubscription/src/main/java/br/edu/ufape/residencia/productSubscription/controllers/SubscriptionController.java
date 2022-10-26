package br.edu.ufape.residencia.productSubscription.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.residencia.productSubscription.models.Subscription;
import br.edu.ufape.residencia.productSubscription.repositories.SubscriptionRepository;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
		
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@GetMapping("")
	public List<Subscription> getSubscriptions() {
		return subscriptionRepository.findAll();
	}
	
	@PostMapping("")
	public Subscription postSubscription(@RequestBody Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}
	
	@GetMapping("/{subscriptionId}")
	public Subscription getSubscription(@PathVariable long subscriptionId) {
		return subscriptionRepository.findById(subscriptionId)
				.orElseThrow(() -> new RuntimeException());
	}
	
	@GetMapping("/product/{productId}")
	public List<Subscription> getProductSubscriptions(@PathVariable long productId) {
		return subscriptionRepository.findByProductId(productId);
	}
}
