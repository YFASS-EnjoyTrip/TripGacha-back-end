package com.ssafy.enjoytrip.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ssafy.enjoytrip.member.dto.MemberDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class MemberResponseDto {
	private int status;
	private String message;
	private Object result;

	public MemberResponseDto successLogin(MemberDto member) {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.OK.value());
		res.setMessage("로그인 정상적으로 수행");
		res.setResult(member.getNickname());
		return res;
	}

	public MemberResponseDto failLogin() {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setMessage("아이디와 비밀번호를 확인해주세요");
		return res;
	}

	public MemberResponseDto successLogout() {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.OK.value());
		res.setMessage("로그아웃 정상적으로 수행");
		return res;
	}

	public MemberResponseDto successSignup() {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.OK.value());
		res.setMessage("회원가입 정상적으로 수행");
		return res;
	}

	public MemberResponseDto failSignup() {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.OK.value());
		res.setMessage("회원 가입에 실패하였습니다.");
		return res;
	}

	public MemberResponseDto available(String check) {
		MemberResponseDto res = new MemberResponseDto();
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage(check + " 은 사용 가능합니다.");
		return res;
	}
	public MemberResponseDto unavailable(String check) {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setMessage(check + " 은 이미 존재합니다.");
		return res;
	}

	public MemberResponseDto successSecession() {
		MemberResponseDto res = new MemberResponseDto();
		
		res.setStatus(HttpStatus.OK.value());
		res.setMessage("회원 탈퇴가 정상적으로 이루어졌습니다.");
		return res;
	}

	public MemberResponseDto failSecession() {
		MemberResponseDto res = new MemberResponseDto();

		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setMessage("서버에 문제가 생겼습니다.");
		return res;
	}

}
