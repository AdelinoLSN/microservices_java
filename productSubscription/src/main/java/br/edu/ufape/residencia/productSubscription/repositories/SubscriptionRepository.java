package br.edu.ufape.residencia.productSubscription.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.residencia.productSubscription.models.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	public List<Subscription> findByProductId(long productId);
}
