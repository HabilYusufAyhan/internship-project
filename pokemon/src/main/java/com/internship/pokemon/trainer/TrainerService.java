package com.internship.pokemon.trainer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TrainerService {
private final TrainerRepository trainerRepository;
public List<Trainer> findAll() {
    return trainerRepository.findAll();
}
public Trainer findTrainer(Integer id) {
    Optional<Trainer> trainer = trainerRepository.findById(id);
    if (!trainer.isPresent()){
        throw new RuntimeException("Trainer not found");
    }
    return trainer.get();
}
public Trainer addTrainer(TrainerAddRequest trainerAddRequest) {
    Trainer trainer = new Trainer();
    trainer.setFirstName(trainerAddRequest.firstName());
    trainer.setLastName(trainerAddRequest.lastName());
    trainer.setCoin(trainerAddRequest.coin());
    Trainer savedTrainer = trainerRepository.save(trainer); // Bu kod her veri tabanı işleminde önemlidir
    return savedTrainer;
}
public Trainer updateTrainer(Trainer trainer){
    Trainer savedTrainer = trainerRepository.save(trainer);
    return savedTrainer;
}



}
