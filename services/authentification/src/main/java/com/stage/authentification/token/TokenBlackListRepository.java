package com.stage.authentification.token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenBlackListRepository extends JpaRepository<TokenBlackList, Integer> {

}
