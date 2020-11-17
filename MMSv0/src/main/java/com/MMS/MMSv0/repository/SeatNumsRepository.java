package com.MMS.MMSv0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MMS.MMSv0.annotations.SeatNumsId;
import com.MMS.MMSv0.model.SeatNums;

@Repository
public interface SeatNumsRepository extends JpaRepository<SeatNums, SeatNumsId>{

}
