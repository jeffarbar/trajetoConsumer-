package br.com.send.consumer.mq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.send.consumer.mq.model.TrajetoModel;

@Repository
public interface TrajetoRepository extends MongoRepository<TrajetoModel, String> {

}
