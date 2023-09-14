package com.example.testparttwo.repo;

import com.example.testparttwo.entity.Trail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrailRepo {
    Trail findById(Long id);
    int save(Trail trail);
}
