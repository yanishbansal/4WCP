package com.Starapp.Starapp.dto.response;
import java.util.List;

import lombok.Data;

@Data
public class ResourceDetails {
	private Long userId;
	private String name;
	private String email;
	private List<String> projects;
	private List<String> vertical;
	private List<String> horizontal;
	private List<String> subHorizontal;	
}
