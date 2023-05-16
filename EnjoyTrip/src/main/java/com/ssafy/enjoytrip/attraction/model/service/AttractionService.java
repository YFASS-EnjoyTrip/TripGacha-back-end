package com.ssafy.enjoytrip.attraction.model.service;

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
import com.ssafy.enjoytrip.attraction.dto.ReviewDto;
import com.ssafy.enjoytrip.attraction.dto.SearchDto;
import com.ssafy.enjoytrip.response.AttractionResponseDto;
import com.ssafy.enjoytrip.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AttractionService {

    List<AttractionDto> getLocations(Map<String, Integer> param) throws Exception;

    List<AttractionDto> searchLocations(SearchDto searchDto) throws Exception;

    ResponseEntity<ResponseDto> searchLocationDetail(String contentId);

    ResponseEntity<ResponseDto> locationReviews(String contentId) ;

    ResponseEntity<ResponseDto> saveLocationReview(ReviewDto review) throws Exception;

    ResponseEntity<ResponseDto> saveLocationLike(Map<String, String> param) ;

    List<Map<String, String>> getGugunCode(String sido) throws Exception;
}
