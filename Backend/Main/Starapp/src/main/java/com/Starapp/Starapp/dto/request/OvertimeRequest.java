package com.Starapp.Starapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OvertimeRequest {
	private Long id;
	private Long userId;
	private String responseText;
	private Boolean isApproved;
}
