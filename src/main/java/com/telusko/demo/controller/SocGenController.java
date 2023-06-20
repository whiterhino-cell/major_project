package com.telusko.demo.controller;

import com.telusko.demo.dao.SeatRepo;
import com.telusko.demo.model.Desk;
import com.telusko.demo.model.Socgen;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.telusko.demo.dao.SocGenRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.simple.*;

@Controller
public class SocGenController {
	@Autowired
	SocGenRepo repo;

	@Autowired
	SeatRepo seatRepo;

	@RequestMapping("/")
	public String home() {

		return "intro.jsp";
	}

	/**Get ShareHolder*/
	@GetMapping("/emp/{id}")
	@ResponseBody
	public Optional<Socgen> getShareHolder(@PathVariable("id")String id) {

		return repo.findById(id);




	}

	/**Add ShareHolder*/
	@PostMapping(path="/emp")
	@ResponseBody
	public String addShareHolder  (Socgen socgen) {
		System.out.println("Post : "+ socgen.getId());
		if (socgen.getId().equals(null)) {
			System.out.println("Id is neither be null nor empty.");
			return "Id is neither be zero nor empty.";
		}else {
			int l=socgen.getId().length();
			String idLast=socgen.getId().substring(l-3,l);
			socgen.setDate("08/05/2023-"+idLast);
			repo.save(socgen);
			return socgen.toString()+"\nis added";
		}
	}

	/**Update ShareHolder*/
	@PutMapping("/emp")
	@ResponseBody
	public String updateShareHolder(Socgen socgen) {
		System.out.println("Put : "+ socgen.getId());
		if (socgen.getId().equals(null)) {
			System.out.println("Id is neither be null nor empty.");
			return "Id is neither be zero nor empty.";
		}else {
			int l=socgen.getId().length();
			String idLast=socgen.getId().substring(l-3,l);
			socgen.setDate("08/05/2023-"+idLast);

			String out=repo.findById(socgen.getId())+"\n\nis Updated to\n"+ socgen.toString();
			repo.save(socgen);
			return out;
		}
	}


	/**Delete ShareHolder*/
	@DeleteMapping("/emp/{id}")
	@ResponseBody
	public String deleteShareHolder(@PathVariable("id") String id) {

		if (repo.findById(id).toString()=="Optional.empty"){
			System.out.println("The uid : "+id+" does not exists..");
			return "The uid : "+id+" does not exists..";
		}

		Socgen a = repo.getOne(id);
		repo.delete(a);

		String msg="{\nId    : "+a.getId()+"\nEmail : "+a.getMail()+
				"\nName  : "+a.getName()+ "\n}\n\nis deleted";
		return msg;
	}


	/**Get all ShareHolder*/
	@RequestMapping("/emps")
	@ResponseBody                   //informing that it is not view
	public String getShareHolders() {

//		return repo.findAll();
		return repo.findAll().toString();
	}


	/**Vote ShareHolder*/
	@GetMapping(path="/see_avail_seat")
	@ResponseBody
	public List<Integer>  voteShareHolder() {

		List<Desk> desks=desks = seatRepo.findAll();
		List<Integer> avail=new ArrayList<>();
		for (Desk desk :desks) {
			if (desk.getDate()==null||!desk.getDate().substring(0,10).equals("08/05/2023")){
				avail.add(desk.getSeat());
			}
		}
		return avail;
	}

	/**Vote ShareHolder*/
	@GetMapping(path="/book_seat/{uid}/{seat}")
	@ResponseBody
	public String  bookSeat(@PathVariable("uid") String uid,@PathVariable("seat") int seat) {
		System.out.println(uid+" : "+seat);

		System.out.println(seatRepo.findById(seat));
		if (repo.findById(uid).toString().equals("Optional.empty")){
			return "This employee id is invalid.";
		}
		if (seatRepo.findById(seat).toString().equals("Optional.empty")){
			return "This seat does not exist.";
		}


		Socgen socgen =repo.getOne(uid);
		Desk desk = seatRepo.getOne(seat);
		System.out.println(socgen);
		System.out.println(desk);

		if (desk.getDate()==null||!desk.getDate().substring(0,10).equals("08/05/2023")){
			socgen.setSeat(seat);
			desk.setDate(socgen.getDate());

			seatRepo.save(desk);
			repo.save(socgen);

			System.out.println(socgen);
			System.out.println(desk);
		}else {
			return "The seat is already booked.";
		}


		return "Congratulation "+socgen.getName()+" you have booked seat no : "+seat
				+"\nThank you for booking.\nHappy working.";
	}
}


