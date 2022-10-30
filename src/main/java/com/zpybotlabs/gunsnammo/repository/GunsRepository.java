package com.zpybotlabs.gunsnammo.repository;

import com.zpybotlabs.gunsnammo.model.Gun;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface GunsRepository extends JpaRepository<Gun, Long> {

//  @Query("SELECT g FROM Gun g WHERE g.email = 'mail@mail.com'")
  @Query("SELECT g FROM Gun g")
  Stream<Gun> findAllGunsWithEmail();

//  User findFirstByOrderByLastnameAsc();
//  User findTopByOrderByAgeDesc();
//  Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//  Slice<User> findTop3ByLastname(String lastname, Pageable pageable);
//  List<User> findFirst10ByLastname(String lastname, Sort sort);
//  List<User> findTop10ByLastname(String lastname, Pageable pageable);

  @Async
  CompletableFuture<Gun> findGunByName(String name);
}
