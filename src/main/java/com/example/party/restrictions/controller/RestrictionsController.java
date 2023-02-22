package com.example.party.restrictions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.party.global.common.ApiResponse;
import com.example.party.global.common.DataApiResponse;
import com.example.party.restrictions.dto.BlockResponse;
import com.example.party.restrictions.dto.ReportPostRequest;
import com.example.party.restrictions.dto.ReportUserRequest;
import com.example.party.restrictions.service.RestrictionsService;
import com.example.party.user.entity.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restrictions")
public class RestrictionsController {

	private final RestrictionsService restrictionsService;

	//차단등록
	@PostMapping("/block/{userId}")
	public ResponseEntity<ApiResponse> blockUser(@PathVariable Long userId,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.blockUser(userId, user));
	}

	//차단해제
	@DeleteMapping("/block/{userId}")
	public ResponseEntity<ApiResponse> unBlockUser(@PathVariable Long userId,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.unBlockUser(userId, user));
	}

	//차단목록 조회
	@GetMapping("/block")
	public ResponseEntity<DataApiResponse<BlockResponse>> getBLockedUsers(@RequestParam int page,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.blocks(page - 1, user));
	}

	//유저 신고
	@PostMapping("/report/users")
	public ResponseEntity<ApiResponse> reportUsers(@RequestBody ReportUserRequest request,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.reportUsers(user, request));
	}

	//모집글 신고
	@PostMapping("/report/party-posts")
	public ResponseEntity<ApiResponse> reportPosts(@RequestBody ReportPostRequest request,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.reportPosts(user, request));
	}

	//노쇼 신고
	@PostMapping("/noShow/{userId}")
	public ResponseEntity<ApiResponse> noShowReport(@PathVariable Long userId,
		@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(restrictionsService.reportNoShow(user, userId));
	}
}
