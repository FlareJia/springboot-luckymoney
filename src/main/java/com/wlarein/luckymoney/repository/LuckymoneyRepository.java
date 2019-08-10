package com.wlarein.luckymoney.repository;

import com.wlarein.luckymoney.domain.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney, Integer> {

}
