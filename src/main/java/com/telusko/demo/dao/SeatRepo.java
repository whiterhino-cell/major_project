package com.telusko.demo.dao;

import com.telusko.demo.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Desk,Integer>
{

}
