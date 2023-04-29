package com.ssafy.enjoytrip.member.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.member.controller.MemberController;
import com.ssafy.enjoytrip.member.dto.MemberDto;
import com.ssafy.enjoytrip.member.model.mapper.MemberMapper;
import com.ssafy.enjoytrip.response.MemberResponseDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	private final MemberResponseDto responseDto;

	@Override
	public ResponseEntity<MemberResponseDto> login(MemberDto member, HttpSession session) throws Exception {
		MemberDto m = mapper.selectMember(member);
		log.info("Service : login = {}", m);
		if (m != null) {
			session.setAttribute("memberInfo", m);
			return ResponseEntity.status(HttpStatus.OK).body(responseDto.successLogin(m));
		} else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto.failLogin());
	}

	@Override
	public ResponseEntity<MemberResponseDto> logout(HttpSession session) throws Exception {
		log.info("Service : logout = {}", (MemberDto) session.getAttribute("memberInfo"));
		session.invalidate();
		return ResponseEntity.status(HttpStatus.OK).body(responseDto.successLogout());
	}

	@Override
	public ResponseEntity<MemberResponseDto> signup(MemberDto member) {
		log.info("Service : signup = {}", member);
		try {
			mapper.insertMember(member);
			return ResponseEntity.status(HttpStatus.OK).body(responseDto.successSignup());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto.failSignup());
		}
	}

	@Override
	public ResponseEntity<MemberResponseDto> check(String check) throws Exception {
		log.info("Service check Email or Nickname = {}", check);
		MemberDto isExist = mapper.selectMemberByCheck(check);
		log.info("Service check Email or Nickname = {}", isExist);
		if (isExist != null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto.unavailable(check));
		} else
			return ResponseEntity.status(HttpStatus.OK).body(responseDto.available(check));
	}

	@Override
	public ResponseEntity<MemberResponseDto> secession(MemberDto member) {
		log.info("Service : secession = {}", member);
		try {
			mapper.deleteMember(member);
			return ResponseEntity.status(HttpStatus.OK).body(responseDto.successSecession());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto.failSecession());
		}
	}


}
