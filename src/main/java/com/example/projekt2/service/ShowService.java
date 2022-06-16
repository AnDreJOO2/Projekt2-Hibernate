package com.example.projekt2.service;

import com.example.projekt2.exception.SeansNotFoundException;
import com.example.projekt2.model.Seans;
import com.example.projekt2.repository.SeansRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    public static final int PAGE_SIZE = 5;

    private final SeansRepository seansRepository;

    public ShowService(SeansRepository seansRepository) {
        this.seansRepository = seansRepository;
    }

    private Seans findShowById(Long id){
        return seansRepository.findById(id).orElseThrow(() -> new SeansNotFoundException(id));
    }

    public Seans getShowById(Long id){
        return findShowById(id);
    }

    public List<Seans> getAllShows(int page){
        return seansRepository.findAllSeans(PageRequest.of(page,PAGE_SIZE));
    }

    public void deleteShowById(Long id) {
        Seans toDelete = findShowById(id);
        seansRepository.delete(toDelete);
    }
}
