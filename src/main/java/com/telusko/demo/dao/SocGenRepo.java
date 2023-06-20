package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Socgen;

public interface SocGenRepo extends JpaRepository<Socgen,String>
{

}
